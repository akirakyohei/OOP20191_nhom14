package oop.articleDAO;

import java.util.Map;

import com.arangodb.entity.BaseDocument;

public class PullArticleDAO {
public  void thongtinNhanVat(String dinhDanh) {
	QueryArticle query= new QueryArticle();
	BaseDocument object= query.thongTinVe(dinhDanh, "Person");
	Map<String, Object> map= object.getProperties();
	System.out.println(map.get("dinhDanh"));
}

public static void main(String[] args) {
	PullArticleDAO dao=new PullArticleDAO();
	
	dao.thongtinNhanVat("Albert_Einstein");
	
}
	
}
