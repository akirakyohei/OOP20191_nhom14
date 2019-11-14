package oop.generatedata;

import java.util.ArrayList;

import oop.articleDAO.PushArticleDAO;
import oop.beans.Country;
import oop.beans.Event;
import oop.beans.Fact;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;

public class CreateData {
	public void loadData(int entityCount,int factCount) {
		
		//sinh du lieu thuc the
		Generate gen= new GenerateCountries();
		ArrayList<Country> dsCountries=(ArrayList<Country>) gen.generate(entityCount);
		//for(Country d:dsCountries)System.out.println(d.getDinhDanh());
		gen=new  GenerateEvents();
		ArrayList<Event> dsEvents=(ArrayList<Event>) gen.generate(entityCount);
		//for(Event d:dsEvents)System.out.println(d.getDinhDanh());
		gen=new  GenerateLocations();
		ArrayList<Location> dsLocations=(ArrayList<Location>) gen.generate(entityCount);
		//for(Location d:dsLocations)System.out.println(d.getDinhDanh());
		gen=new  GenerateOrganizations();
		ArrayList<Organization> dsOrganizations=(ArrayList<Organization>) gen.generate(entityCount); 
		
		gen=new  GeneratePersons();
		ArrayList<Person> dsPersons=(ArrayList<Person>) gen.generate(entityCount);
		
		gen=new  GenerateTimes();
		ArrayList<Time> dsTime=(ArrayList<Time>) gen.generate(entityCount);
		
		//sinh du lieu quan he
		ArrayList<Fact> factDienRaTai=GenerateFacts.generate("diễn ra tại", dsEvents, dsLocations,factCount);
		for(Fact d:factDienRaTai)System.out.println(d.getObject()+" "+d.getQuanHe()+" "+d.getSubject());
		ArrayList<Fact> factDienRaLuc=GenerateFacts.generate("diễn ra lúc", dsEvents, dsTime, factCount);
		ArrayList<Fact> factToChuc = GenerateFacts.generate("tổ chức",dsOrganizations, dsEvents, factCount);
		ArrayList<Fact> factDenTham = GenerateFacts.generate("đến thăm",dsPersons, dsLocations, factCount);
		ArrayList<Fact> factGapMat = GenerateFacts.generate("gặp mặt",dsPersons, dsPersons, factCount);
		ArrayList<Fact> factThanhLap = GenerateFacts.generate("thành lập",dsPersons, dsOrganizations, factCount);
		ArrayList<Fact> factLaNguoiToChuc = GenerateFacts.generate("là người tổ chức ",dsPersons, dsEvents, factCount);
		ArrayList<Fact> factDienRaTaiNuoc = GenerateFacts.generate("diễn ra tại ",dsEvents, dsCountries, factCount);
		ArrayList<Fact> factThuocNuoc = GenerateFacts.generate("thuộc nước",dsLocations, dsCountries, factCount);
		ArrayList<Fact> quanThanhLapVaoThoiGian= GenerateFacts.generate("thành lập vào",dsOrganizations, dsTime, factCount);
		ArrayList<Fact> factQuanLy =GenerateFacts.generate("quản lí",dsPersons, dsOrganizations, factCount);
		ArrayList<Fact> factPhatBieuTai = GenerateFacts.generate("phát biểu tại",dsPersons, dsEvents, factCount);
;		
//load du lieu len database
// load thuc the 
 PushArticleDAO dao= new PushArticleDAO();
 dao.addCountry(dsCountries);
 dao.addEvent(dsEvents);
 dao.addLocation(dsLocations);
dao.addOrganization(dsOrganizations);
dao.addPerson(dsPersons);
dao.addTime(dsTime);
//load quan he
dao.addFact(factPhatBieuTai);
dao.addFact(factDienRaLuc);
dao.addFact(factQuanLy);
dao.addFact(factThuocNuoc);
dao.addFact(factDienRaTaiNuoc);
dao.addFact(factLaNguoiToChuc);
dao.addFact(factThanhLap);
dao.addFact(factGapMat);
dao.addFact(factDenTham);
dao.addFact(factToChuc);
dao.addFact(factDienRaTaiNuoc);		
	}
public static void main(String[] args) {
	CreateData create=new CreateData();
	long start=System.currentTimeMillis();
	create.loadData(600000, 600000);
	long end= System.currentTimeMillis();
	System.out.println(end-start);
}
}
