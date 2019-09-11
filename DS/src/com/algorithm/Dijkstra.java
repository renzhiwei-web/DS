package com.algorithm;

import java.util.Arrays;

/**
 * �Ͻ�˹�����㷨�������·�����㷨�����õľ���ͼ�Ĺ�����ȱ���
 * @author ��־ΰ
 *	�������裺
 *	1.���ó����ڵ�v�����㼯��V��v��V�и�����ľ��빹�ɾ��뼯��Dis��Dis���ϼ�¼v��ͼ�и�����ľ���
 *	2.��dis��ѡ��ֵ��С��di���Ƴ�dis���ϣ�ͬʱ�Ƴ������ж�Ӧ�Ķ���vi����ʱ��v��vi��Ϊ���·��
 *	3.����dis���ϣ����¹���Ϊ���Ƚ�v��V�����ж���ľ���ֵ����vͨ��vi��V�����ж���ľ���ֵ������ֵ��С��һ��
 */
public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int[][] matrix = new int[vertexs.length][vertexs.length];
		final int N = 65535;//��ʾ��������
		matrix[0] = new int[]{N,5,7,N,N,N,2};
		matrix[1] = new int[]{5,N,N,9,N,N,3};
		matrix[2] = new int[]{7,N,N,N,8,N,N};
		matrix[3] = new int[]{N,9,N,N,N,4,N};
		matrix[4] = new int[]{N,N,8,N,N,5,4};
		matrix[5] = new int[]{N,N,N,4,5,N,6};
		matrix[6] = new int[]{2,3,N,N,4,6,N};
		//����ͼ
		Graph graph = new Graph(vertexs, matrix);
		graph.showGraph();
		graph.djs(6);
		graph.show();
	}

}
class Graph{
	private char[] vertexs;//��������
	private int[][] matrix;//�ڽӾ���
	private VisitedVertx visitedVertx;//�Ѿ����ʹ��Ķ���ļ���
	
	public Graph(char[] vertexs, int[][] matrix) {
		this.vertexs = vertexs;
		this.matrix = matrix;
	}
	public void showGraph(){
		for(int[] link:matrix){
			System.out.println(Arrays.toString(link));
		}
	}
	//�Ͻ�˹�����㷨ʵ��
	/**
	 * 
	 * @param index	����������±�
	 */
	public void djs(int index){
		visitedVertx = new VisitedVertx(vertexs.length, index);
		update(index);
		for(int j = 1;j < vertexs.length;j++){
			index = visitedVertx.updateArr();
			update(index);
		}
	}
	/**
	 * ����index�±궥�㵽��Χ����ľ������Χ�����ǰ���ڵ�
	 * @param index
	 */
	private void update(int index){
		int len = 0;//�������㵽index����ľ���+index���㵽j����ľ���ĺ�
		//���ݱ����ڽӾ����matrix��index����
		for(int j = 0;j < matrix[index].length;j++){
			len = visitedVertx.getDis(index) + matrix[index][j];
			//���j����û��û�б����ʹ�������lenС�ڳ������㵽j����ľ��룬����Ҫ����
			if (!visitedVertx.in(j) && len < visitedVertx.getDis(j)) {
				visitedVertx.updatePre(j, index);//����j����ǰ���ڵ����index����
				visitedVertx.updateDis(j, len);//���³������㵽j����ľ���
			}
		}
	}
	
	public void show(){
		visitedVertx.show();
	}
}
//�ѷ��ʶ���ļ���
class VisitedVertx{
	public int[] already_arr;//��¼���������Ƿ���ʹ���1��ʾ���ʹ���0����ʾδ���ʣ��ᶯ̬����
	public int[] pre_visited;//ÿ���±��Ӧ��ֵΪǰһ��������±꣬�ᶯ̬����
	public int[] dis;//��¼�������㵽�������ж���ľ��룬����GΪ�������㣬�ͻ��¼G����������ľ��룬�ᶯ̬���£������̾�����ŵ�dis
	/**
	 * 
	 * @param len ��ʾ����ĸ���
	 * @param index	���������Ӧ���±꣬����G���㣬�±����6
	 */
	public VisitedVertx(int len,int index){
		this.already_arr = new int[len];
		this.pre_visited = new int[len];
		this.dis = new int[len];
		//��ʼ��dis����
		Arrays.fill(dis, 65535);
		this.already_arr[index] = 1;//���ó��������Ѿ������ʹ�
		this.dis[index] = 0;//���ó������㵽��������ľ���Ϊ0
	}
	/**
	 * �ж�index�����Ƿ񱻷��ʹ�
	 * @param index
	 * @return ������ʹ��ͷ���true�����򷵻�false
	 */
	public boolean in(int index){
		return already_arr[index] == 1;
	}
	/**
	 * ���³������㵽index����ľ���
	 * @param index
	 * @param len
	 */
	public void updateDis(int index,int len){
		dis[index] = len;
	}
	/**
	 * ����pre�����ǰ���ڵ�Ϊindex�ڵ�
	 * @param pre
	 * @param index
	 */
	public void updatePre(int pre,int index){
		pre_visited[pre] = index;
	}
	/**
	 * ���س������㵽index�ľ���
	 * @param index
	 */
	public int getDis(int index){
		return dis[index];
	}
	/**
	 * ����ѡ�񲢷����µķ��ʶ���
	 * @return
	 */
	public int updateArr(){
		int min = 65535;
		int index = 0;
		for(int i = 0;i < already_arr.length;i++){
			if (already_arr[i] == 0 && dis[i] < min) {
				min = dis[i];
				index = i;
			}
		}
		already_arr[index] = 1;
		return index;
	}
	
	public void show(){
		System.out.println(Arrays.toString(already_arr));
		System.out.println(Arrays.toString(pre_visited));
		System.out.println(Arrays.toString(dis));
	}
}