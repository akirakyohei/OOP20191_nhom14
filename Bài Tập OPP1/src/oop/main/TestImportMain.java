package oop.main;

import oop.ImportData.InsertData;

public class TestImportMain {
	public static void main(String[] args) {
		InsertData create=new InsertData();
		long start=System.currentTimeMillis();
		create.loadData(600, 600);
		long end= System.currentTimeMillis();
		System.out.println(end-start);

	}
}
