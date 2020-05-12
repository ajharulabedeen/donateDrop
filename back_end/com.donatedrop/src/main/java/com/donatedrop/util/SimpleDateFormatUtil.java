/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.util;

import java.text.SimpleDateFormat;

/**
 * @author Dell-3460
 */
public class SimpleDateFormatUtil {
    private static SimpleDateFormat simpleDateFormat;

    public static SimpleDateFormat getSimpleDateFormat() {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("dd MMM, YYYY  HH:mm:ss a");
        }
        return simpleDateFormat;
    }

//    public static void main(String[] args) {
//        System.out.println(GetDate.getDate());
//    }

}
