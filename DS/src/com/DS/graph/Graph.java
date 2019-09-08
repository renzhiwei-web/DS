package com.DS.graph;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 图的表示方法有两种，一种是邻接矩阵，一种是邻接列表
 * @author 任志伟
 *
 */
public class Graph {
	
	private ArrayList<String> vertexlList;//存储顶点的集合
	private int[][] edges;//存储图对应的邻接矩阵
	private int numofEdges;//表示边的数目
	public static void main(String[] args) {
		int n = 5;
		//设置节点个名称
		String vertexValue[] = {"A","B","C","D","E"};
		Graph graph = new Graph(n);
		//添加顶点
		for(String valueString : vertexValue){
			graph.insertVertex(valueString);
		}
		//添加边
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		
		graph.showGraph();
	}
	
	public Graph(int n){
		//初始化矩阵和vertexlList
		edges = new int[n][n];
		vertexlList = new ArrayList<String>();
		numofEdges = 0;
		
	}
	//图中常用的方法
	//显示图对应的矩阵
	public void showGraph(){
		for(int[] link : edges){
			System.out.println(Arrays.toString(link));
		}
	}
	
	//返回节点的个数
	public int getNumOfVertex(){
		return vertexlList.size();
	}
	//得到边的数目
	public int getNumOfEdges(){
		return numofEdges;
	}
	//返回节点i对应的数据
	public String getValueByIndex(int i){
		return vertexlList.get(i);
	}
	//返回v1,v2边的长度
	public int getWeight(int v1,int v2){
		return edges[v1][v2];
	}
	//插入节点
	public void insertVertex(String vertax){
		vertexlList.add(vertax);
	}
	//插入边
	/**
	 * 
	 * @param v1 表示顶点的下标
	 * @param v2 
	 * @param weight 表示边的长度
	 */
	public void insertEdge(int v1,int v2,int weight){
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numofEdges++;
	}
}
