package oop.main;

import oop.ImportData.InsertData;

public class TestImportMain {
	public static void main(String[] args) {
		String nameDatabase="OOP20191";
		InsertData create=new InsertData(nameDatabase);
		long start=System.currentTimeMillis();
		create.loadData(600, 600);
		long end= System.currentTimeMillis();
		System.out.println(end-start);

	}
}
