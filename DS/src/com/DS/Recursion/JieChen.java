package com.DS.Recursion;

public class JieChen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(3));
	}

	public static int f(int n){
		if (n == 1) {
			return 1;
		}
		return f(n -1) * n;
	}
}
