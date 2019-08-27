package com.DS.tree;

public class Demo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//		arrBinaryTree.preOrder(0);//1,2,4,8,9,5.3.6.7
//		arrBinaryTree.inOrder(0);
		arrBinaryTree.postOrder(0);
	}
}
