package com.DS.sort;

import java.util.Arrays;
/**
 * ϣ�������ǲ�������ĸĽ���ͨ���𽥼�С���������в�������
 * ϣ���������������趨�й�
 * @author ��־ΰ
 *
 */
public class ShellEx implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int temp;
		for(int gap = 5;gap > 0;gap /= 2){
			for(int i = gap;i < demo.length;i++){
				for(int j = i - gap;j >=  0;j -= gap){
					if (demo[j] > demo[j + gap]) {
						temp =demo[j];
						demo[j] =demo[j + gap];
						demo[j + gap] = temp;
					}
				}
			}
		}
		System.out.println(Arrays.toString(demo));
	}

}
