package oop.main;

import java.util.ArrayList;

import oop.articleDAO.QueryDatabase;

public class TestQueryMain {

	public static void main(String[] args) {
		String namDatabase="OOP20191";
		QueryDatabase qd= new QueryDatabase();
		ArrayList<String> queries=qd.addQuery();
		ArrayList<Long> arr=qd.testQueries(queries, namDatabase);
		for(Long s:arr)System.out.println(s);
	}

}