package com.DS.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	public static void main(String[] args) {
		int arr[] = {13,7,8,3,29,6,1};
		createHuffmanTree(arr);
	}
	
	public static void perOrder(Node root){
		if (root != null) {
			root.perOrder();
		}else {
			System.out.println("是空树不能遍历");
		}
	}
	
	public static void createHuffmanTree(int[] arr){
		List<Node> nodes = new ArrayList<Node>();
		for(int value : arr){
			nodes.add(new Node(value));
		}
		while(nodes.size() > 1){
			Collections.sort(nodes);
			System.out.println("nodes = " + nodes);
			
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parentNode = new Node(leftNode.value + rightNode.value);
			parentNode.leftNode = leftNode;
			parentNode.rightNode = rightNode;
			
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parentNode);
		}
		perOrder(nodes.get(0));
	}
}


class Node implements Comparable<Node>{
	
	int value;
	Node leftNode;
	Node rightNode;
	
	public Node(int value) {
		super();
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.value - o.value;
	}
	
	public void perOrder(){
		System.out.println(this);
		if (this.leftNode != null) {
			this.leftNode.perOrder();
		}
		if (this.rightNode != null) {
			this.rightNode.perOrder();
		}
	}
	
}