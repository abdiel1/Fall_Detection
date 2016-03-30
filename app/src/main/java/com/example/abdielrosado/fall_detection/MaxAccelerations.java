package com.example.abdielrosado.fall_detection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdielrosado on 2/4/16.
 */
public class MaxAccelerations{
    private double lateral_acceleration;
    private double maxX;
    private double maxY;
    private double maxZ;


    public MaxAccelerations(){
        this.lateral_acceleration = 0;
        this.maxX = 0;
        this.maxY = 0;
        this.maxZ = 0;
    }

    public void clear(){
        this.lateral_acceleration = 0;
        this.maxX = 0;
        this.maxY = 0;
        this.maxZ = 0;
    }

    public void setLateralMaximums(double x, double y){
        this.maxX = x;
        this.maxY = y;

    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMaxZ() {
        return maxZ;
    }

    public void setMaxZ(double maxZ) {
        this.maxZ = maxZ;
    }
    public double getLateral_acceleration() {
        return lateral_acceleration;
    }

    public void setLateral_acceleration(double lateral_acceleration) {
        this.lateral_acceleration = lateral_acceleration;
    }
}
