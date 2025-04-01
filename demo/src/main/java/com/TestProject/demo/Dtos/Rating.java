package com.TestProject.demo.Dtos;


import lombok.Data;

@Data
public class Rating {
    private double rate;
    private int count;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    // Getter and Setter for Count
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
