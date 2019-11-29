package oop.main;

import java.io.File;
import java.io.IOException;

import oop.articleDAO.CollectionDatabase;
import oop.importdata.InsertData;

public class TestImportMain {
	public static void main(String[] args) {

		String nameDatabase = "OOP20191";
		InsertData create = new InsertData(nameDatabase);
		CollectionDatabase collectionDatabase = new CollectionDatabase(nameDatabase);

		// tạo môi trường cơ bản cho các lần test
		// xoá dữ liệu cũ trong database
		String[] arr = { "Person", "Event", "Location", "Time", "Country", "Aggrement", "Organization", "Fact" };
		for (String s : arr) {
			collectionDatabase.dropCollection(s);
			collectionDatabase.createCollection(s);
		}

		// xoá dữ liệu cũ trong file key
		String[] namefiles = { "data/key_country.txt", "data/key_event.txt", "data/key_location.txt",
				"data/key_organization.txt", "data/key_time.txt", "data/key_person.txt", "data/key_aggrement.txt" };
		for (String f : namefiles) {
			File file = new File(f);
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("create file fail" + e.getMessage());
			}
		}
		// bat dau test
		System.out.println("start");
		long start = System.currentTimeMillis();

		try {
			create.loadData(600000, 600000);
		} catch (IOException e) {
			System.out.println("load fail " + e.getMessage());
		}
		long end = System.currentTimeMillis();
		System.out.println("Finished!");
		System.out.println(end - start);

	}
}
