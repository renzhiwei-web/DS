package com.DS.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DemoTest {

	public static void main(String[] args) {
		int demo[] = {8,9,1,7,2,3,5,4,6,0};
		
		int[] arr = new int[80000];
		for(int i = 0;i < 80000;i++)
			arr[i] = (int) (Math.random() * 8000000);
		/*ð������
		 * Bubble bubble = new Bubble();
		int demo[] = {3,9,-1,10,-2};
		bubble.sort(demo);*/
		
		/*ѡ������
		 * Select select = new Select();
		select.sort(demo);*/
		
		/*
		 * ��������
		 * Insert insert = new Insert();
		 insert.sort(demo);
		 */
		/*
		 * ϣ������
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
		 * ����
		 */
		QuickSort quickSort = new QuickSort();
		quickSort.sort(demo);
		System.out.println(Arrays.toString(demo));
	}
}