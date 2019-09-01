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
		List<Node1> nodes = getNodes(bytes);//得到每个字符对应的哈夫曼编码权值（还不是哈夫曼编码）
		System.out.println(nodes);
		Node1 createHuffmanTree = createHuffmanTree(nodes);//通过构建哈夫曼树
		createHuffmanTree.perOrder();
		Map<Byte, String> codes = getCodes(createHuffmanTree);//得到每个字符对应的哈夫曼编码
		System.out.println(codes);
		byte[] zip = zip(bytes, codes);//将str字符串用哈夫曼数组编码，再进行压缩等到的字节数组
		System.out.println(Arrays.toString(zip));//17
		
	}
	//编写一个方法，将字符串对应的byte数组，通过生成哈弗曼编码表，返回一个哈夫曼编码压缩后的byte
	/**
	 * 
	 * @param bytes原始字符串对应的byte数组
	 * @param codes生成的哈夫曼编码map
	 * @return
	 */
	private static byte[] zip(byte[] bytes,Map<Byte, String> codes){
		StringBuilder stringBuilder = new StringBuilder();
		for(byte b : bytes){
			stringBuilder.append(codes.get(b));
			
		}
		//将字符串转成byte数组
		int len;
		len = (stringBuilder.length() + 7) / 8;//统计返回byte数组的长度
		//创建存储压缩后的byte数组
		byte[] by = new byte[len];
		int index = 0;//记录第几个byte
		for(int i = 0;i < stringBuilder.length(); i += 8){
			String strByte;
			if(i + 8 > stringBuilder.length()){//不够8位
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i + 8);
			}
			//将strByte转成一个byte，放入到by中
			by[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}
		return by;
		
	}
	/**
	 * 生成哈夫曼树对应的哈夫曼编码
	 * 思路：
	 * 1.将哈夫曼编码表存放在map集合中
	 * 2.生成哈夫曼编码表示，需要去拼接路径，定义一个stringbuilder存储某个叶子节点的路径
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
			System.out.println("树空");
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
	Byte data;//通过ASCII码值存储
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