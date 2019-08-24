package com.DS.Recursion;

/**
 * 二分查找法：前提必须是有序数组
 * @author 任志伟
 *
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(search(arr, 10, 0, arr.length - 1));
	}
	/**
	 * 
	 * @param arr要查找的数组
	 * @param target要查找的值
	 * @param left左边的索引
	 * @param right右边的索引
	 * @return返回数组的下标
	 */
	public static int search(int[] arr,int target,int left,int right){
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (arr[mid] == target) {
			return mid;
		}else if (arr[mid] < target) {
			return search(arr, target, mid + 1, right);
		}else {
			return search(arr, target, left - 1, mid);
		}
	}
}
