package com.DS.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * ͼ�ı�ʾ���������֣�һ�����ڽӾ���һ�����ڽ��б�
 * @author ��־ΰ
 * ͼ�ı���Ϊ��ͼ��������ȱ�����ͼ�Ĺ�����ȱ���
 *
 */
public class Graph {
	
	private ArrayList<String> vertexlList;//�洢����ļ���
	private int[][] edges;//�洢ͼ��Ӧ���ڽӾ���
	private int numofEdges;//��ʾ�ߵ���Ŀ
	private boolean[] isVisited;//����Ƿ񱻷��ʹ�
	
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
//		System.out.println("������ȱ���");
//		graph.dfs();
		
		System.out.println("������ȱ���");
		graph.bfs();
	}
	
	public Graph(int n){
		//��ʼ�������vertexlList
		edges = new int[n][n];
		vertexlList = new ArrayList<String>();
		numofEdges = 0;
		isVisited = new boolean[5];
		
	}
	//ͼ�Ĺ�����ȱ���
	/**
	 * 1.���ʳ�ʼ�ڵ�V����ǽڵ�V�ѷ���
	 * 2.�ڵ�V�����
	 * 3.�����зǿ�ʱ������ִ�У������㷨����
	 * 4.�����У���ö�ͷ�ڵ�U��
	 * 5.���ҽڵ�U�ĵ�һ���ڽӽڵ�W
	 * 6.���ڵ�U���ڽӽڵ㲻���ڣ���ת������3������ѭ��ִ��������������
	 * 6.1�����ڵ�W��δ�����ʣ�����ʽڵ�W�����Ϊ�ѷ���
	 * 6.2���ڵ�W�����
	 * 6.3�����ҽڵ�U�ļ�W�ڽӽڵ�����һ���ڽӽڵ�W��ת������6
	 */
	//��һ���ڵ���й�����ȱ����ķ���
	private void bfs(boolean[] isVisited,int i){
		int u;//��ʾ���е�ͷ�ڵ�Ķ�Ӧ���±�
		int w;//�ڽӽڵ�W
		//���У���¼�ڵ����˳��ļ�¼
		LinkedList queue = new LinkedList();
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;
		queue.addLast(i);
		while(!queue.isEmpty()){
			//ȡ������ͷ�ڵ���±�
			u = (Integer) queue.removeFirst();
			//�õ���һ���ڽӽڵ���±�W
			w = getFirstNeighbor(u);
			while(w != -1){
				if (!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "->");
					isVisited[w] = true;
					queue.addLast(w);
				}
				//��UΪ������ʼ�㣬�ҵ�w�������һ���ڽӽڵ�
				w = getNextNeighbor(u, w);
			}
		}
	}
	//�������еĽڵ㣬�����й����������
	public void bfs(){
		for(int i = 0;i < getNumOfVertex();i++){
			if (!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}
	
	//ͼ��������ȱ���
	/**
	 * 1�����ʳ�ʼ�ڵ�V������ǽڵ�VΪ�Ѿ�����
	 * 2.���ҽڵ�V�ĵ�һ���ڽӽڵ�W
	 * 3.��W���ڣ������ִ��4�����W�����ڣ���ص���һ��������V����һ���ڵ����
	 * 4.��Wδ�����ʣ���W����������ȱ����ݹ�
	 * 5.���ҽڵ�V��W�ڽӽڵ����һ���ڽӽڵ㣬ת������3
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
	//��dfs������һ�����أ��������������еĽڵ㣬
	public void dfs(){
		for(int i = 0;i < getNumOfVertex();i++){
			if(!isVisited[i]){
				dfs(isVisited, i);
			}
		}
	}
	/**
	 * �õ�һ���ڽӽڵ���±�W
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
	//����ǰһ���ڽӽڵ���±�����ȡ��һ���ڽӽڵ�
	public int getNextNeighbor(int v1,int v2){
		for(int j = v2 + 1;j < vertexlList.size();j++){
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
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
