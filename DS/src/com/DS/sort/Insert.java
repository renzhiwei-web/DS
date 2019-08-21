package com.DS.sort;

import java.util.Arrays;

public class Insert implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int index;
		for(int i = 1;i < demo.length;i++){
			for(int j = 0;j < i;j++){
				if (demo[i] < demo[j]) {
					index = demo[i];
					for(int y = i;y > j;y--){
						demo[y] = demo[y - 1];
					}
					demo[j] = index;
				}
			}
		}
		//System.out.println(Arrays.toString(demo));
	}

}
