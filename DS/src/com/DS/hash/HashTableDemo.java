package com.DS.hash;

import java.util.Scanner;

public class HashTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable hashTable = new HashTable(7);
		
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("add����ӹ�Ա");
			System.out.println("list����ʾ��Ա");
			System.out.println("exit���˳�ϵͳ");
			System.out.println("find:���ҹ�Ա");
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("����id");
				int id = scanner.nextInt();
				System.out.println("��������");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hashTable.add(emp);
				break;
				
			case "list":
				hashTable.list();
				break;
				
			case"find":
				System.out.println("����Ҫ���ҵ�id");
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
