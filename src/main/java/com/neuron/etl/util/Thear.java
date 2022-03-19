package com.neuron.etl.util;

/**
 * @Author: FengJie
 * #Description: Thear
 * #Date: 2021/6/26 02:05
 */
public class Thear implements Runnable{
    private String phone;
    public Thear(String phone){
        this.phone=phone;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
