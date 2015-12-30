package com.creditease.tradematch.tmfront.gist.util;

/**
 *
 */
public class IdeaRunnerGist {
    public static void main(String[] argv) {
        System.out.println(System.getProperty("foo", "default"));
//        System.clearProperty("socksProxyHost");
        System.out.println(System.getProperty("socksProxyHost", "default"));
        System.out.println(System.getProperty("socksProxyPort", "default"));
        System.out.println(System.getProperty("java.net.socks.username", "default"));
    }
}
