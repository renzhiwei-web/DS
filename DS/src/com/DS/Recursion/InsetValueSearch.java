package com.DS.Recursion;

/**
 * 对于数据量比较大，关键字分布均匀的情况下用插值查找算法
 * 自适应算法
 * @author 任志伟
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
