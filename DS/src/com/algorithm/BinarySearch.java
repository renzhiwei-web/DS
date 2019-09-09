package com.algorithm;
/**
 * 二分查找算法的非递归实现
 * @author 任志伟
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int search = search(arr, 71);
		System.out.println(search);
	}
	
	public static int search(int[] arr,int target){
		int left = 0;
		int right = arr.length - 1;
		while(left <= right){
			int mid = (left + right) / 2;
			if(arr[mid] == target){
				return mid;
			}else if (arr[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
