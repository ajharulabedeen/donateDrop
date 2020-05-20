/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dell-3460
 */
public class DateUtil {

    private static SimpleDateFormat simpleDateFormat;

    public static SimpleDateFormat getSimpleDateFormat() {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        }
        return simpleDateFormat;
    }

//    public static Date getDate() {
//        SimpleDateFormat dateFormat = getSimpleDateFormat();
//        Date date = new Date();
//        return dateFormat.format(date);
//    }

    public static void main(String[] args) {
        System.out.println(GetDate.getDate());
    }
}
