package ImportData;

import java.util.ArrayList;

import oop.articleDAO.PushDatabase;
import oop.beans.Country;
import oop.beans.Event;
import oop.beans.Fact;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;
import oop.generatedata.GenerateCountries;
import oop.generatedata.GenerateEvents;
import oop.generatedata.GenerateFacts;
import oop.generatedata.GenerateLocations;
import oop.generatedata.GenerateOrganizations;
import oop.generatedata.GeneratePersons;
import oop.generatedata.GenerateTimes;
import oop.generatedata.IGenerate;

public class InsertData {
	public void loadData(int entityCount,int factCount) {
		
		int entityCount1=entityCount/6;
		int entityCount2=entityCount-entityCount1*5;
				
		//sinh du lieu thuc the
		IGenerate gen= new GenerateCountries();
		ArrayList<Country> dsCountries=(ArrayList<Country>) gen.generate(entityCount1);
		//for(Country d:dsCountries)System.out.println(d.getDinhDanh());
		gen= new  GenerateEvents();
		ArrayList<Event> dsEvents=(ArrayList<Event>) gen.generate(entityCount1);
		//for(Event d:dsEvents)System.out.println(d.getDinhDanh());
		gen=new  GenerateLocations();
		ArrayList<Location> dsLocations=(ArrayList<Location>) gen.generate(entityCount1);
		//for(Location d:dsLocations)System.out.println(d.getDinhDanh());
		gen=new  GenerateOrganizations();
		ArrayList<Organization> dsOrganizations=(ArrayList<Organization>) gen.generate(entityCount1); 
		
		gen=new  GeneratePersons();
		ArrayList<Person> dsPersons=(ArrayList<Person>) gen.generate(entityCount1);
		
		gen=new  GenerateTimes();
		ArrayList<Time> dsTime=(ArrayList<Time>) gen.generate(entityCount2);
		
		int factCount1=factCount/12;
		int factCount2=factCount-factCount1*11;
		//sinh du lieu quan he
		ArrayList<Fact> factDienRaTai=GenerateFacts.generate("diễn ra tại", dsEvents, dsLocations,factCount1);
		//for(Fact d:factDienRaTai)System.out.println(d.getObject()+" "+d.getQuanHe()+" "+d.getSubject());
		ArrayList<Fact> factDienRaLuc=GenerateFacts.generate("diễn ra lúc", dsEvents, dsTime, factCount1);
		ArrayList<Fact> factToChuc = GenerateFacts.generate("tổ chức",dsOrganizations, dsEvents, factCount1);
		ArrayList<Fact> factDenTham = GenerateFacts.generate("đến thăm",dsPersons, dsLocations, factCount1);
		ArrayList<Fact> factGapMat = GenerateFacts.generate("gặp mặt",dsPersons, dsPersons, factCount1);
		ArrayList<Fact> factThanhLap = GenerateFacts.generate("thành lập",dsPersons, dsOrganizations, factCount1);
		ArrayList<Fact> factLaNguoiToChuc = GenerateFacts.generate("là người tổ chức",dsPersons, dsEvents, factCount1);
		ArrayList<Fact> factDienRaTaiNuoc = GenerateFacts.generate("diễn ra tại",dsEvents, dsCountries, factCount1);
		ArrayList<Fact> factThuocNuoc = GenerateFacts.generate("thuộc nước",dsLocations, dsCountries, factCount1);
		ArrayList<Fact> quanThanhLapVaoThoiGian= GenerateFacts.generate("thành lập vào",dsOrganizations, dsTime, factCount1);
		ArrayList<Fact> factQuanLy =GenerateFacts.generate("quản lí",dsPersons, dsOrganizations, factCount1);
		ArrayList<Fact> factPhatBieuTai = GenerateFacts.generate("phát biểu tại",dsPersons, dsEvents, factCount2);
;		
//load du lieu len database
// load thuc the 
String DATABASENAME="OOP20191";
 PushDatabase dao=new PushDatabase(DATABASENAME);
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
//dao.close();
	}
}
