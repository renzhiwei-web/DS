package com.DS.sort;

import java.util.Arrays;

/**
 * ð������ĸĽ����趨һ����־����ʾĳһ�������Ƿ񽻻������ݣ���û���򲻱��ٽ�������
 * @author ��־ΰ
 *
 */
public class Bubble2 implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		boolean flag = false;//����һ����ʶ
		for(int i = 0;i < demo.length - 1;i++){
			for(int j = 0;j < demo.length - i - 1;j++){
				if (demo[j] > demo[j + 1]) {
					flag = true;
					int temp = demo[j];
					demo[j] = demo[j + 1];
					demo[j + 1] = temp;
				}
				if (!flag) {
					break;
				} else {
					flag = false;
				}
			}
			System.out.println(Arrays.toString(demo));
		}
		System.out.println("���յ�������" + Arrays.toString(demo));
	}

}
