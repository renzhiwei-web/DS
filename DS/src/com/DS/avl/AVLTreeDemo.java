package com.DS.avl;
/**
 * 平衡二叉树是一种特殊的二叉排序树，平衡二叉树的左右子树的高度相差不会超过1
 * @author 任志伟
 *
 */
public class AVLTreeDemo {
	public static void main(String[] args) {
//		int[] arr = {4,3,6,5,7,8};
//		int[] arr = {10,12,8,9,7,6};
		int[] arr = {10,11,7,6,8,9};
		AVLTree avlTree = new AVLTree();
		for(int i = 0;i < arr.length;i++){
			avlTree.add(new Node(arr[i]));
		}
		System.out.println("中序遍历");
		avlTree.infixOrder();
		System.out.println(avlTree.getRoot().height());
		System.out.println(avlTree.getRoot().leftHeight());
		System.out.println(avlTree.getRoot().rightHeight());
		System.out.println(avlTree.getRoot());
		System.out.println(avlTree.getRoot().rightNode);
	}
}
//创建AVL树
class AVLTree{
	private Node root;
	
	public Node getRoot() {
		return root;
	}

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
	
	//左旋转
	public void leftRotate(){
		//创建一个当前值与当前节点相等的节点
		Node newNode = new Node(value);
		//将新节点的左子节点设置成当前节点的左子节点
		newNode.leftNode = leftNode;
		//将新节点的右子节点设置成当前节点的右子树的左子节点
		newNode.rightNode = rightNode.leftNode;
		//将当前节点的值设置成当前节点的右子节点的值
		value = rightNode.value;
		//将当前节点的左子节点设置成新节点
		leftNode = newNode;
		//将当前节点的右子节点设置成当前节点的右子节点的右子节点
		rightNode = rightNode.rightNode;
	}
	//右旋转
	public void rightRotate(){
		Node newNode = new Node(value);
		newNode.rightNode = rightNode;
		newNode.leftNode = leftNode.rightNode;
		value = leftNode.value;
		rightNode = newNode;
		leftNode = leftNode.leftNode;
	}
	//返回左子树的高度
	public int leftHeight(){
		if (leftNode == null) {
			return 0;
		}
		return leftNode.height();
	}
	//返回右子树的高度
	public int rightHeight(){
		if (rightNode == null) {
			return 0;
		}
		return rightNode.height();
	}
	//返回当前节点的高度
	public int height(){
		return Math.max(leftNode == null ? 0 : leftNode.height(), rightNode == null ? 0 : rightNode.height()) + 1;
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
		//当当前节点的右子树的高度-左子树的高度>1时，进行左旋转
		if (rightHeight() - leftHeight() > 1) {
			//如果当前节点的右子树的左子树的高度大于当前节点的右子树的右子树的高度(双旋转)
			if (rightNode != null && rightNode.leftHeight() > rightNode.rightHeight()) {
				rightNode.rightRotate();
			}
			leftRotate();
			return;
		}
		//当当前节点的左子树的高度-右子树的高度>1时，进行右旋转
		if (leftHeight() - rightHeight() > 1) {
			//如果当前节点的左子树的右子树的高度大于当前节点的左子树的左子树的高度(双旋转)
			if(leftNode != null && leftNode.rightHeight() > leftNode.leftHeight())
				//先对当前节点的左节点进行做选装
				leftNode.leftRotate();
			//最终进行右旋转
			rightRotate();
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