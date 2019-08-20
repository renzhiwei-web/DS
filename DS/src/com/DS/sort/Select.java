package com.DS.sort;

import java.util.Arrays;

public class Select implements Sort {

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int i,j,min = 0;
		for(i = 0;i < demo.length - 1;i++){
			min = i;
			for(j = i + 1;j < demo.length;j++){
				
				if (demo[min] > demo[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = demo[i];
				demo[i] =demo[min];
				demo[min] = temp;
			}
		}
		System.out.println(Arrays.toString(demo));
	}

}
