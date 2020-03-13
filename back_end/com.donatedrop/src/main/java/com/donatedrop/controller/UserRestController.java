package com.donatedrop.controller;

import com.donatedrop.repo.UserRepository;
import com.donatedrop.security.JwtTokenUtil;
import com.donatedrop.security.JwtUser;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.zerhusen.security.JwtTokenUtil;
//import org.zerhusen.security.JwtUser;


import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.zerhusen.security.repository.UserRepository;


@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "userName", method = RequestMethod.GET)
    public String getAuthenticatedUserName(HttpServletRequest request, Principal principal) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//        return user.getId().toString();
//        System.out.println("\nGetName:: \n"+SecurityContextHolder.getContext().getAuthentication().getName());;
        System.out.println("\nGetNameAuth:: \n" + auth.getName());
        System.out.println("\nGetName:: \n" + principal.getName());
        return username;
    }

    @PostMapping(value = "userRegistration")
    public String getAuthenticatedUserRegistration(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
//        Bcrypt 
        return passwordEncoder.encode(user.getUsername().toString());
    }

    @GetMapping(value = "test")
    public String test() {
        return "@GetMapping(value = \"test\")";
    }
}
