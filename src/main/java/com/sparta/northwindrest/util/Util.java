package com.sparta.northwindrest.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class Util {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Instant getDateAsInstant(String date) {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(date).toInstant();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
