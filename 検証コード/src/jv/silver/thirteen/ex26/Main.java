package jv.silver.thirteen.ex26;

public class Main {
	int num;
	private static void test(){
		//num++; // 非 static フィールド 'num' は static コンテキストから参照できません
		//System.out.println(num);
	}
	public static void main(String[] args){
		Main.test();
		Main.test();
	}
}
