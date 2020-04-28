package jv.silver.twelve.ex42;

import jv.silver.twelve.ex42.a.A;
import jv.silver.twelve.ex42.b.B;

public class Main {

    public void main(String[] args) {
        A a = new B();
        System.out.println(a.x);
    }
}
