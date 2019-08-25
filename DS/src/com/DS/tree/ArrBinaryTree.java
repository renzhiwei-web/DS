package com.DS.tree;

/**
 * ʵ��˳��洢����������
 * @author ��־ΰ
 *
 */
public class ArrBinaryTree {

	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	/**
	 * ��дһ�����������˳��洢��������ǰ�����
	 * @param index ������±�
	 */
	public void preOrder(int index){
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
		}
		System.out.println(arr[index]);
		//���ڵ�n(��0��ʼ)��Ԫ�ص���ڵ���±�Ϊ2*n+1
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
		
	}
	//�������
	public void inOrder(int index){
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
		}
		
		//���ڵ�n(��0��ʼ)��Ԫ�ص���ڵ���±�Ϊ2*n+1
		if ((index * 2 + 1) < arr.length) {
			inOrder(index * 2 + 1);
		}
		
		System.out.println(arr[index]);
		
		if ((index * 2 + 2) < arr.length) {
			inOrder(index * 2 + 2);
		}
	}
	//�������
	public void postOrder(int index){
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
		}
		
		//���ڵ�n(��0��ʼ)��Ԫ�ص���ڵ���±�Ϊ2*n+1
		if ((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}
		
		if ((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		
		System.out.println(arr[index]);
	}
}
