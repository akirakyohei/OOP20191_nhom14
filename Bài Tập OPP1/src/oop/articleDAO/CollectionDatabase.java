package oop.articleDAO;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDBException;

import oop.connectionDB.DatabaseArangoDB;

public class CollectionDatabase {

	private DatabaseArangoDB database;

	public CollectionDatabase(String nameDatabase) {
		database = new DatabaseArangoDB(nameDatabase);
	}
	
/**
 * Tạo collection  
 * @param name:tên collection 
 */
	public void createCollection(String name) {
		try {
			database.getConnection().createCollection(name);
		} catch (ArangoDBException e) {
			System.out.println("create collection " + name + " " + e.getErrorMessage());
		}
	}
	
/**
 * Xoá collection 
 * @param name:tên collection 
 */
	public void dropCollection(String name) {
		try {
			ArangoCollection col = database.getConnection().collection(name);
			col.drop();
		} catch (ArangoDBException e) {
			System.out.println("create collection " + name + " " + e.getErrorMessage());
		}
	}
/**
 * Lấy Collection 
 * @param name:tên collection 
 * @return collection 
 */
	public ArangoCollection getCollection(String name) {
		ArangoCollection col = database.getConnection().collection(name);
		return col;
	}
/**
 * đóng database 
 */
	public void close() {
		database.close();
	}

}
