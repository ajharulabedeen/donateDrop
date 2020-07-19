/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.post;

import java.util.List;
import java.util.Map;

import com.donatedrop.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dell
 */
@RestController
@RequestMapping("/public/user/post")
public class ControllerPost {

    @Autowired
    Service_Post_I service_post_i;

    @PostMapping("save")
    public Map<String, String> savePost(@RequestBody Post post) {
        post.setPostUserID(Utils.getLoggedUserID());
        return service_post_i.savePost(post);
    }

    @PostMapping("getAllPostsByAnUser")
    public List<Post> getAllPostsByAnUser(@RequestBody PostSearch postSearch) {
        postSearch.setUserID(Utils.getLoggedUserID());
        return service_post_i.getAllPostsByAnUser(postSearch);
    }

    @PostMapping("countAllPostsByAnUser")
    public String countAllPostsByAnUser(@RequestBody PostSearch postSearch) {
        postSearch.setUserID(Utils.getLoggedUserID());
        return service_post_i.countAllPostsByAnUser(postSearch);
    }

    @PostMapping("getAllPostsByAnUserWithinDate")
    public List<Post> getAllPostsByAnUserWithinDate(@RequestBody PostSearch postSearch) {
        postSearch.setUserID(Utils.getLoggedUserID());
        return service_post_i.getAllPostsByAnUser(postSearch);
    }

}
