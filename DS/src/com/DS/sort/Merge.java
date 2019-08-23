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
	 * @param demo�����ԭʼ����
	 * @param left����������еĳ�ʼ����
	 * @param mid�м�����
	 * @param right�ұ�����
	 * @param temp����ʱ����
	 */
	public void merge(int[] demo,int left,int mid,int right,int[] temp){
		int i = left;//��ʼ��i��
		int j = mid + 1;//��ʼ��j���ұ��������еĳ�ʼ����
		int t = 0;//ָ��temp����ĵ�ǰ����
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
