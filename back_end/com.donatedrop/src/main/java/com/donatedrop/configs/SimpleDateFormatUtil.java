/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.configs;

import java.text.SimpleDateFormat;

/**
 *
 * @author Dell-3460
 */
public class SimpleDateFormatUtil
    {
        private static SimpleDateFormat simpleDateFormat;
        
        public static SimpleDateFormat getSimpleDateFormat()
            {
                if( simpleDateFormat == null )
                  {
                    simpleDateFormat = new  SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                  }
                return simpleDateFormat;
            }
    }
