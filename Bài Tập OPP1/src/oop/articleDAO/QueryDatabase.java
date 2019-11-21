package oop.articleDAO;

import java.util.ArrayList;

import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;

import oop.ConnectionDB.DatabaseArangoDB;

public class QueryDatabase {

	public ArrayList<String > addQuery(){
		ArrayList<String> queries= new ArrayList<>();
		//Cau truy van don gian

		//1 Lay thong tin ve "Albert_Einstein_7"
		queries.add(" for p in Person "+
		" filter p._key==\"Albert_Einstein_7\""+
		" return p");

		//2 lay thong tin ve "Bo_Dao_Nha_65"
				queries.add("for c in Country"+
		" filter c._key==\"Bo_Dao_Nha_65\""+
		" return c");

		//3 lay thong tin ve "kham_pha_CX-5_2020_96"
				queries.add("for e in Event"+
		" filter e._key==\"kham_pha_CX-5_2020_96\""+
		" return e");

		//4 lay thong tin ve "Deo_Pha_Din_5"
				queries.add("for l in Location"+
		" filter l._key==\"Deo_Pha_Din_5\""+
		" return l");

		//5 lay thong tin ve "Apple_10"
				queries.add("for o in Organization"+
		" filter o._key==\"Apple_10\""+
		" return o");

		//6 lay thon tin "2_9_2014_78"
				queries.add("for t in Time"+
		" filter t._key==\"2_9_2014_78\""+
		" return t");

		//7 lay ten to chuc nao cos tru so tai Tòa nhà FPT, số 17 Duy Tân, quận Cầu Giấy, Hà Nội, Việt Nam
				queries.add("for o In Organization "+
		" filter o.truSo==\"Tòa nhà FPT, số 17 Duy Tân, quận Cầu Giấy, Hà Nội, Việt Nam\""+
		" return {ten:o.nhanHienThi}");

		//8 "Anh_tham_du_EURO_2020_22" dien ra luc nao?
				queries.add("for f in Fact"
		+" filter f.object==\"Anh_tham_du_EURO_2020_22\" and f.fact==\"diễn ra lúc\""+
		" return f.subject");

		//9 "Cau_thu_Quang_Hai_35" phat bieu tai nhung noi nao 
				queries.add("for f in Fact"+
		" filter f.object==\"Cau_thu_Quang_Hai_35\" and f.fact==\"phát biểu tại\""+
		" return f.subject");

		//10 lay mo ta , din tich quoc gia Viet_Nam_26
				queries.add("for c In Country"
		+" filter c._key==\"Viet_Nam_26\""+
		" return {Mo_ta:c.moTa ,Dien_tich:c.dienTich}");

		//Cau truy van Thong ke
		//1 lay tat ca tin tuc lien quan den quan he to chuc
		queries.add("	for f in Fact "
		+" filter f.fact ==\"tổ chức\""+
		" return f");
		//2 Lay cac su kien trich rut trong ngay 8/3/2019
				queries.add("for e in Event "+
		" filter e.ngayTrichRut==\"8/3/2019\""+
		" return {ten: e.nhanHienThi}");

		//3 lay thong tin ve nhung nguoi quan li "Trung_nguyen_19
				queries.add("for f in Fact"
		 +" for p in Person"
		  +" filter f.object==p._key and f.fact==\"quản lí\" and f.subject ==\"Trung_nguyen_19\""+
		  " return p");
		  
		//4 lay cac tin lien quan den Mark_Zuckerberg_8 hoac Nhac_si Trinh_Cong_Son_68
				  queries.add("for f in Fact "+
		 " filter f.object==\"Mark_Zuckerberg_8\" or f.object==\"Nhac_si_Trinh_Cong_Son_68\""+
		 " return f");
		 

		  //5 lay ten , chu vu cua nhung nguoi là người tổ chức "Mien_thi_thuc_cho_du_khach_30"
				 queries.add("for f in Fact"
		  +" for p in Person"+
		  " filter f.object==p._key and f.fact==\"là người tổ chức\" and f.subject ==\"Mien_thi_thuc_cho_du_khach_30\""+
		  " return {ten:p.nhanHienThi,Chucvu:p.chucVu}");
		  
		  //6 nhung su kien nao dien ra ngay 21_11_2014_4
		  queries.add("  for f in Fact"
		 +" for e in Event "+
		  " filter f.object==e._key and f.fact==\"diễn ra lúc\" and f.subject ==\"21_11_2014_4\""+
		  " return e");
		  
		//7 dem so su kien dien ra tai phap_49
				  queries.add(" return {soluong:count("+
		" for f in Fact"+
		  " for e in Event"+
		  " filter f.object==e._key and f.fact==\"diễn ra tại\" and f.subject==\"Phap_49\""+
		  " return {ten: e.nhanHienThi})}");
		  
		  //8 lay cac tin co lien quan den thu mon dang van lam
				  queries.add(" for f in Fact"+
		  " for p in Person"+
		  " filter (f.object==p._key or f.subject==p._key) and p.nhanHienThi==\"Thủ môn Đặng Văn Lâm\""+
		  " return f");
		  
		  //9  thủ tướng da gap nhung ai
				  queries.add(" for f in Fact "+
		" for p in Person"+
		 " filter p._key==f.object and p.chucVu==\"Thủ tướng\" and f.fact==\"gặp mặt\""+
		 " return f.subject ");
		 
		  //10 nhung su kien dien ra ngay "12_2_2017_23" dien ra tai nhung dau ?
				 queries.add(" for s in (for  f in Fact"+
		" filter f.fact ==\"diễn ra lúc\" and f.subject ==\"12_6_2015_39\""+
		" return {sukien : f.object }"+
		" )"+
		" for f1 in Fact "+
		" filter f1.fact==\"diễn ra tại\" and f1.object== s.sukien"+
		" return f1.subject");
	 return queries;	  
	}
	public void query(ArrayList<String>queries ,String nameDatabase) {
		DatabaseArangoDB database= new DatabaseArangoDB(nameDatabase);
		try{for(String q:queries) {
		
			ArangoCursor<BaseDocument> cursor=database.getConnection().query(q, null, null, BaseDocument.class);
		while(cursor.hasNext()) {
			System.out.println(cursor.next().getProperties().toString());
		}
		}}catch(ArangoDBException e) {
			System.out.println(e.getErrorMessage());
		}
		database.close();
	}
	public ArrayList<Long> testQueries(ArrayList<String>queries ,String nameDatabase) {
		ArrayList<Long> arr= new ArrayList<>();
		long start,end;
		DatabaseArangoDB database= new DatabaseArangoDB(nameDatabase);
		try{for(String q:queries) {
		start=System.currentTimeMillis();
			ArangoCursor<BaseDocument> cursor=database.getConnection().query(q, null, null, BaseDocument.class);
			BaseDocument base=cursor.next();
		end=System.currentTimeMillis();
		arr.add( (end-start));
			while(cursor.hasNext()) {
			System.out.println(cursor.next().getProperties().toString());
		}
		}}catch(ArangoDBException e) {
			System.out.println(e.getErrorMessage());
		}
		database.close();
		return arr;
	}

}
