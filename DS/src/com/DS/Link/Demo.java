package com.DS.Link;

public class Demo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		DoubleLink doubleLink = new DoubleLink();
		doubleLink.addByOrder(hero2);
		doubleLink.addByOrder(hero3);
		doubleLink.addByOrder(hero1);
		doubleLink.addByOrder(hero4);
		doubleLink.list();
//		HeroNode newhHeroNode = new HeroNode(4, "����", "����");
//		doubleLink.update(newhHeroNode);
//		System.out.println("===================");
//		doubleLink.list();
//		System.out.println(doubleLink.getHead());
	}
}
