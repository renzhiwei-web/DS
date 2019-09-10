package com.algorithm;

import java.util.Arrays;

/**
 * 字符串匹配算法(模式匹配算法)
 * @author 任志伟
 *	KMP中最重要的就是部分匹配值的计算，通过计算字串的前缀与后缀中公共的字符串的长度就是部分匹配值
 */
public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "jav jav jav jav jva java";
		String str2 = "java";
		int index = violenceMatch(str1, str2);
		System.out.println(index);
		int[] next = KMPNext(str2);
		System.out.println(Arrays.toString(next));
		System.out.println(KMPMatch(str1, str2, next));
		
	}
	/**
	 * KMP模式匹配
	 * @param str1
	 * @param str2
	 * @param next 部分匹配表
	 * @return
	 */
	public static int KMPMatch(String str1,String str2,int[] next) {
		//i索引指向主串，j索引指向字串
		for(int i = 0,j = 0;i < str1.length();i++){
			while(j > 0 && str1.charAt(i) != str2.charAt(j)){
				j = next[j - 1];
			}
			if(str1.charAt(i) == str2.charAt(j)){
				j++;
			}
			if (j == str2.length()) {
				return i - j + 1;
			}
		}
		return -1;
		
	}
	/**
	 * 求出部分匹配值的表
	 * @param dest
	 * @return
	 */
	public static int[] KMPNext(String dest){
		int[] next = new int[dest.length()];
		next[0] = 0;//如果j字符串长度为1，部分匹配值就是0
		for(int i = 1,j = 0;i < dest.length();i++){
			while(j > 0 && dest.charAt(i) != dest.charAt(j)){
				j = next[j - 1];
			}
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
	/**
	 * 暴力匹配算法
	 * @param str1 要匹配的字符串
	 * @param str2 字串
	 * @return
	 */
	public static int violenceMatch(String str1,String str2){
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int s1Len = s1.length;
		int s2Len = s2.length;
		int i = 0;//i索引指向s1
		int j = 0;//j索引指向s2
		while(i < s1Len && j < s2Len){
			if (s1[i] == s2[j]) {//如果匹配成功
				i++;
				j++;
			}else {
				i = i - (j - 1);//如果匹配不成功，则进行回溯
				j = 0;
			}
		}
		if (j == s2Len) {
			return i - j;
		}
		return -1;
	}
}
