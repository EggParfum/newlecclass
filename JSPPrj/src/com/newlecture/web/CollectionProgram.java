package com.newlecture.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newlecture.web.entity.Member;

public class CollectionProgram {

	public static void main(String[] args) {
		
		Object[] members = new Object[10];
		members[0] = new Member();
		members[1] = new Member();
		
		((Member)members[0]).getNicName();
		
		
		
		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(100);

		
		System.out.println(list.get(1));
		
		Set set = new HashSet();
		set.add(10);
		set.add(100);
		set.add("hello");
		set.add(2.3);
		//°ªÀÌ °ð Å°
		for(Object n : set)
			System.out.println(n);
		
		Map map = new HashMap();
		map.put("id", 1);
		map.put("title", "Hello baby");
		map.put("hit", 12);
		
		for(Object k : map.keySet())
			System.out.println(k);
		
		for(Object v : map.values())
			System.out.println(v);
		
		
		System.out.println(map.get("title"));
		

	}

}
