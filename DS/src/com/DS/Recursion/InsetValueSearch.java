package com.DS.Recursion;

/**
 * �����������Ƚϴ󣬹ؼ��ֲַ����ȵ�������ò�ֵ�����㷨
 * ����Ӧ�㷨
 * @author ��־ΰ
 *
 */
public class InsetValueSearch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(search(arr, 8, 0, arr.length - 1));
	}
	
	public static int search(int[] arr,int target,int left,int right){
		if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
			return -1;
		}
		int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
		if (arr[mid] == target) {
			return mid;
		} else if (arr[mid] < target) {
			return search(arr, target, mid + 1, right);
		} else {
			return search(arr, target, left - 1, mid);
		}
	}
}
