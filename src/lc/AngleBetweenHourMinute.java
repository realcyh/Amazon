package lc;

import java.util.*;

public class AngleBetweenHourMinute {
    public double findAngle(double hour, double minute) {
        double angleHour = hour/12*360 + minute/60*30;
        if (angleHour>360) angleHour -= 360;
        double angleMinute = minute/60*360;
        double angle = angleHour > angleMinute ? angleHour-angleMinute : angleMinute-angleHour;
        // double angle = Math.abs(angleHour - angleMinute);
        if (angle>180) {
            angle = 360-angle;
        }
        // angle = Math.min(angle, 360-angle);
        return angle;
    }

    public static void main(String[] args) {
        double hour = 2;
        double minute = 60;
        AngleBetweenHourMinute a = new AngleBetweenHourMinute();
        double res = a.findAngle(hour, minute);
        System.out.println(res);

    }
}
