package com.DS.Recursion;

/**
 * ���ֲ��ҷ���ǰ���������������
 * @author ��־ΰ
 *
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(search(arr, 10, 0, arr.length - 1));
	}
	/**
	 * 
	 * @param arrҪ���ҵ�����
	 * @param targetҪ���ҵ�ֵ
	 * @param left��ߵ�����
	 * @param right�ұߵ�����
	 * @return����������±�
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
