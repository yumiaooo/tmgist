package com.creditease.tradematch.tmfront.gist.util;

/**
 *
 */
public class StringFormatGist {
    public static final String DEDUPER_KEY_TPL = "cache.deduper:%s:%s:%s";
    public static void main(String[] argv) {
        String serviceName = "invest.req";
        String systemSign = null;
        String requestId = null;

        String redisKey = String.format(DEDUPER_KEY_TPL, serviceName, systemSign, requestId);

        System.out.println(redisKey);
    }
}
