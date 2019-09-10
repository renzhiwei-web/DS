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
