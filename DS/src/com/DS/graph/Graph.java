package com.DS.graph;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * ͼ�ı�ʾ���������֣�һ�����ڽӾ���һ�����ڽ��б�
 * @author ��־ΰ
 *
 */
public class Graph {
	
	private ArrayList<String> vertexlList;//�洢����ļ���
	private int[][] edges;//�洢ͼ��Ӧ���ڽӾ���
	private int numofEdges;//��ʾ�ߵ���Ŀ
	public static void main(String[] args) {
		int n = 5;
		//���ýڵ������
		String vertexValue[] = {"A","B","C","D","E"};
		Graph graph = new Graph(n);
		//��Ӷ���
		for(String valueString : vertexValue){
			graph.insertVertex(valueString);
		}
		//��ӱ�
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		
		graph.showGraph();
	}
	
	public Graph(int n){
		//��ʼ�������vertexlList
		edges = new int[n][n];
		vertexlList = new ArrayList<String>();
		numofEdges = 0;
		
	}
	//ͼ�г��õķ���
	//��ʾͼ��Ӧ�ľ���
	public void showGraph(){
		for(int[] link : edges){
			System.out.println(Arrays.toString(link));
		}
	}
	
	//���ؽڵ�ĸ���
	public int getNumOfVertex(){
		return vertexlList.size();
	}
	//�õ��ߵ���Ŀ
	public int getNumOfEdges(){
		return numofEdges;
	}
	//���ؽڵ�i��Ӧ������
	public String getValueByIndex(int i){
		return vertexlList.get(i);
	}
	//����v1,v2�ߵĳ���
	public int getWeight(int v1,int v2){
		return edges[v1][v2];
	}
	//����ڵ�
	public void insertVertex(String vertax){
		vertexlList.add(vertax);
	}
	//�����
	/**
	 * 
	 * @param v1 ��ʾ������±�
	 * @param v2 
	 * @param weight ��ʾ�ߵĳ���
	 */
	public void insertEdge(int v1,int v2,int weight){
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numofEdges++;
	}
}
