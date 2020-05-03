package jv.silver.thirteen.ex6.b;

import jv.silver.thirteen.ex6.a.A;

public class B extends A {
	public void test(){
		//String test1 = new B().a; // a' is not public in 'jv.silver.thirteen.ex6.a.A'. Cannot be accessed from outside package
		String test2 = new B().b;
		String test3 = new B().c;
	}
}
