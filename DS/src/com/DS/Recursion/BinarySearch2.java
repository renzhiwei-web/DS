package com.DS.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找法的改进：可以查出数组中与目标数值所有相同的数值
 * 
 * @author 任志伟
 *
 */
public class BinarySearch2 extends BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(search(arr, 10, 0, arr.length - 1));
		System.out.println(searchAll(arr, 3, 0, arr.length - 1));
	}

	public static List<Integer> searchAll(int[] arr, int target, int left, int right) {
		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) / 2;
		if (arr[mid] == target) {
			List<Integer> indexList = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != target)
					break;
				indexList.add(temp);
				temp--;
			}
			
			indexList.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != target)
					break;
				indexList.add(temp);
				temp++;
			}
			return indexList;
		} else if (arr[mid] < target) {
			return searchAll(arr, target, mid + 1, right);
		} else {
			return searchAll(arr, target, left - 1, mid);
		}
	}
}
