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