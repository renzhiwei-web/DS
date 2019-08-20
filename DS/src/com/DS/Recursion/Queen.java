package com.DS.Recursion;

public class Queen {
	
	int max = 8;//���干�ж��ٸ��ʺ�
	int[] array = new int[max];
	static int count;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queen queen = new Queen();
		queen.print();
		queen.check(0);
		System.out.println("�ܹ���" + count);
		
	}
	/**
	 * ��ӡ�˻ʺ������
	 */
	private void print(){
		for(int i = 0;i < array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	/**
	 * �жϻʺ�֮���Ƿ���Թ���
	 * @param n �˻ʺ�����ĵ�N���ʺ�
	 * @return
	 */
	private boolean judge(int n){
		for(int i = 0;i < n;i++){
			//�ж��Ƿ�����ͬһ�л���ͬһб��
			//��array[n] = val�У�n���У�val���У�һ������С��м�ȥ��һ������С��У��õ����е����о���б��
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	/**
	 * ���õ�N���ʺ�
	 * @param n
	 */
	private void check(int n){
		if (n == max) {
			count++;
			print();
			return;
		}
		for(int i = 0;i < max;i++){
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}
}
