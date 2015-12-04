package com.creditease.tradematch.tmfront.gist.util;

import com.google.common.base.Strings;

/**
 *
 */
public class GuavaStringsGist {
    public static void main(String[] argv) {
//        String x = "1";
//        String xx = "10";
//        String xxx = "100";
//        String xxxxxx = "100000";
//        String xxxxxxx = "1000000";

        String[] xs = {"1", "10", "100", "1000", "10000", "100000", "1000000", "10000000"};

        for (String x : xs) {
            System.out.println(Strings.padStart(x, 7, '0'));
        }
    }
}
