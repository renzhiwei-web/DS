package com.DS.sort;

public class Merge implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int[] temp = new int[demo.length];
		mergeSort(demo, 0, demo.length - 1, temp);
	}
	public void mergeSort(int[] demo,int left,int right,int[] temp){
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(demo, left, mid, temp);
			mergeSort(demo, mid + 1, right, temp);
			merge(demo, left, mid, right, temp);
		}
	}
	/**
	 * 
	 * @param demo排序的原始数组
	 * @param left左边有序序列的初始索引
	 * @param mid中间索引
	 * @param right右边索引
	 * @param temp做临时变量
	 */
	public void merge(int[] demo,int left,int mid,int right,int[] temp){
		int i = left;//初始化i，
		int j = mid + 1;//初始化j，右边有序序列的初始索引
		int t = 0;//指向temp数组的当前索引
		while(i <= mid && j <= right){
			if (demo[i] <= demo[j]) {
				temp[t] = demo[i];
				i++;
				t++;
			}
			if (demo[j] <= demo[i]) {
				temp[t] = demo[j];
				j++;
				t++;
			}
		}
		while(i <= mid){
			temp[t] = demo[i];
			t++;
			i++;
		}
		
		while(j <= right){
			temp[t] = demo[j];
			t++;
			j++;
		}
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right){
			demo[tempLeft] = temp[t];
			t++;
			tempLeft++;
		}
	}
}
