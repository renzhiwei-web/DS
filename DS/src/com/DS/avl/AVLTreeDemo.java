package com.DS.avl;
/**
 * ƽ���������һ������Ķ�����������ƽ������������������ĸ߶����ᳬ��1
 * @author ��־ΰ
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
		System.out.println("�������");
		avlTree.infixOrder();
		System.out.println(avlTree.getRoot().height());
		System.out.println(avlTree.getRoot().leftHeight());
		System.out.println(avlTree.getRoot().rightHeight());
		System.out.println(avlTree.getRoot());
		System.out.println(avlTree.getRoot().rightNode);
	}
}
//����AVL��
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
			//���û���ҵ�Ҫɾ���Ľڵ�
			if (targetNode == null) {
				return;
			}
			
			if (root.leftNode == null && root.rightNode ==null) {//�����ǰ����������ֻ��һ���ڵ�
				root = null;
				return;
			}
			Node parent = searchParent(value);
			//���Ҫɾ���Ľڵ���Ҷ�ӽڵ�
			if (targetNode.leftNode == null && targetNode.rightNode == null) {
				if (parent.leftNode != null && parent.leftNode.value == value) {//���Ҫ���ҵĽڵ��Ǹ��ڵ�����ӽڵ�
					parent.leftNode = null;
				}else if(parent.rightNode != null && parent.rightNode.value == value){
					parent.rightNode = null;
				}
			}else if (targetNode.leftNode != null && targetNode.rightNode != null) {
				int minVal = delRightTreeMin(targetNode.rightNode);
				targetNode.value = minVal;
			}else {//ɾ��ֻ��һ�������Ľڵ�
				if (targetNode.leftNode != null) {//���Ҫɾ���Ľڵ�ֻ�������ӽڵ�
					if (parent != null) {//���Ҫɾ���Ľڵ�û�и��ڵ㣬��ֱ�ӽ�root�ýڵ����ڵ�
						if (parent.leftNode.value == value) {//���Ҫɾ���Ľڵ����丸�ڵ�����ӽڵ�
							parent.leftNode = targetNode.leftNode;
						}else {
							parent.rightNode = targetNode.leftNode;
						}
					}else {
						root = targetNode.leftNode;
					}
				}else {//Ҫɾ���Ľڵ�ֻ�����ӽڵ�
					if (parent != null) {
						if (parent.leftNode.value == value) {//���Ҫɾ���Ľڵ����丸�ڵ�����ӽڵ�
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
	 * ���ص���nodeΪ���ڵ�Ķ�������������С�ڵ��ֵ
	 * ɾ��nodeΪ���ڵ�Ķ�������������С�ڵ��ֵ
	 * @param node����Ľڵ㣨���������������ĸ��ڵ㣩
	 * @return ���ص���nodeΪ���ڵ�Ķ�������������С�ڵ��ֵ
	 */
	public int delRightTreeMin(Node node){
		Node target = node;
		//ѭ���Ĳ�����ڵ㣬�ͻ��ҵ���Сֵ,���ݶ�����������������������Сֵ
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
			System.out.println("������������Ϊ�գ����ܱ���");
		}
	}
}

//�����ڵ�
class Node{
	int value;
	Node leftNode;
	Node rightNode;
	public Node(int value) {
		this.value = value;
	}
	
	//����ת
	public void leftRotate(){
		//����һ����ǰֵ�뵱ǰ�ڵ���ȵĽڵ�
		Node newNode = new Node(value);
		//���½ڵ�����ӽڵ����óɵ�ǰ�ڵ�����ӽڵ�
		newNode.leftNode = leftNode;
		//���½ڵ�����ӽڵ����óɵ�ǰ�ڵ�������������ӽڵ�
		newNode.rightNode = rightNode.leftNode;
		//����ǰ�ڵ��ֵ���óɵ�ǰ�ڵ�����ӽڵ��ֵ
		value = rightNode.value;
		//����ǰ�ڵ�����ӽڵ����ó��½ڵ�
		leftNode = newNode;
		//����ǰ�ڵ�����ӽڵ����óɵ�ǰ�ڵ�����ӽڵ�����ӽڵ�
		rightNode = rightNode.rightNode;
	}
	//����ת
	public void rightRotate(){
		Node newNode = new Node(value);
		newNode.rightNode = rightNode;
		newNode.leftNode = leftNode.rightNode;
		value = leftNode.value;
		rightNode = newNode;
		leftNode = leftNode.leftNode;
	}
	//�����������ĸ߶�
	public int leftHeight(){
		if (leftNode == null) {
			return 0;
		}
		return leftNode.height();
	}
	//�����������ĸ߶�
	public int rightHeight(){
		if (rightNode == null) {
			return 0;
		}
		return rightNode.height();
	}
	//���ص�ǰ�ڵ�ĸ߶�
	public int height(){
		return Math.max(leftNode == null ? 0 : leftNode.height(), rightNode == null ? 0 : rightNode.height()) + 1;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}


	/**
	 * ��ӽڵ�ķ���
	 * �ݹ����ʽ��ӽڵ㣬ע�����������������Ҫ��
	 * @param node
	 */
	public void add(Node node){
		if (node == null) {//���
			return;
		}
		//�жϴ���Ľڵ��ֵ���͵�ǰ�������ڵ�ֵ�ù�ϵ
		if (node.value < this.value) {
			if (this.leftNode == null) {
				this.leftNode = node;
			}else {
				this.leftNode.add(node);//�ݹ�������������
			}
		}else {
			if (this.rightNode == null) {
				this.rightNode = node;
			}else {
				this.rightNode.add(node);
			}
		}
		//����ǰ�ڵ���������ĸ߶�-�������ĸ߶�>1ʱ����������ת
		if (rightHeight() - leftHeight() > 1) {
			//�����ǰ�ڵ�����������������ĸ߶ȴ��ڵ�ǰ�ڵ�����������������ĸ߶�(˫��ת)
			if (rightNode != null && rightNode.leftHeight() > rightNode.rightHeight()) {
				rightNode.rightRotate();
			}
			leftRotate();
			return;
		}
		//����ǰ�ڵ���������ĸ߶�-�������ĸ߶�>1ʱ����������ת
		if (leftHeight() - rightHeight() > 1) {
			//�����ǰ�ڵ�����������������ĸ߶ȴ��ڵ�ǰ�ڵ�����������������ĸ߶�(˫��ת)
			if(leftNode != null && leftNode.rightHeight() > leftNode.leftHeight())
				//�ȶԵ�ǰ�ڵ����ڵ������ѡװ
				leftNode.leftRotate();
			//���ս�������ת
			rightRotate();
		}
	}
	/**
	 * �������
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
	 * ����Ҫɾ���Ľڵ�
	 * @param value ϣ��ɾ���ڵ��ֵ
	 * @return ����ҵ�����ֵ�ͷ��ظýڵ�
	 */
	public Node search(int value){
		if (value == this.value) {
			return this;
		}else if(value < this.value){//������ҵ�ֵС�ڵ�ǰ�ڵ㣬���������ݹ����
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
	 * ����Ҫɾ���ڵ�ĸ��ڵ�
	 * @param valueϣ��ɾ���ڵ��ֵ
	 * @return ����ҵ��ͷ��ظýڵ�ĸ��ڵ�
	 */
	public Node searchParent(int value){
		//�����ǰ�ڵ����Ҫɾ���ڵ�ĸ��ڵ㣬�ͷ���
		if ((this.leftNode != null && this.leftNode.value == value) || 
				(this.rightNode != null && this.rightNode.value == value)) {
			return this;
		}else {
			//������ҵ�ֵС�ڵ�ǰ�ڵ��ֵ�����ҵ��ҽڵ�����ӽڵ㲻Ϊ��
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