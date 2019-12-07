//package edu.neu.coe.info6205.life.userInterface;
//
//import java.util.Random;
//
//public class Cell {
//    public float x, y;
//    public float w;
//
//    public int state;
//    public int previous;
//
//    public Cell(float x_, float y_, float w_) {
//        x = x_;
//        y = y_;
//        w = w_;
//
//        Random random = new Random();
//        state = random.nextInt(99);
//        previous = state;
//    }
//
//    public void savePrevious() {
//        previous = state;
//    }
//
//    public void newState(int s) {
//        state = s;
//    }
//
//    public void display() {
//        if (previous == 0 && state == 1) fill(0,0,255);
//        else if (state == 1) fill(0);
//        else if (previous == 1 && state == 0) fill(255,0,0);
//        else fill(255);
//    }
//
//    private void fill(int r, int g, int b) {
//
//    }
//}
