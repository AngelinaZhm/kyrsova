package org.fleet.utils;

public class Utils {
    public static int factorial (int n) {
        if (n < 0) throw new IllegalArgumentException("Від’ємне число не допускається");
        return (n==0) ? 1 : n * factorial(n-1);
    }
}
