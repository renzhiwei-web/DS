package com.DS.hash;

public class HashTable {

	private EmpLinkedList[] empLinkedList;
	private int size;
	
	public HashTable(int size){
		this.size = size;
		empLinkedList = new EmpLinkedList[size];
		for(int i = 0;i < size;i++)
			empLinkedList[i] = new EmpLinkedList();
	}
	
	public void add(Emp emp){
		int empLinkedListNO = hashFun(emp.id);
		empLinkedList[empLinkedListNO].add(emp);
	}
	
	public void list(){
		for(int i = 0;i < size;i++){
			empLinkedList[i].list();
		}
	}
	
	public void findEmpByid(int id){
		int empLinkedListNO = hashFun(id);
		Emp emp = empLinkedList[empLinkedListNO].findEmpByid(id);
		if (emp != null) {
			System.out.println(emp);
		}else {
			System.out.println("没有该雇员");
		}
	}
	//编写散列函数
	public int hashFun(int id){
		return id % size;
	}
}



class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	
	
}

class EmpLinkedList {
	private Emp head;

	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}
		Emp curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		curEmp.next = emp;
	}
	
	public void list(){
		if (head == null) {
			System.out.println("当前列表为空");
			return;
		}
		Emp curEmp = head;
		while(true){
			System.out.print(curEmp + "\t");
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		System.out.println();
	}
	
	public Emp findEmpByid(int id){
		if (head == null) {
			System.out.println("链表为空");
			return null;
		}
		Emp curEmp = head;
		while(true){
			if (curEmp.id == id) {
				break;
			}
			if (curEmp.next == null) {
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;
	}
}