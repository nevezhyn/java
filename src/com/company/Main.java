package com.company;

import java.math.BigInteger;
import java.util.*;

public class Main {
    private static void task1_1(String[] args) {
        // -t11 3233 32 12
        System.out.println();
        for (String arg : args) {
            int value = Integer.parseInt(arg);
            System.out.printf("Integer: %s\n", value);
            System.out.printf("Octal: %s\n", Integer.toOctalString(value));
            System.out.printf("Hexadecimal: %s\n", Integer.toHexString(value));
            System.out.printf("Binary: %s\n", Integer.toBinaryString(value));
            System.out.println();
        }
    }

    private static void task1_2(String[] args) {
        // -t12 -3233
        for (String value : args) {
            int angle = Integer.parseInt(value);
            if (angle < 0) angle *= -1;
            int normalized = angle % 360;
            System.out.printf("For angle: %s, normalized angle is: %d\n", value, normalized);
            System.out.printf("For angle: %s, normalized angle is: %d\n", value, Math.floorMod(angle, 360));
            System.out.println();
        }
    }

    private static void task1_3(String[] args) {
        // -t13 33 12 4
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[1]);
        int val3 = Integer.parseInt(args[2]);

        boolean withMath = false;

        if (withMath) {
            int max = Math.max(val1, val2);
            max = Math.max(max, val3);
            System.out.println(max);
        } else {
            if (val1 >= val2 && val1 >= val3) {
                System.out.println(val1);
            } else if (val2 >= val1 && val2 >= val3) {
                System.out.println(val2);
            } else System.out.println(val3);
        }
    }

    private static void task1_4(String[] params) {
        // params -t14
        System.out.println(Double.MIN_VALUE);
        double b = 0.0d;
        System.out.println(Math.nextUp(b));
        System.out.println();
        System.out.println(Double.MAX_VALUE);
        System.out.println("Parsed");

        System.out.println(Double.parseDouble("0x1.fffffffffffffP+1023"));
        System.out.println((int) Double.parseDouble("999999999999999999999999999999999999999"));
        System.out.println(Integer.MAX_VALUE);
    }

    private static void task1_6(String[] params) {
        // params -t16 20
        int n = Integer.parseInt(params[0]);
//        int result = 1;
        BigInteger result = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
//            result *= i;
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }

    private static void task1_8(String[] params) {
        // params -t17
        String qwe = "Roma Ivan Alex";
        System.out.println(Arrays.toString(qwe.split(" ")));
        for (String a : qwe.split(" ")) {
            System.out.println(a);
        }
    }

    private static void task1_9(String[] params) {
        String first = params[0];
        String second = params[1];
        if (first.length() != second.length()) {
            System.out.println("False");
            return;
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }

    private static void task1_10(String[] params) {
        Random generator = new Random();
        long next = generator.nextLong();
        System.out.println(Long.toString(next, 36));
    }

    private static void task1_11(String[] params) {
        String str = params[0];
        for (int i = 0; i < str.length(); i++) {
            if (str.codePointAt(i) > 127) System.out.println(str.charAt(i));
        }
    }

    private static void task1_13(String[] params) {
        ArrayList<Integer> pool = new ArrayList<>();
        ArrayList<Integer> selected = new ArrayList<>();
        Random generator = new Random();

        for (int i = 1; i <= 49; i++) {
            pool.add(i);
        }

        for (int i = 0; i < 6; i++) {
            int index = generator.nextInt(pool.size());
            selected.add(pool.get(index));
            pool.remove(index);
        }

        selected.sort(Comparator.reverseOrder());
        System.out.println(selected.toString());
        System.out.println(pool.toString());
    }

    public static void main(String[] args) {
        String task = args[0];
        String[] params = Arrays.copyOfRange(args, 1, args.length);
        switch (task) {
            case "-t11":
                task1_1(params);
                break;
            case "-t12":
                task1_2(params);
                break;
            case "-t13":
                task1_3(params);
                break;
            case "-t14":
                task1_4(params);
                break;
            case "-t16":
                task1_6(params);
                break;
            case "-t18":
                task1_8(params);
                break;
            case "-t19":
                task1_9(params);
                break;
            case "-t110":
                task1_10(params);
                break;
            case "-t111":
                task1_11(params);
                break;
            case "-t113":
                task1_13(params);
                break;
            default:
                System.out.printf("Unknown parameter: %s", task);
        }
    }
}
