/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.app.collector.services;

import java.util.Random;

/**
 *
 * @author armena
 */
public enum Direction {
    
    EAST, WEST, SOUTH, NORTH;

    private static final Random PRNG = new Random();

    public static Direction randomDirection() {
        Direction[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }

}
