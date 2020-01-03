package com.company;

import java.util.Arrays;

public class Main {
    private static void task1_1(String[] args) {
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
        for (String value : args){
            int angle = Integer.parseInt(value);
            if (angle < 0) angle *= -1;
            int normalized = angle % 360;
            System.out.printf("For angle: %s, normalized angle is: %d\n", value, normalized);
            System.out.printf("For angle: %s, normalized angle is: %d\n", value, Math.floorMod(angle, 360));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String task = args[0];
        String[] params = Arrays.copyOfRange(args, 1, args.length);
        if (task.equals("-t11")) task1_1(params);
        else if (task.equals("-t12")) task1_2(params);
    }
}
