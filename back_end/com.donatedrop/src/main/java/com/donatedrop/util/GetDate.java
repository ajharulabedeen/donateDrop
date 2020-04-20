package com.donatedrop.util;

//import static SpringContextSingletron.applicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate
    {

    public static String getDate()
        {
            SimpleDateFormat dateFormat = SimpleDateFormatUtil.getSimpleDateFormat();
            Date date = DateUtil.getDate();
            return dateFormat.format(date);
        }
    }
