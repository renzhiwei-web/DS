package com.DS.sort;

import java.util.Arrays;

/**
 * 冒泡排序的改进：设定一个标志来表示某一趟排序是否交换过数据，若没有则不必再进行排序
 * @author 任志伟
 *
 */
public class Bubble2 implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		boolean flag = false;//设置一个标识
		for(int i = 0;i < demo.length - 1;i++){
			for(int j = 0;j < demo.length - i - 1;j++){
				if (demo[j] > demo[j + 1]) {
					flag = true;
					int temp = demo[j];
					demo[j] = demo[j + 1];
					demo[j + 1] = temp;
				}
				if (!flag) {
					break;
				} else {
					flag = false;
				}
			}
			System.out.println(Arrays.toString(demo));
		}
		System.out.println("最终的排序结果" + Arrays.toString(demo));
	}

}
