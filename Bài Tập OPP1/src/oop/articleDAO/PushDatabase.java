package oop.articleDAO;

import java.util.ArrayList;
import java.util.Map;

import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.model.DocumentCreateOptions;
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
		collection = new CollectionDatabase(nameDatabase);
	}
/**
 * đóng collection 
 */
	public void close() {
		collection.close();
	}

	public void addDocuments(String nameCollection, ArrayList<BaseDocument> array) {
		try {

			collection.getCollection(nameCollection).insertDocuments(array,new DocumentCreateOptions().waitForSync(true));
		} catch (ArangoDBException e) {
			System.out.println("Failed to create document. " + e.getMessage());
		}
	}
/**
 * nhập các dữ liệu person vào database 
 * @param p:mảng các phần tử person 
 */
	public void addPerson(ArrayList<Person> p) {
		ArrayList<BaseDocument> array = new ArrayList<>();
		for (int i = 0; i < p.size(); i++) {
			Person per = p.get(i);
			BaseDocument doc = new BaseDocument();
			doc.setKey(per.getDinhDanh());
			Map<String, Object> map = new MapBuilder().get();
			map.put("moTa", per.getMoTa());
			map.put("nhanHienThi", per.getNhanHienThi());
			map.put("chucVu", per.getChucVu());
			map.put("link", per.getLink());
			map.put("quocTich", per.getQuocTich());
			doc.setProperties(map);
			array.add(doc);

		}
		addDocuments("Person", array);
	}
	/**
	 * nhập các dữ liệu country vào database 
	 * @param c:mảng các phần tử country  
	 */
	public void addCountry(ArrayList<Country> c) {
		ArrayList<BaseDocument> array = new ArrayList<>();
		for (int i = 0; i < c.size(); i++) {
			Country co = c.get(i);
			BaseDocument doc = new BaseDocument();
			doc.setKey(co.getDinhDanh());
			Map<String, Object> map = new MapBuilder().get();
			map.put("dinhDanh", co.getDinhDanh());
			map.put("moTa", co.getMoTa());
			map.put("nhanHienThi", co.getNhanHienThi());
			map.put("link", co.getLink());
			map.put("dienTich", co.getDienTich());
			doc.setProperties(map);
			array.add(doc);
		}
		addDocuments("Country", array);
	}
	/**
	 * nhập các dữ liệu  event vào database 
	 * @param e:mảng các phần tử event 
	 */
	public void addEvent(ArrayList<Event> e) {
		ArrayList<BaseDocument> array = new ArrayList<>();
		for (int i = 0; i < e.size(); i++) {
			Event ev = e.get(i);
			BaseDocument doc = new BaseDocument();
			doc.setKey(ev.getDinhDanh());
			Map<String, Object> map = new MapBuilder().get();
			map.put("moTa", ev.getMoTa());
			map.put("nhanHienThi", ev.getNhanHienThi());
			map.put("link", ev.getLink());
			doc.setProperties(map);
			array.add(doc);
		}
		addDocuments("Event", array);
	}
	/**
	 * nhập các dữ liệu location  vào database 
	 * @param l:mảng các phần tử location  
	 */
	public void addLocation(ArrayList<Location> l) {
		ArrayList<BaseDocument> array = new ArrayList<>();
		for (int i = 0; i < l.size(); i++) {
			Location lo = l.get(i);
			BaseDocument doc = new BaseDocument();
			doc.setKey(lo.getDinhDanh());
			Map<String, Object> map = new MapBuilder().get();
			map.put("dinhDanh", lo.getDinhDanh());
			map.put("moTa", lo.getMoTa());
			map.put("nhanHienThi", lo.getNhanHienThi());
			map.put("link", lo.getLink());
			doc.setProperties(map);
			array.add(doc);
		}
		addDocuments("Location", array);
	}
	/**
	 * nhập các dữ liệu organization vào database 
	 * @param o:mảng các phần tử organization 
	 */
	public void addOrganization(ArrayList<Organization> o) {
		ArrayList<BaseDocument> array = new ArrayList<>();
		for (int i = 0; i < o.size(); i++) {
			Organization or = o.get(i);
			BaseDocument doc = new BaseDocument();
			doc.setKey(or.getDinhDanh());
			Map<String, Object> map = new MapBuilder().get();
			map.put("moTa", or.getMoTa());
			map.put("nhanHienThi", or.getNhanHienThi());
			map.put("link", or.getLink());
			map.put("truSo", or.getTruSo());
			doc.setProperties(map);
			array.add(doc);
		}
		addDocuments("Organization", array);
	}
	/**
	 * nhập các dữ liệu time vào database 
	 * @param p:mảng các phần tử time 
	 */
	public void addTime(ArrayList<Time> t) {
		ArrayList<BaseDocument> array = new ArrayList<>();
		for (int i = 0; i < t.size(); i++) {
			Time ti = t.get(i);
			BaseDocument doc = new BaseDocument();
			doc.setKey(ti.getDinhDanh());
			Map<String, Object> map = new MapBuilder().get();
			map.put("moTa", ti.getMoTa());
			map.put("nhanHienThi", ti.getNhanHienThi());
			map.put("link", ti.getLink());
			doc.setProperties(map);
			array.add(doc);
		}
		addDocuments("Time", array);
	}
	/**
	 * nhập các dữ liệu aggrement vào database 
	 * @param a:mảng các phần tử aggrement  
	 */
	public void addAggrement(ArrayList<Aggrement> a) {
		ArrayList<BaseDocument> array = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			Aggrement ti = a.get(i);
			BaseDocument doc = new BaseDocument();
			doc.setKey(ti.getDinhDanh());
			Map<String, Object> map = new MapBuilder().get();
			map.put("moTa", ti.getMoTa());
			map.put("nhanHienThi", ti.getNhanHienThi());
			map.put("link", ti.getLink());
			doc.setProperties(map);
			array.add(doc);
		}

		addDocuments("Aggrement", array);
	}
	/**
	 * nhập các dữ liệu fact vào database 
	 * @param p:mảng các phần tử fact  
	 */
	public void addFact(ArrayList<Fact> f) {
		ArrayList<BaseDocument> array = new ArrayList<>();
		for (int i = 0; i < f.size(); i++) {
			Fact fa = f.get(i);
			BaseDocument doc = new BaseDocument();
			Map<String, Object> map = new MapBuilder().get();
			map.put("object", fa.getObject());
			map.put("fact", fa.getQuanHe());
			map.put("subject", fa.getSubject());
			map.put("ngayTrichRut", fa.getNgayTrichRut());
			doc.setProperties(map);
			array.add(doc);
		}
		addDocuments("Fact", array);
	}

}
