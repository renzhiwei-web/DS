package com.DS.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		byte[] bytes = str.getBytes();
		System.out.println(bytes.length);//40
		List<Node1> nodes = getNodes(bytes);//�õ�ÿ���ַ���Ӧ�Ĺ���������Ȩֵ�������ǹ��������룩
		System.out.println(Arrays.toString(bytes));
		System.out.println(nodes);
		Node1 createHuffmanTree = createHuffmanTree(nodes);//ͨ��������������
		createHuffmanTree.perOrder();
		Map<Byte, String> codes = getCodes(createHuffmanTree);//�õ�ÿ���ַ���Ӧ�Ĺ���������
		System.out.println(codes);
		byte[] zip = zip(bytes, codes);//��str�ַ����ù�����������룬�ٽ���ѹ���ȵ����ֽ�����
		System.out.println(Arrays.toString(zip));//17
		byte[] huffmanZip = huffmanZip(bytes);
		System.out.println(Arrays.toString(huffmanZip));
		byte[] decode = decode(codes, zip);
		System.out.println(new String(decode));
		
	}
	/**
	 * ������ݵĽ�ѹ
	 * ˼·
	 *1.��ѹ������ֽ�����ת�ɶ������ַ���
	 *2.���չ��������뽫�������ַ���ת��ԭʼ���ַ���
	 *��һ��byteת��һ�������Ƶ��ַ���
	 * @param b
	 * @param flag ��ʶ�Ƿ���Ҫ����λ��true��ʾ��Ҫ����λ
	 * @return �Ǹ�byte��Ӧ�Ķ����Ƶ��ַ�����ע���ǰ����뷵�صģ�
	 */
	private static String byteToBitString(Boolean flag,byte b){
		int temp = b;
		if (flag) {
			temp |= 256;//��λ��
		}
		
		String str = Integer.toBinaryString(temp);//���ص��Ƕ����ƵĲ���
		if (flag) {
			return str.substring(str.length() - 8);
		}else {
			return str;
		}
	}
	/**
	 * 
	 * @param huffmanCodes �����������map
	 * @param huffmanBytes ����������õ����ֽ�����
	 * @return �õ�ԭ�����ַ���
	 */
	private static byte[] decode(Map<Byte, String> huffmanCodes,byte[] huffmanBytes){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0;i < huffmanBytes.length;i++){
			byte b = huffmanBytes[i];
			//�ж��ǲ������һ���ֽ�
			boolean flag = (i == huffmanBytes.length - 1);
			stringBuilder.append(byteToBitString(!flag, b));
		}
		
		//���ַ�����װָ���Ĺ�����������б���
		//�ѹ�����������е�������Ϊ�����ѯ(��������)
		Map<String, Byte> map = new HashMap<String, Byte>();
		for(Map.Entry<Byte, String> entry : huffmanCodes.entrySet()){
			map.put(entry.getValue(), entry.getKey());
		}
		List<Byte> list = new ArrayList<Byte>();
		for(int i = 0;i < stringBuilder.length();){
			int count = 1;
			boolean flag = true;
			Byte b = null;
			while(flag){
				//������ȡ��key
				String key = stringBuilder.substring(i,i+count);
				b = map.get(key);
				if (b == null) {
					count++;
				}else {
					flag = false;
				}
			}
			list.add(b);
			i += count;//iֱ���ƶ���count
		}
		//��forѭ��������list�оʹ�������е��ַ�
		//��list�е����ݷ��뵽byte����������
		byte b[] = new byte[list.size()];
		for(int i = 0;i < b.length;i++)
			b[i] = list.get(i);
		return b;
	}
	
	
	/**
	 * ʹ��һ���������������ѹ���������з�װ���������ǵĵ���
	 * @param bytes ԭʼ���ַ��������Ӧ���ֽ�����
	 * @return �������������봦�����ֽ����飨ѹ��������飩
	 */
	private static byte[] huffmanZip(byte[] bytes){
		List<Node1> nodes = getNodes(bytes);//�õ�ÿ���ַ���Ӧ�Ĺ���������Ȩֵ�������ǹ��������룩
		Node1 createHuffmanTree = createHuffmanTree(nodes);//ͨ��������������
		Map<Byte, String> codes = getCodes(createHuffmanTree);//�õ�ÿ���ַ���Ӧ�Ĺ���������
		byte[] zip = zip(bytes, codes);//��str�ַ����ù�����������룬�ٽ���ѹ���ȵ����ֽ�����
		return zip;
		
	}
	
	//��дһ�����������ַ�����Ӧ��byte���飬ͨ�����ɹ��������������һ������������ѹ�����byte
	/**
	 * 
	 * @param bytesԭʼ�ַ�����Ӧ��byte����
	 * @param codes���ɵĹ���������map
	 * @return
	 */
	private static byte[] zip(byte[] bytes,Map<Byte, String> codes){
		StringBuilder stringBuilder = new StringBuilder();
		for(byte b : bytes){
			stringBuilder.append(codes.get(b));
			
		}
		//���ַ���ת��byte����
		int len;
		len = (stringBuilder.length() + 7) / 8;//ͳ�Ʒ���byte����ĳ���
		//�����洢ѹ�����byte����
		byte[] by = new byte[len];
		int index = 0;//��¼�ڼ���byte
		for(int i = 0;i < stringBuilder.length(); i += 8){
			String strByte;
			if(i + 8 > stringBuilder.length()){//����8λ
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i + 8);
			}
			//��strByteת��һ��byte�����뵽by��
			by[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}
		return by;
		
	}
	/**
	 * ���ɹ���������Ӧ�Ĺ���������
	 * ˼·��
	 * 1.�����������������map������
	 * 2.���ɹ����������ʾ����Ҫȥƴ��·��������һ��stringbuilder�洢ĳ��Ҷ�ӽڵ��·��
	 * 
	 */
	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	
	static StringBuilder stringBuilder = new StringBuilder();
	
	static Map<Byte,String> getCodes(Node1 root){
		if (root == null) {
			return null;
		}
		getCodes(root.leftNode, "0", stringBuilder);
		getCodes(root.rightNode, "1", stringBuilder);
		return huffmanCodes;
	}
	
	static void getCodes(Node1 node,String code,StringBuilder stringBuilder){
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			if (node.data == null) {
				
				getCodes(node.leftNode, "0", stringBuilder2);
				getCodes(node.rightNode, "1", stringBuilder2);
			}else {
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}
	
	public static void preOrder(Node root){
		if (root != null) {
			root.perOrder();
		}else {
			System.out.println("����");
		}
	}
	
	public static Node1 createHuffmanTree(List<Node1> nodes){
		while(nodes.size() > 1){
			Collections.sort(nodes);
			Node1 leftNode = nodes.get(0);
			Node1 rightNode = nodes.get(1);
			Node1 parent = new Node1(null,leftNode.weight + rightNode.weight);
			parent.leftNode = leftNode;
			parent.rightNode = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	public static List<Node1> getNodes(byte[] bytes){
		ArrayList<Node1> nodes = new ArrayList<Node1>();
		Map<Byte, Integer> counts = new HashMap<Byte, Integer>();
		for(byte b : bytes){
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count + 1);
			}
		}
		for(Map.Entry<Byte, Integer> entry : counts.entrySet()){
			nodes.add(new Node1(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}
}
class Node1 implements Comparable<Node1>{
	Byte data;//ͨ��ASCII��ֵ�洢
	int weight;
	Node1 leftNode;
	Node1 rightNode;
	
	public Node1(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}
	@Override
	
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}
	
	public void perOrder(){
		System.out.println(this);
		if (this.leftNode != null) {
			this.leftNode.perOrder();
		}
		if (this.rightNode != null) {
			this.rightNode.perOrder();
		}
	}
	@Override
	public int compareTo(Node1 o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
}