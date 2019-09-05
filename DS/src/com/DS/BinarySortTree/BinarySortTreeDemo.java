package com.DS.BinarySortTree;
/**
 * ����������
 * @author ��־ΰ
 *
 */
public class BinarySortTreeDemo {
	public static void main(String[] args) {
		int[] arr = {7,3,10,12,5,1,9,2};
		BinarySortTree tree = new BinarySortTree();
		for(int i = 0;i < arr.length;i++)
			tree.add(new Node(arr[i]));
		System.out.println("�����������������");
		tree.infixOrder();
		
	}
}
class BinarySortTree{
	private Node root;
	
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
}