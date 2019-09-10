package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * ̰���㷨�����ϸ��ǵ�����
 * @author ��־ΰ
 *
 */
public class Greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		Map<String , HashSet<String>> map = new HashMap<String, HashSet<String>>();
		HashSet<String> set1 = new HashSet<String>();
		set1.add("����");
		set1.add("�Ϻ�");
		set1.add("���");
		HashSet<String> set2 = new HashSet<String>();
		set2.add("����");
		set2.add("����");
		set2.add("����");
		HashSet<String> set3 = new HashSet<String>();
		set3.add("�ɶ�");
		set3.add("�Ϻ�");
		set3.add("����");
		HashSet<String> set4 = new HashSet<String>();
		set4.add("�Ϻ�");
		set4.add("���");
		HashSet<String> set5 = new HashSet<String>();
		set5.add("����");
		set5.add("����");
		map.put("k1", set1);
		map.put("k2", set2);
		map.put("k3", set3);
		map.put("k4", set4);
		map.put("k5", set5);
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("����");
		allAreas.add("�Ϻ�");
		allAreas.add("���");
		allAreas.add("����");
		allAreas.add("����");
		allAreas.add("����");
		allAreas.add("����");
		allAreas.add("�ɶ�");
		List<String> selects = new ArrayList<String>();
		//����һ����ʱ�ļ��ϣ���ű��������е�̨���ǵĵ����͵�ǰ��û�и��ǵĵ����Ľ���
		HashSet<String> tempSet = new HashSet<String>();
		//����maxKey��������һ�α����У��ܹ�������󸲸ǵ�����Ӧ�ĵ�̨key
		String maxKey = null;
		while(allAreas.size() != 0){//���allAreas��Ϊ0�����ʾ��û�и��ǵ����еĵ���
			//ȡ����Ӧ��key
			maxKey = null;
			for(String key : map.keySet()){
				tempSet.clear();
				HashSet<String> areas = map.get(key);
				tempSet.addAll(areas);
				//���tempSet��allAreas ���ϵĽ����������ḳ��tempset
				tempSet.retainAll(allAreas);
				//�����ǰ������ϰ�����δ���ǵ�������������maxKeyָ��ļ��ϵ������࣬����ҪmaxKey
				if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > map.get(maxKey).size())) {
					maxKey = key;
				}
			}
			if (maxKey != null) {
				selects.add(maxKey);
				allAreas.removeAll(map.get(maxKey));
			}
		}
		System.out.println(selects);
	}

}
