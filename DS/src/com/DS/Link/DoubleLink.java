package com.DS.Link;

public class DoubleLink {

	private HeroNode head = new HeroNode(0, "", "");
	public HeroNode getHead(){
		return head;
	}
	public void list(){
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	public void add(HeroNode heroNode){
		HeroNode temp = head;
		while(true){
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.per = temp;
	}
	public void update(HeroNode newHeroNode){
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head;
		boolean flag = false;
		while(true){
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		}else {
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ㣬�����޸�\n",newHeroNode.no);
		}
	}
	public void delete(int no){
		if (head.next == null) {
			System.out.println("����Ϊ�գ��޷�ɾ��");
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while(true){
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.per.next = temp.next;
			if (temp.next != null) {
				temp.next.per = temp.per;
			}
			
		}else {
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ�",no);
		}
	}
	public void addByOrder(HeroNode heroNode){
		HeroNode temp = head;
		boolean flag = false;
		while(true){
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			}else if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("�Ѿ��иýڵ����Ϣ�����ܼ���");
		}else {
			heroNode.next = temp.next;
			if (temp.next !=null ) {
				heroNode.next.per = heroNode;
			}
			temp.next = heroNode;
			heroNode.per = temp;
		}
	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;
	public HeroNode per;
	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

}