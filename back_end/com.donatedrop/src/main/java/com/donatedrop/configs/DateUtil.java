/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.configs;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dell-3460
 */
public class DateUtil
    {
        private static Date date;
        
        public static Date getDate()
            {
                if( date == null )
                  {
                    date = new  Date();
                  }
                return date;
            }
    }
