package oop.articleDAO;

import java.util.ArrayList;
import java.util.Map;

import com.arangodb.ArangoDatabase;
import com.arangodb.util.MapBuilder;

import oop.beans.Country;
import oop.beans.Event;
import oop.beans.Fact;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;
import oop.connectDB.ConnectArangoDB;

public class PushArticleDAO {
    private static ArangoDatabase arangoDatabase ;
   private static CreateArticle query;
  public PushArticleDAO() {
	  arangoDatabase = new  ConnectArangoDB().getConnection();
	  System.out.println(arangoDatabase.toString());
	  query=new CreateArticle();
	  query.setArangodatabase(arangoDatabase);
}

public static void addPerson(ArrayList<Person> p) {
	  for(int i=0 ;i<p.size();i++) {
		  Person per=p.get(i);
		  Map<String ,Object> map = new MapBuilder().get();
		  map.put("dinhDanh",per.getDinhDanh());
		  map.put("moTa",per.getMoTa() );
		  map.put("nhanHienthi", per.getNhanHienThi());
		  map.put("chucVu", per.getChucVu());
		  map.put("link",per.getLink());
		  map.put("ngayTrichRut",per.getNgayTrichRut());
		  map.put("quocTich",per.getQuocTich());
		 query.addDocument("Person", map);
	  }
	  
  }

  public static void addCountry(ArrayList<Country> c) {
	  for(int i=0 ;i<c.size();i++) {
		 Country co=c.get(i);
		  Map<String ,Object> map = new MapBuilder().get();
		  map.put("dinhDanh",co.getDinhDanh());
		  map.put("moTa",co.getMoTa() );
		  map.put("nhanHienthi", co.getNhanHienThi());
		  map.put("link",co.getLink());
		  map.put("ngayTrichRut",co.getNgayTrichRut());
		  map.put("dienTich",co.getDienTich());
		 query.addDocument("Country", map);
	  }
  }
  
  public static void addEvent(ArrayList<Event> e) {
	  for(int i=0 ;i<e.size();i++) {
			Event ev=e.get(i);
			  Map<String ,Object> map = new MapBuilder().get();
			  map.put("dinhDanh",ev.getDinhDanh());
			  map.put("moTa",ev.getMoTa() );
			  map.put("nhanHienthi", ev.getNhanHienThi());
			  map.put("link",ev.getLink());
			  map.put("ngayTrichRut",ev.getNgayTrichRut());
			 query.addDocument("Event", map);
		  }
  }
  public static void addLocation(ArrayList<Location> l) {
	  for(int i=0 ;i<l.size();i++) {
		Location lo=l.get(i);
		  Map<String ,Object> map = new MapBuilder().get();
			  map.put("dinhDanh",lo.getDinhDanh());
			  map.put("moTa",lo.getMoTa() );
			  map.put("nhanHienthi", lo.getNhanHienThi());
			  map.put("link",lo.getLink());
			  map.put("ngayTrichRut",lo.getNgayTrichRut());
			 query.addDocument("Location", map);
		  }
	  }
  public static void addOrganization(ArrayList<Organization> o) {
	  for(int i=0 ;i<o.size();i++) {
			Organization or=o.get(i);
			  Map<String ,Object> map = new MapBuilder().get();
				  map.put("dinhDanh",or.getDinhDanh());
				  map.put("moTa",or.getMoTa() );
				  map.put("nhanHienthi", or.getNhanHienThi());
				  map.put("link",or.getLink());
				  map.put("ngayTrichRut",or.getNgayTrichRut());
				 map.put("truSo", or.getTruSo());
				 query.addDocument("Organization", map);
			  }
  }
  
  public static void addTime(ArrayList<Time> t) {
	  for(int i=0 ;i<t.size();i++) {
			Time ti=t.get(i);
			  Map<String ,Object> map = new MapBuilder().get();
				  map.put("dinhDanh",ti.getDinhDanh());
				  map.put("moTa",ti.getMoTa() );
				  map.put("nhanHienthi", ti.getNhanHienThi());
				  map.put("link",ti.getLink());
				  map.put("ngayTrichRut",ti.getNgayTrichRut());
				 query.addDocument("Time", map);
			  }
	  }
  public static void addFact(ArrayList<Fact> f) {
	  for(int i=0 ;i<f.size();i++) {
			Fact fa=f.get(i);
			  Map<String ,Object> map = new MapBuilder().get();
				  map.put("object",fa.getObject());
				  map.put("fact",fa.getQuanHe());
				  map.put("subject", fa.getSubject());
				 query.addDocument("Fact", map);
			  }
  }

}
