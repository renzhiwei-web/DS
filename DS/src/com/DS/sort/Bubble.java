package com.DS.sort;

import java.util.Arrays;

public class Bubble implements Sort{

	

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		for(int i = 0;i < demo.length - 1;i++){
			for(int j = 0;j < demo.length - i - 1;j++){
				if (demo[j] > demo[j + 1]) {
					int temp = demo[j];
					demo[j] = demo[j + 1];
					demo[j + 1] = temp;
				}
			}
			System.out.println(Arrays.toString(demo));
		}
		System.out.println("最终的排序结果" + Arrays.toString(demo));
	}

}
