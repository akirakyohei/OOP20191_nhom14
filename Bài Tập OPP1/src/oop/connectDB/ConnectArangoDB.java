package oop.connectDB;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.Protocol;

public class ConnectArangoDB {
	private static String databaseName = "OOP20191";

	public static ArangoDatabase getConnection() {

		
		ArangoDatabase database = null;
		ArangoDB conn = new ArangoDB.Builder().timeout(100).host("127.0.0.1",8529).user("root").password("").useProtocol(Protocol.VST).build();
		try {
			database = conn.db(databaseName);
			System.out.println("Connect database success!");
		} catch (ArangoDBException e) {
			System.out.println("Connect database fail!");
		}

		return database;
	}
	
}
