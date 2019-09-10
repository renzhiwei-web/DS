package com.algorithm;
/**
 * 背包问题是动态规划算法的经典应用，
 * 动态规划算法与分治算法类似，但是又不一样，分治算法的每种情况都是独立的
 * @author 任志伟
 *
 */
public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {1,4,3};//物品的重量
		int[] val = {1500,3000,2000};//物品的价值
		int m = 4;//背包的容量
		int n = val.length;
		//创建二维数组
		//表示在前i个物品中能够装入容量为j的背包中的最大价值
		int[][] v = new int[n+1][m+1];
		
		//为了记录放入商品的情况
		int[][] path = new int[n+1][m+1];
		//初始化第一行和第一列，这里在本程序中，可以不去处理，因为默认就是0
		for(int i = 0;i < v.length;i++){
			v[i][0] = 0;//将第一列设置为0
		}
		for(int i = 0;i < v[0].length;i++){
			v[0][i] = 0;//将第一行设置为0
		}
		//根据得到的公式来动态规划处理
		for(int i = 1;i < v.length;i++){
			for(int j = 1;j < v[0].length;j++){
				if (w[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				}else {
//					v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
					if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
						path[i][j] = 1;
					}else {
						v[i][j] = v[i - 1][j];
					}
				}
			}
		}
		for(int i = 0;i < v.length;i++){
			for(int j = 0;j < v[i].length;j++){
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
		int i = path.length - 1;
		int j = path[0].length - 1;
		while(i > 0 && j > 0){
			if (path[i][j] == 1) {
				System.out.printf("第%d个商品放入背包问题\n",i);
				j -= w[i - 1];
			}
			i--;
		}
	}

}
