package com.DS.Recursion;

public class Queen {
	
	int max = 8;//定义共有多少个皇后
	int[] array = new int[max];
	static int count;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queen queen = new Queen();
		queen.print();
		queen.check(0);
		System.out.println("总共有" + count);
		
	}
	/**
	 * 打印八皇后的数组
	 */
	private void print(){
		for(int i = 0;i < array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	/**
	 * 判断皇后之间是否可以攻击
	 * @param n 八皇后问题的第N个皇后
	 * @return
	 */
	private boolean judge(int n){
		for(int i = 0;i < n;i++){
			//判断是否是在同一列或者同一斜线
			//在array[n] = val中，n是行，val是列，一个点的行、列减去另一个点的行、列，得到的行等于列就是斜线
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 放置第N个皇后
	 * @param n
	 */
	private void check(int n){
		if (n == max) {
			count++;
			print();
			return;
		}
		for(int i = 0;i < max;i++){
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}
}
