package com.coding.datemoudle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
	public static Map getProduct(String Id)
	{ 
		List<Map> productList=new ArrayList();
		Map map1=new HashMap();
		map1.put("Id", "001001");      //产品号
		map1.put("Name", "世园会五十国钱币册");  //产品名称
		map1.put("Unit", "册");  //单位
		map1.put("Price", "998.00");  //单价
		map1.put("preferential", "");  //优惠类型
		map1.put("fullreduction", "");  //满减类型
		productList.add(map1);
		
		Map map2=new HashMap();
		map2.put("Id", "001002");
		map2.put("Name", "2019北京世园会纪念银章大全40g");
		map2.put("Unit", "盒");
		map2.put("Price", "1380.00");
		map2.put("preferential", "1");
		map2.put("fullreduction", "");
		productList.add(map2);
		
		Map map3=new HashMap();
		map3.put("Id", "001003");
		map3.put("Name", "招财进宝");
		map3.put("Unit", "条");
		map3.put("Price", "1580.00");
		map3.put("preferential", "2");
		map3.put("fullreduction", "");
		productList.add(map3);
		
		Map map4=new HashMap();
		map4.put("Id", "003002");
		map4.put("Name", "水晶之恋");
		map4.put("Unit", "盒");
		map4.put("Price", "980.00");
		map4.put("preferential", "");
		map4.put("fullreduction", "1");
		productList.add(map4);
		
		Map map5=new HashMap();
		map5.put("Id", "002002");
		map5.put("Name", "中国经典钱币套装");
		map5.put("Unit", "套");
		map5.put("Price", "998.00");
		map5.put("preferential", "");
		map5.put("fullreduction", "2");
		productList.add(map5);
		
		Map map6=new HashMap();
		map6.put("Id", "002001");
		map6.put("Name", "守扩之羽比翼双飞4.8g");
		map6.put("Unit", "条");
		map6.put("Price", "1080.00");
		map6.put("preferential", "1");
		map6.put("fullreduction", "1");
		productList.add(map6);
		
		Map<String, String> map7=new HashMap();
		map7.put("Id", "002003");
		map7.put("Name", "中国银象棋12g");
		map7.put("Unit", "套");
		map7.put("Price", "698.00");
		map7.put("preferential", "2");
		map7.put("fullreduction", "3");
		productList.add(map7);
		Map mapresult=new HashMap();
		for(Map item:productList)
		{
			String id =item.get("Id").toString();
		   if(id.equals(Id))
		   {
			   return item;
		   }
		}
		return mapresult;
		
	}
}
