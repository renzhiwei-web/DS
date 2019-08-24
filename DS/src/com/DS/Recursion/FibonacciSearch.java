package com.DS.Recursion;

import java.util.Arrays;

/**
 * 斐波那契查找算法要通过斐波那契数列来实现 斐波那契数列的通项公式是f(i)=f(i-1)+f(i-2) 即f(i)-1 = [f(i-1)-1] + [f(i-2)-1]+1
 * 所以如果数组的长度为f(i)-1,就可以将数组分为f(i-1)-1以及f(i-2)-1两端,中间的就是黄金分割点left+f(i-1)-1
 * 表长度不够，则先进行扩容
 * 
 * @author 任志伟
 *
 */
public class FibonacciSearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(search(arr, 10));
	}

	public static int maxSize = 20;

	// 得到斐波那契数列
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	/**
	 * 
	 * @param a要查找的数组
	 * @param key我们需要查找的关键码
	 * @return 返回对应的下标，如果没有则是-1
	 */
	public static int search(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		int k = 0;// 表示斐波那契分割数值的下标,就是找到这个数组的长度对应的斐波那契数列的下标
		int mid = 0;// 存放mid值
		int f[] = fib();
		// 获取斐波那契分割数值的下标
		while (right > f[k] - 1)
			k++;
		// 给数组扩容,用原数组中的最后一位来填充
		int[] temp = Arrays.copyOf(arr, f[k]);
		for (int i = right + 1; i < temp.length; i++) {
			temp[i] = arr[right];
		}
		while (left <= right) {
			mid = left + f[k - 1] - 1;
			if (key < temp[mid]) {// 如果要查询的值在分割值的左边，则查找左边
				right = mid - 1;
				k--;// 1.全部元素 = 前面的元素 + 后边的元素f(k) = f(k-1)+f(k-2)
					// 由于是查找前面的元素所以要k-1，若是要查找后面的元素则k-2
			} else if (key > temp[mid]) {
				left = mid + 1;
				k = k - 2;
			} else {
				if (mid <= right) {//因为原来数组扩容，所以得到的mid的值可能比right大，若mid比right大，说明要找的数的下标就是right
					return mid;
				} else {
					return right;
				}
			}
		}
		return -1;
	}
}
