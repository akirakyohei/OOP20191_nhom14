package oop.articleDAO;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import oop.connectDB.ConnectArangoDB;

public class QueryArticle {
	private ArangoDatabase database;
	public QueryArticle() {
		this.database = ConnectArangoDB.getConnection();
	}

	public BaseDocument thongTinVe(String dinhDanh,String collection) {
		//String query1="FOR t IN Person FILTER t.dinhDanh == \"Albert_Einstein\" return t";
		String query="FOR t IN "+collection+" FILTER t.dinhDanh == \""+dinhDanh+"\" return t";
		ArangoCursor<BaseDocument> cursor=database.query(query, null, null, BaseDocument.class);
		return cursor.next();
	}
	
	
	
}
