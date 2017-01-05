package com.adelmo.json.test;

import net.sf.json.JSONArray;

import java.sql.SQLException;
import java.util.List;

public class TestJson {

    public static void main(String[] args) throws SQLException {
//		JSONArray jsonArray = new JSONArray();
        Dao dao = new Dao();
//		jsonArray = dao.getAll();
//		System.out.println(jsonArray);
//		System.out.println("----------------------------------");
//
//		List list = (List) JSONArray.toCollection(jsonArray);
//		List<TreeJson> parent =  JsonUtils.formatTree(list);
//		Iterator<TreeJson> it = list.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next().toString());
//		}
//		System.out.println("=====");
//		Iterator it = jsonArray.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next().toString());
//		}
//		for(int i =0 ;i<jsonArray.size();i++){
//			System.out.println(jsonArray.get(i).toString());
//		}
        String parentId = "0";
//		String moduleId = "report_left";
        List<TreeJson> trList = dao.queryATree(parentId);
        JSONArray jsonArray = JSONArray.fromObject(trList);
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i).toString());
        }

//		Iterator<TreeJson> itList = trList.iterator();
//		while(itList.hasNext()){
//			System.out.println(itList.next().toString());
//		}

    }
}
