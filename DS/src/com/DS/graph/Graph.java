package com.DS.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * 图的表示方法有两种，一种是邻接矩阵，一种是邻接列表
 * @author 任志伟
 * 图的遍历为：图的深度优先遍历，图的广度优先遍历
 *
 */
public class Graph {
	
	private ArrayList<String> vertexlList;//存储顶点的集合
	private int[][] edges;//存储图对应的邻接矩阵
	private int numofEdges;//表示边的数目
	private boolean[] isVisited;//标记是否被访问过
	
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
//		System.out.println("深度优先遍历");
//		graph.dfs();
		
		System.out.println("广度优先遍历");
		graph.bfs();
	}
	
	public Graph(int n){
		//初始化矩阵和vertexlList
		edges = new int[n][n];
		vertexlList = new ArrayList<String>();
		numofEdges = 0;
		isVisited = new boolean[5];
		
	}
	//图的广度优先遍历
	/**
	 * 1.访问初始节点V并标记节点V已访问
	 * 2.节点V入队列
	 * 3.当队列非空时，继续执行，否则算法结束
	 * 4.出队列，获得队头节点U，
	 * 5.查找节点U的第一个邻接节点W
	 * 6.若节点U的邻接节点不存在，则转到步骤3；否则循环执行以下三个步骤
	 * 6.1：若节点W尚未被访问，则访问节点W并标记为已访问
	 * 6.2：节点W入队列
	 * 6.3：查找节点U的继W邻接节点后的下一个邻接节点W，转到步骤6
	 */
	//对一个节点进行广度优先遍历的方法
	private void bfs(boolean[] isVisited,int i){
		int u;//表示队列的头节点的对应的下标
		int w;//邻接节点W
		//队列，记录节点访问顺序的记录
		LinkedList queue = new LinkedList();
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;
		queue.addLast(i);
		while(!queue.isEmpty()){
			//取出队列头节点的下标
			u = (Integer) queue.removeFirst();
			//得到第一个邻接节点的下标W
			w = getFirstNeighbor(u);
			while(w != -1){
				if (!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "->");
					isVisited[w] = true;
					queue.addLast(w);
				}
				//以U为访问起始点，找到w后面的下一个邻接节点
				w = getNextNeighbor(u, w);
			}
		}
	}
	//遍历所有的节点，都进行广度优先搜索
	public void bfs(){
		for(int i = 0;i < getNumOfVertex();i++){
			if (!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}
	
	//图的深度优先遍历
	/**
	 * 1。访问初始节点V，并标记节点V为已经访问
	 * 2.查找节点V的第一个邻接节点W
	 * 3.若W存在，则继续执行4，如果W不存在，则回到第一步，将从V的下一个节点继续
	 * 4.若W未被访问，对W进行深度优先遍历递归
	 * 5.查找节点V的W邻接节点的下一个邻接节点，转到步骤3
	 */
	public void dfs(boolean[] isVisited,int i){
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;
		int w = getFirstNeighbor(i);
		while(w != -1){
			if (!isVisited[w]) {
				dfs(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}
	}
	//对dfs，进行一个重载，，遍历我们所有的节点，
	public void dfs(){
		for(int i = 0;i < getNumOfVertex();i++){
			if(!isVisited[i]){
				dfs(isVisited, i);
			}
		}
	}
	/**
	 * 得到一个邻接节点的下标W
	 * @param index
	 * @return
	 */
	public int getFirstNeighbor(int index){
		for(int j = 0;j < vertexlList.size();j++){
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}
	//根据前一个邻接节点的下标来获取下一个邻接节点
	public int getNextNeighbor(int v1,int v2){
		for(int j = v2 + 1;j < vertexlList.size();j++){
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
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
