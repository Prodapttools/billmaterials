
package com.example.mathservice;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;

@Service
public class MyMath {
    private static final DecimalFormat format = new DecimalFormat("#");

    public MyMath() {
        super();
    }

    public static double round(double val) {
        double rounded = 0.00;
        try {
            format.setMinimumFractionDigits(2);
            rounded = Double.parseDouble(format.format(val));
            System.out.println("Rounded Value----------->" + rounded);
        } catch (Exception e) {
            // Log the exception using SLF4J or another logging framework
        }
        return rounded;
    }

    public static double roundTo4(double val) {
        double rounded = 0.00;
        try {
            format.setMinimumFractionDigits(4);
            rounded = Double.parseDouble(format.format(val));
        } catch (Exception e) {
            // Log the exception
        }
        return rounded;
    }

    public static double roundTo3(double val) {
        double rounded = 0.00;
        try {
            format.setMinimumFractionDigits(3);
            rounded = Double.parseDouble(format.format(val));
        } catch (Exception e) {
            // Log the exception
        }
        return rounded;
    }

    public static double numeric(String value) {
        try {
            if (value != null)
                return Double.parseDouble(value);
            else
                return 0;
        } catch (Exception e) {
            // Log the exception
        }
        return 0;
    }

    public static double numeric(Object value) {
        try {
            if (value != null)
                return Double.parseDouble(String.valueOf(value));
            else
                return 0;
        } catch (Exception e) {
            // Log the exception
        }
        return 0;
    }

    public static double nvl(double a, double b) {
        return Double.isNaN(a) ? b : a;
    }

    public static double changeToDouble(double n) {
        if (Double.isNaN(n) || Double.isInfinite(n)) {
            return 0;
        }
        return n;
    }

    public static String changeToString(Object o) {
        String val = null;
        try {
            if (o != null)
                val = o.toString();
        } catch (Exception e) {
            // Log the exception
            val = null;
        }
        return val;
    }

    public static BigDecimal toBigDecimal(double n) {
        return BigDecimal.valueOf(n);
    }

    public static double roundUp(double n) {
        String value = String.valueOf(n);
        if (!value.contains(".")) {
            return n;
        }
        BigDecimal bdTest1 = new BigDecimal(value);
        return bdTest1.setScale(0, BigDecimal.ROUND_CEILING).doubleValue();
    }

    public static double roundDown(double n) {
        BigDecimal bdTest1 = new BigDecimal(n);
        return bdTest1.setScale(0, BigDecimal.ROUND_DOWN).doubleValue();
    }
}
