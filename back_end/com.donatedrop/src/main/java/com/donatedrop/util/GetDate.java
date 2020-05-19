package com.donatedrop.util;

//import static SpringContextSingletron.applicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

    public static String getDate() {
        SimpleDateFormat dateFormat = DateUtil.getSimpleDateFormat();
//            Date date = DateUtil.getDate();
        Date date = new Date();
        return dateFormat.format(date);
    }
}
