package com.algorithm;
/**
 * ��ŵ���Ƿ����㷨�ľ���Ӧ��
 * �����㷨��Ϊ3��
 * 1.������ֽ�����ɹ�ģ��С���໥��������ԭ������ʽ��ͬ��������
 * 2.������������ģ��С�����ױ������ֱ�ӽ��������ݹ�ؽ��������
 * 3.�ϲ���������������Ľ�ϲ���ԭ����Ľ�
 * @author ��־ΰ
 *
 */
public class Hanoitower {
	public static void main(String[] args) {
		hanoiTower(4, 'A', 'B', 'C');
	}
	/**
	 * 
	 * @param num �̵ĸ���
	 * @param a	Ҫ�ƶ��������ڵ���
	 * @param b	�ƶ������й��ȵ���
	 * @param c	Ҫ�ƶ�������
	 */
	public static void hanoiTower(int num,char a,char b,char c){
		if(num == 1){
			System.out.println("��1���̴�" + a + "->" + c);
		}else {
			//�����n>= 2��������������ǿ��Կ�����������1.�����±ߵ�һ����2.�������е���
			//1.�Ȱ��������������A->B���ƶ����̻�ʹ�õ�C
			hanoiTower(num - 1, a, c, b);
			//2.������������ƶ���C��
			System.out.println("��" + num +"���̴�" + a +"->" + c);
			//3.��B�������е����ƶ���c���ƶ�������ʹ��A
			hanoiTower(num - 1, b, a, c);
		}
	}
}
