package com.coding.datemoudle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Member {
	public List<Map> getMemberList()
	{
		List<Map> memberList=new ArrayList();
		Map map1=new HashMap();
		map1.put("cardId", "6236609999");  //卡号
		map1.put("cardName", "马丁");  //姓名 
		map1.put("cardTpye", "0");  //卡片类型
		map1.put("cardPoints", "9860"); //积分
		memberList.add(map1);
		
		Map map2=new HashMap();
		map2.put("cardId", "6630009999");
		map2.put("cardName", "王立");
		map2.put("cardTpye", "1");
		map2.put("cardPoints", "48860");
		memberList.add(map2);
		
		Map map3=new HashMap();
		map3.put("cardId", "8230009999");
		map3.put("cardName", "李想");
		map3.put("cardTpye", "2");
		map3.put("cardPoints", "98860");
		memberList.add(map3);
		
		Map map4=new HashMap();
		map4.put("cardId", "9230009999");
		map4.put("cardName", "张三");
		map4.put("cardTpye", "3");
		map4.put("cardPoints", "198860");
		memberList.add(map4);
		
		return memberList;
		
	}
}
