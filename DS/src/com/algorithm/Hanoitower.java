package com.algorithm;
/**
 * 汉诺塔是分治算法的经典应用
 * 分治算法分为3步
 * 1.将问题分解成若干规模较小，相互独立，与原问题形式相同的子问题
 * 2.解决：若问题规模较小而容易被解决则直接解决，否则递归地解各个问题
 * 3.合并：将各个子问题的解合并成原问题的解
 * @author 任志伟
 *
 */
public class Hanoitower {
	public static void main(String[] args) {
		hanoiTower(4, 'A', 'B', 'C');
	}
	/**
	 * 
	 * @param num 盘的个数
	 * @param a	要移动的盘所在的塔
	 * @param b	移动过程中过度的塔
	 * @param c	要移动到的塔
	 */
	public static void hanoiTower(int num,char a,char b,char c){
		if(num == 1){
			System.out.println("第1个盘从" + a + "->" + c);
		}else {
			//如果有n>= 2的情况，我们总是可以看作是两个盘1.是最下边的一个盘2.上面所有的盘
			//1.先把最上面的所有盘A->B，移动过程会使用到C
			hanoiTower(num - 1, a, c, b);
			//2.把最下面的盘移动到C盘
			System.out.println("第" + num +"个盘从" + a +"->" + c);
			//3.把B上面所有的盘移动到c，移动过程中使用A
			hanoiTower(num - 1, b, a, c);
		}
	}
}
