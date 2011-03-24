package no.ntnu.capgeminitest.util;

public class ObjectUtil {
    public static boolean equals(Object a, Object b) {
        return a != null && a.equals(b) || a == b;
    }
}