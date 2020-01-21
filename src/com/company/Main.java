package com.company;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

class Car {
    private float fuel;
    private float XCoordinate;
    final private float consumption;

    public Car(float consumption) {
        this.consumption = consumption;
        this.fuel = 0;
        this.XCoordinate = 0;
    }

    private float getFuel() {
        return fuel;
    }

    private float getXCoordinate() {
        return XCoordinate;
    }

    private float getConsumption() {
        return consumption;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    private void setXCoordinate(float XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public void addFuel(float galons) {
        setFuel(getFuel() + galons);
    }

    public void drive(float miles) {
        float maxMiles = this.getFuel() / this.getConsumption();
        miles = Math.min(maxMiles, miles);
        float fuelRequired = miles * this.getConsumption();
        this.setXCoordinate(this.getXCoordinate() + miles);
        this.setFuel(this.getFuel() - fuelRequired);
    }
}

interface Transformer {
    Transformer translate(float x, float y);

    Transformer scale(float factor);

    BasePoint getPoint();
}

/**
 * A new class to implement all this stuff.
 *
 * @version 2.1
 */
class MutatorTransformer implements Transformer {

    private BasePoint point;

    public MutatorTransformer() {
        this.point = new BasePoint();
    }

    /**
     * Returns immutable point on every method call.
     * <p>
     * For every call this will create a new instance
     * of BasePoint.
     * </p>
     *
     * @param x X value of the new point position
     * @param y Y value of the new point position
     * @return an updated MutatorTransformer to use chaining.
     * @author Roman Nevezhyn
     * @see BasePoint
     */
    public MutatorTransformer translate(float x, float y) {
        this.point = new BasePoint(this.point.getX() + x,
                this.point.getY() + y);
        return this;
    }

    /**
     * @param factor
     * @return
     */
    public MutatorTransformer scale(float factor) {
        this.point = new BasePoint(this.point.getX() * factor, this.point.getY() * factor);
        return this;
    }

    public BasePoint getPoint() {
        return this.point;
    }
}

interface GeometricPoint {
    float x = 0.0f;
    float y = 0.0f;

    float getX();

    float getY();

//    float setY();
//
//    float setX();
}

class BasePoint implements GeometricPoint {
    public float x = 0.0f;
    public float y = 0.0f;

    public BasePoint() {
        this(0, 0);
    }

    public BasePoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public String coordinates() {
        return "X: " + this.getX() + " " + "Y: " + this.getY();
    }

}

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

    private static boolean checkMatrix(int[][] rows) {
        int rowsSum = 0, colsSum = 0, diagonalSum = 0;
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length; j++) {
                rowsSum += rows[i][j];
            }
        }
        return rowsSum == colsSum && rowsSum == diagonalSum;
    }

    private static void task1_14(String[] params) {
        Scanner in = new Scanner(System.in);
        int[][] rows = new int[5][5];
        int rowIndex = 0;
        boolean working = true;
        while (working && in.hasNextLine()) {
            int colIndex = 0;
            String line = in.nextLine();
            if (line.isEmpty()) {
                System.out.println("Bue!!!");
                working = false;
            } else {
                String[] values = line.split(" ");
                in.nextInt();
                for (String value : values) {
                    if (!value.isEmpty()) {
                        rows[rowIndex][colIndex] = Integer.parseInt(value);
                        colIndex += 1;
                    }
                }
                rowIndex += 1;
            }
        }
        System.out.println(Arrays.deepToString(rows));
    }

    private static void task2_5(String[] params) {
        MutatorTransformer tr = new MutatorTransformer();
        System.out.println(tr.translate(4, 2).getPoint().coordinates());
        System.out.println(tr.scale(2.5547f).getPoint().coordinates());
        System.out.println(tr.translate(12, 55).scale(2).getPoint().coordinates());
    }

    private static void task2_9(String[] params) {
        Car car = new Car(10f);
        car.addFuel(100f);
        car.drive(3.5f);
        System.out.println("Hallo");
        car.drive(5f);
        car.drive(10f);
        System.out.println("Hallo");
    }

    private static void task2_1(String[] params) {
        int year = Integer.parseInt(params[0]);
        int month = Integer.parseInt(params[1]);

//        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        LocalDate date = LocalDate.of(year, month, 1);
        DayOfWeek start = date.getDayOfWeek();
        int value = start.getValue();
        for (int i = 0; i < value; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month) {
            int weekday = date.getDayOfYear() + 1;
            if (weekday % 6 == 0) {
                System.out.print("\n");
            }
            String format;
            if (date.getDayOfMonth() > 9){
                format = "%4d";
            }
            else {
                format = "%3d";
            }
            System.out.printf(format, date.getDayOfMonth());
            date = date.plusDays(1);
        }
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
            case "-t114":
                task1_14(params);
                break;
            case "-t21":
                task2_1(params);
                break;
            case "-t25":
                task2_5(params);
                break;
            case "-t29":
                task2_9(params);
                break;
            default:
                System.out.printf("Unknown parameter: %s", task);
        }
    }
}
