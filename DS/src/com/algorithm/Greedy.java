package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 贪心算法：集合覆盖的问题
 * @author 任志伟
 *
 */
public class Greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建集合
		Map<String , HashSet<String>> map = new HashMap<String, HashSet<String>>();
		HashSet<String> set1 = new HashSet<String>();
		set1.add("北京");
		set1.add("上海");
		set1.add("天津");
		HashSet<String> set2 = new HashSet<String>();
		set2.add("北京");
		set2.add("广州");
		set2.add("深圳");
		HashSet<String> set3 = new HashSet<String>();
		set3.add("成都");
		set3.add("上海");
		set3.add("杭州");
		HashSet<String> set4 = new HashSet<String>();
		set4.add("上海");
		set4.add("天津");
		HashSet<String> set5 = new HashSet<String>();
		set5.add("杭州");
		set5.add("大连");
		map.put("k1", set1);
		map.put("k2", set2);
		map.put("k3", set3);
		map.put("k4", set4);
		map.put("k5", set5);
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("北京");
		allAreas.add("上海");
		allAreas.add("天津");
		allAreas.add("杭州");
		allAreas.add("广州");
		allAreas.add("深圳");
		allAreas.add("大连");
		allAreas.add("成都");
		List<String> selects = new ArrayList<String>();
		//定义一个临时的集合，存放遍历过程中电台覆盖的地区和当前还没有覆盖的地区的交集
		HashSet<String> tempSet = new HashSet<String>();
		//定义maxKey，保存在一次遍历中，能够覆盖最大覆盖地区对应的电台key
		String maxKey = null;
		while(allAreas.size() != 0){//如果allAreas不为0，则表示还没有覆盖到所有的地区
			//取出对应的key
			maxKey = null;
			for(String key : map.keySet()){
				tempSet.clear();
				HashSet<String> areas = map.get(key);
				tempSet.addAll(areas);
				//求出tempSet和allAreas 集合的交集，交集会赋给tempset
				tempSet.retainAll(allAreas);
				//如果当前这个集合包含的未覆盖地区的数量，比maxKey指向的集合地区还多，就需要maxKey
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
