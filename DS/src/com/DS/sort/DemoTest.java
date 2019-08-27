package com.DS.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DemoTest {

	public static void main(String[] args) {
		int demo[] = {53,3,542,748,14,214};
		
		int[] arr = new int[80000];
		for(int i = 0;i < 80000;i++)
			arr[i] = (int) (Math.random() * 8000000);
		/*Ã°ÅÝÅÅÐò
		 * Bubble bubble = new Bubble();
		int demo[] = {3,9,-1,10,-2};
		bubble.sort(demo);*/
		
		/*Ñ¡ÔñÅÅÐò
		 * Select select = new Select();
		select.sort(demo);*/
		
		/*
		 * ²åÈëÅÅÐò
		 * Insert insert = new Insert();
		 insert.sort(demo);
		 */
		/*
		 * Ï£¶ûÅÅÐò
		 * 
		ShellEx shellEx = new ShellEx();
		shellEx.sort(demo);
		 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm-ss");
		ShellMv shellMv = new ShellMv();
//		System.out.println(simpleDateFormat.format(new Date()));
		shellMv.sort(demo);
		System.out.println(Arrays.toString(demo));
//		System.out.println(simpleDateFormat.format(new Date()));*/
		
		/*
		 * ¿ìÅÅ
		 
		QuickSort quickSort = new QuickSort();
		quickSort.sort(demo);
		System.out.println(Arrays.toString(demo));*/
		
		/*
		 * ¹é²¢ÅÅÐò
		 
		Merge merge = new Merge();
		merge.sort(demo);
		System.out.println(Arrays.toString(demo));*/
		
		/*
		 * »ùÊýÅÅÐò
		 
		Radix radix = new Radix();
		radix.sort(demo);
		System.out.println(Arrays.toString(demo));*/
		
		/*
		 * ¶ÑÅÅÐò
		 */
		Heap heap = new Heap();
		heap.sort(demo);
		System.out.println(Arrays.toString(demo));
	}
}
