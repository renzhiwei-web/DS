package com.algorithm;

import java.util.Arrays;

/**
 * ��³˹�����㷨Ҳ��һ�ּ�Ȩ������ͨͼ���㷨 ����˼���ǣ�����Ȩֵ��С�����������ѡ��n-1���ߣ�����֤n-1���߲����ɻ�·
 * 
 * @author ��־ΰ
 *
 */
public class Kruskal {

	private int edgeNum;// �ߵĸ���
	private char[] vertexs;// ����Ķ���
	private int[][] matrix;// �ڽӾ���
	// ʹ��INF����ʾ�������㲻����ͨ
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
		// ��ʼ���������ͱߵĸ���
		int vlen = vertexs.length;
		// ��ʼ������
		this.vertexs = new char[vlen];
		for (int i = 0; i < vertexs.length; i++) {
			this.vertexs[i] = vertexs[i];
		}
		// ��ʼ����
		this.matrix = new int[vlen][vlen];
		for (int i = 0; i < vlen; i++) {
			for (int j = 0; j < vlen; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
		// ͳ�Ʊ�
		for (int i = 0; i < vlen; i++) {
			for (int j = i + 1; j < vlen; j++) {
				if (this.matrix[i][j] != INF) {
					edgeNum++;
				}
			}
		}
	}

	public void print() {
		System.out.println("�ڽӾ���");
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = 0; j < vertexs.length; j++) {
				System.out.printf("%12d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}

	// �Ա߽���������
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
	 * @return ���ص�ch������±꣬����Ҳ����ͷ���-1
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
	 * ��ȡͼ�бߣ��ŵ�edata����������
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
	 * ��ȡ�±�Ϊi�Ķ�������յ㣨��������������ʱ�����յ���������ߵ��յ㣩
	 * @param ends ���������Ǽ�¼�˸��������Ӧ���յ����ĸ���ends�������ڱ��������У����γɵ�
	 * @param i 
	 * @return ��ʾ���յ���±�
	 */
	public int getEnd(int[] ends,int i){
		while(ends[i] != 0){
			i = ends[i];
		}
		return i;
	}
	
	public void kruskal(){
		int index = 0;//��ʾ��������������
		int[] ends = new int[edgeNum];//���ڱ���������С�������е�ÿ����������С�������е��յ�
		//����������飬����������С������
		EData[] rets = new EData[vertexs.length - 1];
		EData[] edges = getEdges();
		sortEdges(edges);
		for(int i = 0;i < edgeNum;i++){
			//��ȡ��i���ߵĵ�һ�����㣨��㣩
			int p1 = getPosition(edges[i].start);
			int p2 = getPosition(edges[i].end);
			//��ȡp1���������������С�������е����յ�
			int m = getEnd(ends, p1);
			int n = getEnd(ends, p2);
			if(m != n){//���������������յ㲻��ȣ������û�й��ɻ�·
				ends[m] = n;//����m��������С�������е����յ�
				rets[index++] = edges[i];
			}
		}
		System.out.println(Arrays.toString(rets));
	}
}

/**
 * ����һ���࣬���Ķ���ʵ���ͱ�ʾһ����
 * 
 * @author ��־ΰ
 *
 */
class EData {
	char start;// һ���ߵ����
	char end;// һ���ߵ��յ�
	int weight;// �ߵĳ���

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