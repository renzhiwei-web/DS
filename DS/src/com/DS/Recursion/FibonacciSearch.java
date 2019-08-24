package com.DS.Recursion;

import java.util.Arrays;

/**
 * 쳲����������㷨Ҫͨ��쳲�����������ʵ�� 쳲��������е�ͨ�ʽ��f(i)=f(i-1)+f(i-2) ��f(i)-1 = [f(i-1)-1] + [f(i-2)-1]+1
 * �����������ĳ���Ϊf(i)-1,�Ϳ��Խ������Ϊf(i-1)-1�Լ�f(i-2)-1����,�м�ľ��ǻƽ�ָ��left+f(i-1)-1
 * ���Ȳ��������Ƚ�������
 * 
 * @author ��־ΰ
 *
 */
public class FibonacciSearch {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(search(arr, 10));
	}

	public static int maxSize = 20;

	// �õ�쳲���������
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
	 * @param aҪ���ҵ�����
	 * @param key������Ҫ���ҵĹؼ���
	 * @return ���ض�Ӧ���±꣬���û������-1
	 */
	public static int search(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		int k = 0;// ��ʾ쳲������ָ���ֵ���±�,�����ҵ��������ĳ��ȶ�Ӧ��쳲��������е��±�
		int mid = 0;// ���midֵ
		int f[] = fib();
		// ��ȡ쳲������ָ���ֵ���±�
		while (right > f[k] - 1)
			k++;
		// ����������,��ԭ�����е����һλ�����
		int[] temp = Arrays.copyOf(arr, f[k]);
		for (int i = right + 1; i < temp.length; i++) {
			temp[i] = arr[right];
		}
		while (left <= right) {
			mid = left + f[k - 1] - 1;
			if (key < temp[mid]) {// ���Ҫ��ѯ��ֵ�ڷָ�ֵ����ߣ���������
				right = mid - 1;
				k--;// 1.ȫ��Ԫ�� = ǰ���Ԫ�� + ��ߵ�Ԫ��f(k) = f(k-1)+f(k-2)
					// �����ǲ���ǰ���Ԫ������Ҫk-1������Ҫ���Һ����Ԫ����k-2
			} else if (key > temp[mid]) {
				left = mid + 1;
				k = k - 2;
			} else {
				if (mid <= right) {//��Ϊԭ���������ݣ����Եõ���mid��ֵ���ܱ�right����mid��right��˵��Ҫ�ҵ������±����right
					return mid;
				} else {
					return right;
				}
			}
		}
		return -1;
	}
}
