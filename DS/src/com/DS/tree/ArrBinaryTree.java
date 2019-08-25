package com.DS.tree;

/**
 * 实现顺序存储二叉树遍历
 * @author 任志伟
 *
 */
public class ArrBinaryTree {

	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	/**
	 * 编写一个方法，完成顺序存储二叉树的前序遍历
	 * @param index 数组的下标
	 */
	public void preOrder(int index){
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		System.out.println(arr[index]);
		//由于第n(从0开始)个元素的左节点的下标为2*n+1
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
		
	}
	//中序遍历
	public void inOrder(int index){
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		
		//由于第n(从0开始)个元素的左节点的下标为2*n+1
		if ((index * 2 + 1) < arr.length) {
			inOrder(index * 2 + 1);
		}
		
		System.out.println(arr[index]);
		
		if ((index * 2 + 2) < arr.length) {
			inOrder(index * 2 + 2);
		}
	}
	//后序遍历
	public void postOrder(int index){
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		
		//由于第n(从0开始)个元素的左节点的下标为2*n+1
		if ((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}
		
		if ((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		
		System.out.println(arr[index]);
	}
}
