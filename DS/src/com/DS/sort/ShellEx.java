package com.DS.sort;

import java.util.Arrays;
/**
 * 希尔排序是插入排序的改进，通过逐渐减小增量来进行插入排序
 * 希尔排序与增量的设定有关
 * @author 任志伟
 *
 */
public class ShellEx implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int temp;
		for(int gap = 5;gap > 0;gap /= 2){
			for(int i = gap;i < demo.length;i++){
				for(int j = i - gap;j >=  0;j -= gap){
					if (demo[j] > demo[j + gap]) {
						temp =demo[j];
						demo[j] =demo[j + gap];
						demo[j + gap] = temp;
					}
				}
			}
		}
		System.out.println(Arrays.toString(demo));
	}

}
