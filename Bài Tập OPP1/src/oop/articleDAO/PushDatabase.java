package oop.articleDAO;

import java.util.ArrayList;
import java.util.Map;

import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.util.MapBuilder;

import oop.beans.Aggrement;
import oop.beans.Country;
import oop.beans.Event;
import oop.beans.Fact;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;

public class PushDatabase {
private CollectionDatabase collection;

public PushDatabase(String nameDatabase) {
	collection=new CollectionDatabase(nameDatabase);
}


public void close() {
	collection.close();
}


public void addDocuments(String nameCollection,ArrayList<BaseDocument> array) {
	try {
		
	 collection.getCollection(nameCollection).insertDocuments(array);
	
	} catch (ArangoDBException e) {
		System.out.println("Failed to create document. " + e.getMessage());
	}
}


public void addPerson(ArrayList<Person> p) {
	ArrayList<BaseDocument> array=new ArrayList<>();
	  for(int i=0 ;i<p.size();i++) {
		  Person per=p.get(i);
		  BaseDocument doc=new BaseDocument();
		  doc.setKey(per.getDinhDanh());
		  Map<String ,Object> map = new MapBuilder().get();
		  map.put("moTa",per.getMoTa() );
		  map.put("nhanHienThi", per.getNhanHienThi());
		  map.put("chucVu", per.getChucVu());
		  map.put("link",per.getLink());
		  map.put("ngayTrichRut",per.getNgayTrichRut());
		  map.put("quocTich",per.getQuocTich());
		  doc.setProperties(map);
		  array.add(doc);
		  
	  }
	 addDocuments("Person", array);
  }


  public  void addCountry(ArrayList<Country> c) {
	  ArrayList<BaseDocument> array=new ArrayList<>();
	  for(int i=0 ;i<c.size();i++) {
		 Country co=c.get(i);  BaseDocument doc=new BaseDocument();
		  doc.setKey(co.getDinhDanh());
		  Map<String ,Object> map = new MapBuilder().get();
		  map.put("dinhDanh",co.getDinhDanh());
		  map.put("moTa",co.getMoTa() );
		  map.put("nhanHienThi", co.getNhanHienThi());
		  map.put("link",co.getLink());
		  map.put("ngayTrichRut",co.getNgayTrichRut());
		  map.put("dienTich",co.getDienTich());
		  doc.setProperties(map);
		  array.add(doc);
	  }
	  addDocuments("Country", array);
  }
  
  
  public  void addEvent(ArrayList<Event> e) {
	  ArrayList<BaseDocument> array=new ArrayList<>();
	  for(int i=0 ;i<e.size();i++) {
			Event ev=e.get(i);
			  BaseDocument doc=new BaseDocument();
			  doc.setKey(ev.getDinhDanh());
			  Map<String ,Object> map = new MapBuilder().get();
			  map.put("moTa",ev.getMoTa() );
			  map.put("nhanHienThi", ev.getNhanHienThi());
			  map.put("link",ev.getLink());
			  map.put("ngayTrichRut",ev.getNgayTrichRut());
			  doc.setProperties(map);
			  array.add(doc);
		  }
	  addDocuments("Event", array);
  }
  
  public  void addLocation(ArrayList<Location> l) {
	  ArrayList<BaseDocument> array=new ArrayList<>();
	  for(int i=0 ;i<l.size();i++) {
		Location lo=l.get(i);
		 BaseDocument doc=new BaseDocument();
		  doc.setKey(lo.getDinhDanh());
		  Map<String ,Object> map = new MapBuilder().get();
			  map.put("dinhDanh",lo.getDinhDanh());
			  map.put("moTa",lo.getMoTa() );
			  map.put("nhanHienThi", lo.getNhanHienThi());
			  map.put("link",lo.getLink());
			  map.put("ngayTrichRut",lo.getNgayTrichRut());doc.setProperties(map);
			  array.add(doc);
		  }
	  addDocuments("Location", array);
	  }
  
  
  public void addOrganization(ArrayList<Organization> o) {
	  ArrayList<BaseDocument> array=new ArrayList<>();
	  for(int i=0 ;i<o.size();i++) {
			Organization or=o.get(i);
			  BaseDocument doc=new BaseDocument();
			  doc.setKey(or.getDinhDanh());
			  Map<String ,Object> map = new MapBuilder().get();
				  map.put("moTa",or.getMoTa() );
				  map.put("nhanHienThi", or.getNhanHienThi());
				  map.put("link",or.getLink());
				  map.put("ngayTrichRut",or.getNgayTrichRut());
				 map.put("truSo", or.getTruSo());doc.setProperties(map);
				 array.add(doc);
			  }
	  addDocuments("Organization", array);
	  
  }
  
  
  public  void addTime(ArrayList<Time> t) {
	 ArrayList<BaseDocument> array=new ArrayList<>();
	  for(int i=0 ;i<t.size();i++) {
			Time ti=t.get(i);
			  BaseDocument doc=new BaseDocument();
			doc.setKey(ti.getDinhDanh());
			  Map<String ,Object> map = new MapBuilder().get();
				  map.put("moTa",ti.getMoTa() );
				  map.put("nhanHienThi", ti.getNhanHienThi());
				  map.put("link",ti.getLink());
				  map.put("ngayTrichRut",ti.getNgayTrichRut());
				  doc.setProperties(map);
				array.add(doc);
				System.out.println(doc.toString());
			  }
	  
	  addDocuments("Time",array);
	  }
  
  
  public  void addAggrement(ArrayList<Aggrement> t) {
		 ArrayList<BaseDocument> array=new ArrayList<>();
		  for(int i=0 ;i<t.size();i++) {
				Aggrement ti=t.get(i);
				  BaseDocument doc=new BaseDocument();
				doc.setKey(ti.getDinhDanh());
				  Map<String ,Object> map = new MapBuilder().get();
					  map.put("moTa",ti.getMoTa() );
					  map.put("nhanHienThi", ti.getNhanHienThi());
					  map.put("link",ti.getLink());
					  map.put("ngayTrichRut",ti.getNgayTrichRut());
					  doc.setProperties(map);
					array.add(doc);
					System.out.println(doc.toString());
				  }
		  
		  addDocuments("Aggrement",array);
		  }
  
  
  
  public void addFact(ArrayList<Fact> f) {
	  ArrayList<BaseDocument> array=new ArrayList<>();
	  for(int i=0 ;i<f.size();i++) {
			Fact fa=f.get(i);
			  BaseDocument doc=new BaseDocument();
			  Map<String ,Object> map = new MapBuilder().get();
				  map.put("object",fa.getObject());
				  map.put("fact",fa.getQuanHe());
				  map.put("subject", fa.getSubject());doc.setProperties(map);
				  array.add(doc);
			  }
	  addDocuments("Fact",array);
  }

	
}
