package com.DS.Recursion;

public class MiGong {
	public static void main(String[] args) {
		int[][] map = new int[8][7];//初始化地图
		for(int i = 0;i < 7;i++){//将上下置为1
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for(int i = 0;i < 8;i++){//将左右置为1
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][3] = 1;
		System.out.println("初始的地图");
		for(int i = 0;i < 8;i++){
			for(int j = 0;j < 7;j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		setWay(map, 1, 1);
		System.out.println("行走过的地图");
		for(int i = 0;i < 8;i++){
			for(int j = 0;j < 7;j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param map 表示地图
	 * @param i
	 * @param j
	 * @return 如果找到通路，就返回true，如果找不到就返回false
	 * 约定：当地图为0时表示该点未走到，，当为1时表示墙，当为2时表示可以走，3表示该点已经走过但是路不通。
	 * 行走策略：下-》右-》上-》左
	 */
	public static boolean setWay(int[][] map,int i,int j){
		if (map[6][5] == 2) {
			return true;
		}else {
			if (map[i][j] == 0) {
				map[i][j] = 2;//假定这条路可以走通
				if (setWay(map, i + 1, j)) {
					return true;
				}else if (setWay(map, i, j + 1)) {
					return true;
				}else if (setWay(map, i - 1, j)) {
					return true;
				}else if (setWay(map, i, j - 1)) {
					return true;
				}else {
					map[i][j] = 3;//说明该点走不通
					return false;
				}
			}else {
				return false;
			}
		}
	}
}
