package oop.articleDAO;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDBException;

import oop.connectionDB.DatabaseArangoDB;

public class CollectionDatabase {

	private DatabaseArangoDB database;

	public CollectionDatabase(String nameDatabase) {
		database = new DatabaseArangoDB(nameDatabase);
	}

	public void createCollection(String name) {
		try {
			database.getConnection().createCollection(name);
		} catch (ArangoDBException e) {
			System.out.println("create collection " + name + " " + e.getErrorMessage());
		}
	}

	public void dropCollection(String name) {
		try {
			ArangoCollection col = database.getConnection().collection(name);
			col.drop();
		} catch (ArangoDBException e) {
			System.out.println("create collection " + name + " " + e.getErrorMessage());
		}
	}

	public ArangoCollection getCollection(String name) {
		ArangoCollection col = database.getConnection().collection(name);
		return col;
	}

	public void close() {
		database.close();
	}

}
