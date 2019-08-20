package com.DS.Recursion;

public class MiGong {
	public static void main(String[] args) {
		int[][] map = new int[8][7];//��ʼ����ͼ
		for(int i = 0;i < 7;i++){//��������Ϊ1
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for(int i = 0;i < 8;i++){//��������Ϊ1
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][3] = 1;
		System.out.println("��ʼ�ĵ�ͼ");
		for(int i = 0;i < 8;i++){
			for(int j = 0;j < 7;j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		setWay(map, 1, 1);
		System.out.println("���߹��ĵ�ͼ");
		for(int i = 0;i < 8;i++){
			for(int j = 0;j < 7;j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param map ��ʾ��ͼ
	 * @param i
	 * @param j
	 * @return ����ҵ�ͨ·���ͷ���true������Ҳ����ͷ���false
	 * Լ��������ͼΪ0ʱ��ʾ�õ�δ�ߵ�������Ϊ1ʱ��ʾǽ����Ϊ2ʱ��ʾ�����ߣ�3��ʾ�õ��Ѿ��߹�����·��ͨ��
	 * ���߲��ԣ���-����-����-����
	 */
	public static boolean setWay(int[][] map,int i,int j){
		if (map[6][5] == 2) {
			return true;
		}else {
			if (map[i][j] == 0) {
				map[i][j] = 2;//�ٶ�����·������ͨ
				if (setWay(map, i + 1, j)) {
					return true;
				}else if (setWay(map, i, j + 1)) {
					return true;
				}else if (setWay(map, i - 1, j)) {
					return true;
				}else if (setWay(map, i, j - 1)) {
					return true;
				}else {
					map[i][j] = 3;//˵���õ��߲�ͨ
					return false;
				}
			}else {
				return false;
			}
		}
	}
}
