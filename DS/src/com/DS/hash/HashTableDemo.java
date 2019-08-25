package com.DS.hash;

import java.util.Scanner;

public class HashTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable hashTable = new HashTable(7);
		
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("add：添加雇员");
			System.out.println("list：显示雇员");
			System.out.println("exit：退出系统");
			System.out.println("find:查找雇员");
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hashTable.add(emp);
				break;
				
			case "list":
				hashTable.list();
				break;
				
			case"find":
				System.out.println("输入要查找的id");
				int findId = scanner.nextInt();
				hashTable.findEmpByid(findId);
				break;
			default:
				scanner.close();
				System.exit(0);
				break;
			}
		}
	}

}
