package com.creditease.tradematch.tmfront.gist.util;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

/**
 *
 */
public class JodaTimeGist {
    public static void main(String[] argv) {
        DateTime dateTime = new DateTime(Long.valueOf("1446720530000"));

        System.out.println(dateTime);

        DateTime dt2 = DateTime.now();
        System.out.println(dt2.toString("yyyy-MM-dd'T'HH:mm:ss"));
        System.out.println(dt2.toString(ISODateTimeFormat.dateTime()));

    }
}
