package com.DS.sort;
/**
 * 堆排序是利用数组来排序的，不会创建树，只不过是遍历方式是树的遍历方式（层序遍历）
 * 升序排序是大顶堆，降序排序是小顶堆
 * 思想是：
 * 1.将数组中的树按照层序遍历的方式来形成一个二叉树（无序的）
 * 2.从最后一个非叶子节点（arr.length/2-1）开始,在一个堆中调整，将堆里的最大（小）元素放在顶点，直到每个堆都是大（小）顶堆
 * 3.将堆顶元素与末尾元素来交换，得到最大的元素，将剩下的元素重新调整成大（小）顶堆
 * @author 任志伟
 *
 */
public class Heap implements Sort{

	@Override
	public void sort(int[] demo) {
		// TODO Auto-generated method stub
		int temp;
		for(int i = demo.length / 2 - 1;i >= 0;i--){
			adjust(demo, i, demo.length);
		}
		for(int j = demo.length - 1;j > 0;j--){
			temp = demo[j];
			demo[j] = demo[0];
			demo[0] = temp;
			adjust(demo, 0, j);
		}
	}
	
	/**
	 * 将数组调整成大顶堆的结构
	 * @param arr
	 * @param i表示非叶子节点在数组中的索引
	 * @param length表示对多少个元素进行调整
	 */
	public static void adjust(int[] arr,int i,int length){
		int temp = arr[i];
		//k是i的左子节点
		for(int k = i * 2 + 1;k < length;k = k * 2 + 1){
			if (k + 1<length && arr[k] < arr[k+1]) {//如果左子节点的值小于右子节点的值，将k指向右节点，（可以理解为是寻找左，右节点中最大的一个值）
				k++;
			}
			if (arr[k] > temp) {//如果子节点大于父节点
				arr[i] = arr[k];
				i = k;
			}else {
				break;
			}
		}
		arr[i] = temp;//将调整后的节点等于临时变量
	}

}
