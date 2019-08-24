package com.DS.sort;

public class Radix implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int[][] bucket = new int[10][demo.length];//使用空间换时间的经典算法
		int max = demo[0];//最大的值
		//先得到最大值
		for(int i = 1;i < demo.length;i++)
			if (demo[i] > max) {
				max = demo[i];
			}
		int maxLength = (max + "").length();//得到最大的位数
		//为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录每个桶的每次放入的数据个数
		int[] bucketElementCounts = new int[10];
		
		for(int i = 0,n = 1;i < maxLength;i++,n *= 10){
			
			for(int j = 0;j < demo.length;j++){
				int digitOfElement = demo[j] /n % 10;//取出每个元素的个,十，百等位的值
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = demo[j];
				bucketElementCounts[digitOfElement]++;//每个桶中已经放入了几个元素
			}
			int index = 0;
			for(int k = 0;k < bucketElementCounts.length;k++){
				if (bucketElementCounts[k] != 0) {//判断每个桶中是否有值
					for(int l = 0;l < bucketElementCounts[k];l++){
						demo[index++] = bucket[k][l];//将桶中的元素一次放回数组
					}
				}
				bucketElementCounts[k] = 0;//每轮处理后需要将每个桶重置,不需要真正的重置桶中的元素，只要把记录桶中已经放入几个元素的数组重置即可
			}
		}
		
		
		
		
		
		
	}

}
