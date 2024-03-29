package com.algorithm;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法是求最短路径的算法，利用的就是图的广度优先遍历
 * @author 任志伟
 *	基本步骤：
 *	1.设置出发节点v，顶点集合V，v到V中个顶点的距离构成距离集合Dis，Dis集合记录v到图中各顶点的距离
 *	2.从dis中选择值最小的di并移出dis集合，同时移出集合中对应的顶点vi，此时的v到vi即为最短路径
 *	3.更新dis集合，更新规则为：比较v到V集合中顶点的距离值，与v通过vi到V集合中顶点的距离值，保留值较小的一个
 */
public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int[][] matrix = new int[vertexs.length][vertexs.length];
		final int N = 65535;//表示不可链接
		matrix[0] = new int[]{N,5,7,N,N,N,2};
		matrix[1] = new int[]{5,N,N,9,N,N,3};
		matrix[2] = new int[]{7,N,N,N,8,N,N};
		matrix[3] = new int[]{N,9,N,N,N,4,N};
		matrix[4] = new int[]{N,N,8,N,N,5,4};
		matrix[5] = new int[]{N,N,N,4,5,N,6};
		matrix[6] = new int[]{2,3,N,N,4,6,N};
		//创建图
		Graph graph = new Graph(vertexs, matrix);
		graph.showGraph();
		graph.djs(6);
		graph.show();
	}

}
class Graph{
	private char[] vertexs;//顶点数组
	private int[][] matrix;//邻接矩阵
	private VisitedVertx visitedVertx;//已经访问过的顶点的集合
	
	public Graph(char[] vertexs, int[][] matrix) {
		this.vertexs = vertexs;
		this.matrix = matrix;
	}
	public void showGraph(){
		for(int[] link:matrix){
			System.out.println(Arrays.toString(link));
		}
	}
	//迪杰斯特拉算法实现
	/**
	 * 
	 * @param index	出发顶点的下标
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
	 * 更新index下标顶点到周围顶点的距离和周围顶点的前驱节点
	 * @param index
	 */
	private void update(int index){
		int len = 0;//出发顶点到index顶点的距离+index顶点到j顶点的距离的和
		//根据遍历邻接矩阵的matrix【index】行
		for(int j = 0;j < matrix[index].length;j++){
			len = visitedVertx.getDis(index) + matrix[index][j];
			//如果j顶点没有没有被访问过，并且len小于出发顶点到j顶点的距离，就需要更新
			if (!visitedVertx.in(j) && len < visitedVertx.getDis(j)) {
				visitedVertx.updatePre(j, index);//更新j顶点前驱节点就是index顶点
				visitedVertx.updateDis(j, len);//更新出发顶点到j顶点的距离
			}
		}
	}
	
	public void show(){
		visitedVertx.show();
	}
}
//已访问顶点的集合
class VisitedVertx{
	public int[] already_arr;//记录各个顶点是否访问过，1表示访问过，0，表示未访问，会动态更新
	public int[] pre_visited;//每个下标对应的值为前一个顶点的下标，会动态更新
	public int[] dis;//记录出发顶点到其他所有顶点的距离，比如G为出发顶点，就会记录G到其他顶点的距离，会动态更新，求的最短距离会存放到dis
	/**
	 * 
	 * @param len 表示顶点的个数
	 * @param index	出发顶点对应的下标，比如G顶点，下标就是6
	 */
	public VisitedVertx(int len,int index){
		this.already_arr = new int[len];
		this.pre_visited = new int[len];
		this.dis = new int[len];
		//初始化dis数组
		Arrays.fill(dis, 65535);
		this.already_arr[index] = 1;//设置出发顶点已经被访问过
		this.dis[index] = 0;//设置出发顶点到出发顶点的距离为0
	}
	/**
	 * 判断index顶点是否被访问过
	 * @param index
	 * @return 如果访问过就返回true，否则返回false
	 */
	public boolean in(int index){
		return already_arr[index] == 1;
	}
	/**
	 * 更新出发顶点到index顶点的距离
	 * @param index
	 * @param len
	 */
	public void updateDis(int index,int len){
		dis[index] = len;
	}
	/**
	 * 更新pre顶点的前驱节点为index节点
	 * @param pre
	 * @param index
	 */
	public void updatePre(int pre,int index){
		pre_visited[pre] = index;
	}
	/**
	 * 返回出发顶点到index的距离
	 * @param index
	 */
	public int getDis(int index){
		return dis[index];
	}
	/**
	 * 继续选择并返回新的访问顶点
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