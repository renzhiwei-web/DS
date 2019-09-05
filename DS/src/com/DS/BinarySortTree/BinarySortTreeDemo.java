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
		System.out.println();
		tree.delNode(10);
		tree.delNode(7);
		tree.delNode(3);
		tree.delNode(1);
		tree.delNode(2);
		tree.delNode(12);
		tree.delNode(5);
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
			//如果没有找到要删除的节点
			if (targetNode == null) {
				return;
			}
			
			if (root.leftNode == null && root.rightNode ==null) {//如果当前二叉排序树只有一个节点
				root = null;
				return;
			}
			Node parent = searchParent(value);
			//如果要删除的节点是叶子节点
			if (targetNode.leftNode == null && targetNode.rightNode == null) {
				if (parent.leftNode != null && parent.leftNode.value == value) {//如果要查找的节点是父节点的左子节点
					parent.leftNode = null;
				}else if(parent.rightNode != null && parent.rightNode.value == value){
					parent.rightNode = null;
				}
			}else if (targetNode.leftNode != null && targetNode.rightNode != null) {
				int minVal = delRightTreeMin(targetNode.rightNode);
				targetNode.value = minVal;
			}else {//删除只有一个子树的节点
				if (targetNode.leftNode != null) {//如果要删除的节点只有有左子节点
					if (parent != null) {//如果要删除的节点没有父节点，则直接将root该节点的左节点
						if (parent.leftNode.value == value) {//如果要删除的节点是其父节点的左子节点
							parent.leftNode = targetNode.leftNode;
						}else {
							parent.rightNode = targetNode.leftNode;
						}
					}else {
						root = targetNode.leftNode;
					}
				}else {//要删除的节点只有右子节点
					if (parent != null) {
						if (parent.leftNode.value == value) {//如果要删除的节点是其父节点的左子节点
							parent.leftNode = targetNode.rightNode;
						}else {
							parent.rightNode = targetNode.rightNode;
						}
					}else {
						root = targetNode.rightNode;
					}
				}
			}
		}
	}
	
	/**
	 * 返回的以node为根节点的二叉排序树的最小节点的值
	 * 删除node为根节点的二叉排序树的最小节点的值
	 * @param node传入的节点（当作二叉排序树的根节点）
	 * @return 返回的以node为根节点的二叉排序树的最小节点的值
	 */
	public int delRightTreeMin(Node node){
		Node target = node;
		//循环的查找左节点，就会找到最小值,根据二叉排序树的特性来查找最小值
		while(target.leftNode != null){
			target = target.leftNode;
		}
		delNode(target.value);
		return target.value;
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