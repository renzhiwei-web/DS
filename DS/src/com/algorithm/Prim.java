package com.algorithm;

import java.util.Arrays;

/**
 * ����ķ�㷨��������ͨ����ͼ����С������
 * 
 * @author ��־ΰ
 *
 */
public class Prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = {'A','B','C','D','E','F','G'};
		int verxs = data.length;
		//10000������ͨ
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
	 * @param graph ͼ����
	 * @param verxs	ͼ��Ӧ�Ķ������
	 * @param data	ͼ�ĸ��������ֵ
	 * @param weightͼ���ڽӾ���
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
	//��д����ķ�㷨���õ���С������
	public void prim(MGraph graph,int v){
		int[] visited = new int[graph.verxs];//��ǽڵ��Ƿ񱻷��ʹ�
		visited[v] = 1;
		//��¼���ڷ��ʵĽڵ���±�
		int h1 = -1;
		int h2 = -1;
		int minWeight = 10000;//��minWeight��ʼ���ɽϴ����
		for(int k = 1;k < graph.verxs;k++){//��Ϊ��verxs�����㣬���оͻ���verxs-1����
			for(int i = 0;i < graph.verxs;i++){
				for(int j = 0;j < graph.verxs;j++){
					if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
						minWeight = graph.weight[i][j];
						h1 = i;
						h2 = j;
						
					}
				}
			}
			System.out.println("��<" + graph.data[h1] + "," +graph.data[h2] + "> Ȩֵ��" + minWeight);
			visited[h2] = 1;
			minWeight = 10000;
		}
	}
	
}

class MGraph{
	int verxs;//��ʾͼ�Ľڵ����
	char[] data;//��Žڵ������
	int[][] weight;//��űߣ��������ǵ��ڽӾ���
	public MGraph(int verxs){
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
	}
}