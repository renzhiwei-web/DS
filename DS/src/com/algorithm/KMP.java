package com.algorithm;

import java.util.Arrays;

/**
 * �ַ���ƥ���㷨(ģʽƥ���㷨)
 * @author ��־ΰ
 *	KMP������Ҫ�ľ��ǲ���ƥ��ֵ�ļ��㣬ͨ�������ִ���ǰ׺���׺�й������ַ����ĳ��Ⱦ��ǲ���ƥ��ֵ
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
	 * KMPģʽƥ��
	 * @param str1
	 * @param str2
	 * @param next ����ƥ���
	 * @return
	 */
	public static int KMPMatch(String str1,String str2,int[] next) {
		//i����ָ��������j����ָ���ִ�
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
	 * �������ƥ��ֵ�ı�
	 * @param dest
	 * @return
	 */
	public static int[] KMPNext(String dest){
		int[] next = new int[dest.length()];
		next[0] = 0;//���j�ַ�������Ϊ1������ƥ��ֵ����0
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
	 * ����ƥ���㷨
	 * @param str1 Ҫƥ����ַ���
	 * @param str2 �ִ�
	 * @return
	 */
	public static int violenceMatch(String str1,String str2){
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int s1Len = s1.length;
		int s2Len = s2.length;
		int i = 0;//i����ָ��s1
		int j = 0;//j����ָ��s2
		while(i < s1Len && j < s2Len){
			if (s1[i] == s2[j]) {//���ƥ��ɹ�
				i++;
				j++;
			}else {
				i = i - (j - 1);//���ƥ�䲻�ɹ�������л���
				j = 0;
			}
		}
		if (j == s2Len) {
			return i - j;
		}
		return -1;
	}
}
