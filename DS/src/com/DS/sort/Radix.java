package com.DS.sort;

public class Radix implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int[][] bucket = new int[10][demo.length];//ʹ�ÿռ任ʱ��ľ����㷨
		int max = demo[0];//����ֵ
		//�ȵõ����ֵ
		for(int i = 1;i < demo.length;i++)
			if (demo[i] > max) {
				max = demo[i];
			}
		int maxLength = (max + "").length();//�õ�����λ��
		//Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʴ���˶��ٸ����ݣ����Ƕ���һ��һά��������¼ÿ��Ͱ��ÿ�η�������ݸ���
		int[] bucketElementCounts = new int[10];
		
		for(int i = 0,n = 1;i < maxLength;i++,n *= 10){
			
			for(int j = 0;j < demo.length;j++){
				int digitOfElement = demo[j] /n % 10;//ȡ��ÿ��Ԫ�صĸ�,ʮ���ٵ�λ��ֵ
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = demo[j];
				bucketElementCounts[digitOfElement]++;//ÿ��Ͱ���Ѿ������˼���Ԫ��
			}
			int index = 0;
			for(int k = 0;k < bucketElementCounts.length;k++){
				if (bucketElementCounts[k] != 0) {//�ж�ÿ��Ͱ���Ƿ���ֵ
					for(int l = 0;l < bucketElementCounts[k];l++){
						demo[index++] = bucket[k][l];//��Ͱ�е�Ԫ��һ�ηŻ�����
					}
				}
				bucketElementCounts[k] = 0;//ÿ�ִ������Ҫ��ÿ��Ͱ����,����Ҫ����������Ͱ�е�Ԫ�أ�ֻҪ�Ѽ�¼Ͱ���Ѿ����뼸��Ԫ�ص��������ü���
			}
		}
		
		
		
		
		
		
	}

}
