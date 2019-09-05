package com.DS.BinarySortTree;
/**
 * 二叉排序树
 * @author 任志伟
 *
 */
public class BinarySortTreeDemo {
	public static void main(String[] args) {
		int[] arr = {7,3,10,12,5,1,9,2};
		BinarySortTree tree = new BinarySortTree();
		for(int i = 0;i < arr.length;i++)
			tree.add(new Node(arr[i]));
		System.out.println("中序遍历二叉排序树");
		tree.infixOrder();
		
	}
}
class BinarySortTree{
	private Node root;
	
	public Node search(int value){
		if (root == null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	
	public Node searchParent(int value){
		if (root == null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
	
	public void delNode(int value){
		if (root == null) {
			return;
		}else {
			Node targetNode = search(value);
			if (targetNode == null) {
				return;
			}
			
			if (root.leftNode == null && root.rightNode ==null) {
				
			}
			//如果要删除的节点没有父节点就不用查找父节点了
			if (targetNode == root) {
				
			}
		}
	}
	
	public void add(Node node){
		if(root == null){
			root = node;
		}else {
			root.add(node);
		}
	}
	
	public void infixOrder(){
		if (root != null) {
			root.infixOrder();
		}else {
			System.out.println("二叉排序树树为空，不能遍历");
		}
	}
}

//创建节点
class Node{
	int value;
	Node leftNode;
	Node rightNode;
	public Node(int value) {
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}


	/**
	 * 添加节点的方法
	 * 递归的形式添加节点，注意满足二叉排序树的要求
	 * @param node
	 */
	public void add(Node node){
		if (node == null) {//如果
			return;
		}
		//判断传入的节点的值，和当前子树根节点值得关系
		if (node.value < this.value) {
			if (this.leftNode == null) {
				this.leftNode = node;
			}else {
				this.leftNode.add(node);//递归得向左子树添加
			}
		}else {
			if (this.rightNode == null) {
				this.rightNode = node;
			}else {
				this.rightNode.add(node);
			}
		}
	}
	/**
	 * 中序遍历
	 */
	public void infixOrder(){
		if (this.leftNode != null) {
			this.leftNode.infixOrder();
		}
		System.out.println(this);
		if (this.rightNode !=null) {
			this.rightNode.infixOrder();
		}
	}
	/**
	 * 查找要删除的节点
	 * @param value 希望删除节点的值
	 * @return 如果找到返回值就返回该节点
	 */
	public Node search(int value){
		if (value == this.value) {
			return this;
		}else if(value < this.value){//如果查找的值小于当前节点，向左子树递归查找
			if (this.leftNode == null)
				return null;
			return this.leftNode.search(value);
		}else {
			if (this.rightNode == null) {
				return null;
			}
			return this.rightNode.search(value);
		}
	}
	/**
	 * 查找要删除节点的父节点
	 * @param value希望删除节点的值
	 * @return 如果找到就返回该节点的父节点
	 */
	public Node searchParent(int value){
		//如果当前节点就是要删除节点的父节点，就返回
		if ((this.leftNode != null && this.leftNode.value == value) || 
				(this.rightNode != null && this.rightNode.value == value)) {
			return this;
		}else {
			//如果查找的值小于当前节点的值，并且当且节点的左子节点不为空
			if (value < this.value && this.leftNode != null) {
				return this.leftNode.searchParent(value);
			}else if (value >= this.value && this.rightNode != null) {
				return this.rightNode.searchParent(value);
			}else {
				return null;
			}
		}
	}
}