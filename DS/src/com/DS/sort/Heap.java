package com.DS.sort;
/**
 * ����������������������ģ����ᴴ������ֻ�����Ǳ�����ʽ�����ı�����ʽ�����������
 * ���������Ǵ󶥶ѣ�����������С����
 * ˼���ǣ�
 * 1.�������е������ղ�������ķ�ʽ���γ�һ��������������ģ�
 * 2.�����һ����Ҷ�ӽڵ㣨arr.length/2-1����ʼ,��һ�����е���������������С��Ԫ�ط��ڶ��㣬ֱ��ÿ���Ѷ��Ǵ�С������
 * 3.���Ѷ�Ԫ����ĩβԪ�����������õ�����Ԫ�أ���ʣ�µ�Ԫ�����µ����ɴ�С������
 * @author ��־ΰ
 *
 */
public class Heap implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int temp;
		for(int i = demo.length / 2 - 1;i >= 0;i--){
			adjust(demo, i, demo.length);
		}
		for(int j = demo.length - 1;j > 0;j--){
			temp = demo[j];
			demo[j] = demo[0];
			demo[0] = temp;
			adjust(demo, 0, j);
		}
	}
	
	/**
	 * ����������ɴ󶥶ѵĽṹ
	 * @param arr
	 * @param i��ʾ��Ҷ�ӽڵ��������е�����
	 * @param length��ʾ�Զ��ٸ�Ԫ�ؽ��е���
	 */
	public static void adjust(int[] arr,int i,int length){
		int temp = arr[i];
		//k��i�����ӽڵ�
		for(int k = i * 2 + 1;k < length;k = k * 2 + 1){
			if (k + 1<length && arr[k] < arr[k+1]) {//������ӽڵ��ֵС�����ӽڵ��ֵ����kָ���ҽڵ㣬���������Ϊ��Ѱ�����ҽڵ�������һ��ֵ��
				k++;
			}
			if (arr[k] > temp) {//����ӽڵ���ڸ��ڵ�
				arr[i] = arr[k];
				i = k;
			}else {
				break;
			}
		}
		arr[i] = temp;//��������Ľڵ������ʱ����
	}

}
