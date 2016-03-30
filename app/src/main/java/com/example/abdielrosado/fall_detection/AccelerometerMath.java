package com.example.abdielrosado.fall_detection;



/**
 * Created by abdielrosado on 1/31/16.
 */
public class AccelerometerMath {

    //Conversion factor between m/s^2 to Gs
    public static final double G_CONVERSION_FACTOR = 0.101971621;



    public static void processSample(MaxAccelerations maximums, double x, double y, double z){
        //Convert to Gs
        x = x * G_CONVERSION_FACTOR;
        y = y * G_CONVERSION_FACTOR;
        z = z * G_CONVERSION_FACTOR;

        double lateral_acceleration = Math.sqrt(x*x + y*y);
        if(lateral_acceleration > maximums.getLateral_acceleration()){
            maximums.setLateral_acceleration(lateral_acceleration);
            maximums.setLateralMaximums(x,y);
        }

        if(z > maximums.getMaxZ()){
            maximums.setMaxZ(z);
        }
    }

}
