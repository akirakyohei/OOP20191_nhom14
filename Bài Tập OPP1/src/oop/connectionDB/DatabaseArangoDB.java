package oop.connectionDB;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.Protocol;

public class DatabaseArangoDB {
	private ArangoDB driver;
	private ArangoDatabase database;
	public DatabaseArangoDB(String nameDatabase) {
		//cấu hình kết nối database 
		try {
			this.driver = new ArangoDB.Builder().timeout(100).host("127.0.0.1", 8529).user("root").password("")
					.useProtocol(Protocol.VST).build();
			this.database = driver.db(nameDatabase);
		} catch (ArangoDBException e) {
			System.out.println("Connection fail" + e.getErrorMessage());
		}

	}
	
	/**
	 * tạo kết nối với database 
	 * 
	 */
	public ArangoDatabase getConnection() {
		return this.database;
	}
/**
 * đóng kết nối 
 */
	public void close() {
		try {
			driver.shutdown();
		} catch (ArangoDBException e) {
			System.out.println("Close connection error " + e.getErrorMessage());
		}

	}

}
