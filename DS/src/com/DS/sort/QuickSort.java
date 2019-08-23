package com.DS.sort;

public class QuickSort implements Sort {

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		quicksort(demo, 0, demo.length - 1);
	}
	
	public void quicksort(int[] demo,int left,int right){
		if (left > right) {
			return;
		}
		
		int l = left;
		int r = right;
		int temp = demo[(l + r) / 2];//�����������λ��Ϊ��׼ֵ
		int t;//��ʱ����
		while(l < r){
			while(temp > demo[l] && l < r)
				l++;
			while(temp < demo[r] && l < r)
				r--;
			if (l < r) {
				t = demo[r];
				demo[r] = demo[l];
				demo[l] = t;
			}
		}
		quicksort(demo, left, r - 1);
		quicksort(demo, r + 1, right);
	}
}
