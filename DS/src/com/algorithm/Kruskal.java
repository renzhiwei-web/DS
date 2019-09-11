package com.algorithm;

import java.util.Arrays;

/**
 * 克鲁斯卡尔算法也是一种加权无向连通图的算法 基本思想是：按照权值从小到大进行排序选择n-1条边，并保证n-1条边不构成回路
 * 
 * @author 任志伟
 *
 */
public class Kruskal {

	private int edgeNum;// 边的个数
	private char[] vertexs;// 顶点的定义
	private int[][] matrix;// 邻接矩阵
	// 使用INF来表示两个顶点不能联通
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int matrix[][] = { { 0, 12, INF, INF, INF, 16, 14 }, { 12, 0, 10, INF, INF, 7, INF },
				{ INF, 10, 0, 3, 5, 6, INF }, { INF, INF, 3, 0, 4, INF, INF }, { INF, INF, 5, 4, 0, 2, 8 },
				{ 16, 7, 6, INF, 2, 0, 9 }, { 14, INF, INF, INF, 8, 9, 0 } };
		Kruskal kruskal = new Kruskal(vertexs, matrix);
		kruskal.print();
		EData[] edges = kruskal.getEdges();
		System.out.println(Arrays.toString(edges));
		kruskal.sortEdges(edges);
		System.out.println(Arrays.toString(edges));
		kruskal.kruskal();
		
	}

	public Kruskal(char[] vertexs, int[][] matrix) {
		// 初始化顶点数和边的个数
		int vlen = vertexs.length;
		// 初始化顶点
		this.vertexs = new char[vlen];
		for (int i = 0; i < vertexs.length; i++) {
			this.vertexs[i] = vertexs[i];
		}
		// 初始化边
		this.matrix = new int[vlen][vlen];
		for (int i = 0; i < vlen; i++) {
			for (int j = 0; j < vlen; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
		// 统计边
		for (int i = 0; i < vlen; i++) {
			for (int j = i + 1; j < vlen; j++) {
				if (this.matrix[i][j] != INF) {
					edgeNum++;
				}
			}
		}
	}

	public void print() {
		System.out.println("邻接矩阵");
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = 0; j < vertexs.length; j++) {
				System.out.printf("%12d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}

	// 对边进行排序处理
	public void sortEdges(EData[] edges) {
		for (int i = 0; i < edges.length - 1; i++) {
			for (int j = 0; j < edges.length - 1; j++) {
				if (edges[j].weight > edges[j + 1].weight) {
					EData temp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 
	 * @param ch
	 * @return 返回的ch顶点的下标，如果找不到就返回-1
	 */
	public int getPosition(char ch) {
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 获取图中边，放到edata【】数组中
	 * 
	 * @return
	 */
	public EData[] getEdges() {
		int index = 0;
		EData[] datas = new EData[edgeNum];
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = i + 1; j < vertexs.length; j++) {
				if (matrix[i][j] != INF) {
					datas[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
				}
			}
		}
		return datas;
	}
	/**
	 * 获取下标为i的顶点的最终点（与其他边相连接时，最终点就是相连边的终点）
	 * @param ends 这个数组就是记录了各个顶点对应的终点是哪个，ends数组是在遍历过程中，逐步形成的
	 * @param i 
	 * @return 表示最终点的下标
	 */
	public int getEnd(int[] ends,int i){
		while(ends[i] != 0){
			i = ends[i];
		}
		return i;
	}
	
	public void kruskal(){
		int index = 0;//表示最后结果数组的索引
		int[] ends = new int[edgeNum];//用于保存已有最小生成树中的每个顶点在最小生成树中的终点
		//创建结果数组，保存最后的最小生成树
		EData[] rets = new EData[vertexs.length - 1];
		EData[] edges = getEdges();
		sortEdges(edges);
		for(int i = 0;i < edgeNum;i++){
			//获取第i条边的第一条顶点（起点）
			int p1 = getPosition(edges[i].start);
			int p2 = getPosition(edges[i].end);
			//获取p1这个顶点在已有最小生成树中的最终点
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);
			if(m != n){//如果两个顶点的最终点不相等，则就是没有构成回路
				ends[m] = n;//设置m在已有最小生成树中的最终点
				rets[index++] = edges[i];
			}
		}
		System.out.println(Arrays.toString(rets));
	}
}

/**
 * 创建一个类，它的对象实例就表示一条边
 * 
 * @author 任志伟
 *
 */
class EData {
	char start;// 一条边的起点
	char end;// 一条边的终点
	int weight;// 边的长度

	public EData(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "EData [start=" + start + ", end=" + end + ", weight=" + weight + "]";
	}

}