package com.creditease.tradematch.tmfront.gist.util;

/**
 *
 */
public class ExceptionGist {
    public static void main(String[] argv) {
        ExceptionGist gist = new ExceptionGist();
        gist.catchThenThrow();
    }

    public void catchThenThrow() {
        try {
            throwing();
        } catch (NullPointerException ne) {
            System.out.println("about to throw");
            throw new IllegalArgumentException("illegal", ne);
        } catch (IllegalArgumentException ie) {
            System.out.println("in");
        } finally {
            System.out.println("finally.");
        }
        System.out.println("END.");
    }

    public void throwing() throws NullPointerException {
        throw new NullPointerException("throwing");
    }
}
