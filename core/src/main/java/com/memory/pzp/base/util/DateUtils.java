package com.memory.pzp.base.util;

import java.util.Date;

/**
 * Created by wall on 2017/9/15.
 */
public class DateUtils {

    public static long interval(Date layUpDate, Date currentDate){

        return (currentDate.getTime()-layUpDate.getTime())/1000;

    }

}
