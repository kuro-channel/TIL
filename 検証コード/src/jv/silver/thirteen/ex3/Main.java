package jv.silver.thirteen.ex3;

public class Main {

    public void main(String[] args) {
        int a = 10;
        float b = 10.0f;
        double c = 20;
        a = (int) b; // int型にキャストする
        b = a;
        c = b;
        c = a;
    }
}
