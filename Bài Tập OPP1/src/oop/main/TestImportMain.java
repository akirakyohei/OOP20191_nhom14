package oop.main;

import oop.articleDAO.CollectionDatabase;
import oop.importdata.InsertData;

public class TestImportMain {
	public static void main(String[] args) {
		String nameDatabase = "OOP20191";
		InsertData create = new InsertData(nameDatabase);
		CollectionDatabase collectionDatabase = new CollectionDatabase(nameDatabase);
		String[] arr = { "Person", "Event", "Location", "Time", "Country", "Aggrement", "Fact", "Organization" };
		for (String s : arr) {
			collectionDatabase.dropCollection(s);
			collectionDatabase.createCollection(s);
		}
		long start = System.currentTimeMillis();
		create.loadData(600, 600);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}
}
