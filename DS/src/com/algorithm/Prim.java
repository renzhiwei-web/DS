package com.algorithm;

import java.util.Arrays;

/**
 * 普利姆算法就是求连通无向图的最小生成树
 * 
 * @author 任志伟
 *
 */
public class Prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = {'A','B','C','D','E','F','G'};
		int verxs = data.length;
		//10000代表不连通
		int[][] weight = {
				{10000,5,7,10000,10000,10000,2},
				{5,10000,10000,9,10000,10000,3},
				{7,10000,10000,10000,8,10000,10000},
				{10000,9,10000,8,10000,10000,4,100000},
				{10000,10000,8,10000,10000,5,4},
				{10000,10000,10000,4,5,10000,6},
				{2,3,10000,10000,4,6,10000}
		};
		MGraph graph = new MGraph(verxs);
		MinTree minTree = new MinTree();
		minTree.createGraph(graph, verxs, data, weight);
		minTree.showGraph(graph);
		minTree.prim(graph, 3);
	}

}
class MinTree{
	/**
	 * 
	 * @param graph 图对象
	 * @param verxs	图对应的顶点个数
	 * @param data	图的各个顶点的值
	 * @param weight图的邻接矩阵
	 */
	public void createGraph(MGraph graph,int verxs,char data[],int[][] weight){
		int i,j;
		for(i = 0;i < verxs;i++){
			graph.data[i] = data[i];
			for(j = 0;j < verxs;j++){
				graph.weight[i][j] = weight[i][j];
			}
		}
	}
	
	public void showGraph(MGraph graph){
		for(int[] link : graph.weight){
			System.out.println(Arrays.toString(link));
		}
	}
	//编写普利姆算法，得到最小生成树
	public void prim(MGraph graph,int v){
		int[] visited = new int[graph.verxs];//标记节点是否被访问过
		visited[v] = 1;
		//记录正在访问的节点的下标
		int h1 = -1;
		int h2 = -1;
		int minWeight = 10000;//将minWeight初始化成较大的数
		for(int k = 1;k < graph.verxs;k++){//因为有verxs个顶点，所有就会有verxs-1条边
			for(int i = 0;i < graph.verxs;i++){
				for(int j = 0;j < graph.verxs;j++){
					if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
						minWeight = graph.weight[i][j];
						h1 = i;
						h2 = j;
						
					}
				}
			}
			System.out.println("边<" + graph.data[h1] + "," +graph.data[h2] + "> 权值：" + minWeight);
			visited[h2] = 1;
			minWeight = 10000;
		}
	}
	
}

class MGraph{
	int verxs;//表示图的节点个数
	char[] data;//存放节点的数据
	int[][] weight;//存放边，就是我们的邻接矩阵
	public MGraph(int verxs){
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
	}
}