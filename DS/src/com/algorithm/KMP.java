package com.algorithm;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "jav jav jav jav jva java";
		String str2 = "java";
		int index = violenceMatch(str1, str2);
		System.out.println(index);
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
