package oop.importdata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import oop.articleDAO.PushDatabase;
import oop.beans.Aggrement;
import oop.beans.Country;
import oop.beans.Event;
import oop.beans.Fact;
import oop.beans.Location;
import oop.beans.Organization;
import oop.beans.Person;
import oop.beans.Time;
import oop.generatedata.Data;
import oop.generatedata.GenerateAggrement;
import oop.generatedata.GenerateCountries;
import oop.generatedata.GenerateEvents;
import oop.generatedata.GenerateFacts;
import oop.generatedata.GenerateLocations;
import oop.generatedata.GenerateOrganizations;
import oop.generatedata.GeneratePersons;
import oop.generatedata.GenerateTimes;
import oop.generatedata.IGenerate;

public class InsertData {
	private final String NAMEDATABASE;
	private final int MAXSIZE = 100000;
	private PushDatabase dao;
	private IGenerate gen;
	private File file;

	public InsertData(String nameDatabase) {
		this.NAMEDATABASE = nameDatabase;
	}

	public void loadData(int entityCount, int factCount) throws IOException {

		dao = new PushDatabase(NAMEDATABASE);

		// sinh du lieu thuc the
		// chia đều số lượng cho các thực thể
		int entityCount1 = entityCount / 7;
		int entityCount2 = entityCount - entityCount1 * 6;

		// sinh country
		loadCountry(entityCount1);
		// sinh Event
		loadEvent(entityCount1);
		// sinh location
		loadLocation(entityCount1);
		// sinh Organization
		loadOrganization(entityCount1);
		// sinh Person
		loadPerson(entityCount1);
		// sinh Time
		loadTime(entityCount1);
		// sinh Aggrement
		loadAggrement(entityCount2);

		// sinh du lieu quan he
		// chia deu so luong cho cac quan he
		int factCount1 = factCount / 13;
		int factCount2 = factCount - factCount1 * 12;

		// Lấy nhãn các thực thể
		ArrayList<String> nhanCountries = Data.readData("data/key_country.txt");
		ArrayList<String> nhanEvents = Data.readData("data/key_event.txt");
		ArrayList<String> nhanLocations = Data.readData("data/key_location.txt");
		ArrayList<String> nhanOrganizations = Data.readData("data/key_organization.txt");
		ArrayList<String> nhanPersons = Data.readData("data/key_location.txt");
		ArrayList<String> nhanTimes = Data.readData("data/key_time.txt");
		ArrayList<String> nhanAggrements = Data.readData("data/key_aggrement.txt");
		ArrayList<String> ngayTrichRuts = Data.readData("data/NgayTrichRut.txt");
		// sinh quan he

		// quan he dien ra tai
		loadFact("diễn ra tại", nhanEvents, nhanLocations, ngayTrichRuts, factCount1);

		// quan he dien ra luc
		loadFact("diễn ra lúc", nhanEvents, nhanTimes, ngayTrichRuts, factCount1);

		// quan he to chuc
		loadFact("tổ chức", nhanOrganizations, nhanEvents, ngayTrichRuts, factCount1);

		// quan he den tham
		loadFact("đến thăm", nhanPersons, nhanLocations, ngayTrichRuts, factCount1);

		// quan he gap mat
		loadFact("gặp mặt", nhanPersons, nhanPersons, ngayTrichRuts, factCount1);

		// quan he thanh lap
		loadFact("thành lập", nhanPersons, nhanOrganizations, ngayTrichRuts, factCount1);

		// quanhe la nguoi to chuc
		loadFact("là người tổ chức", nhanPersons, nhanEvents, ngayTrichRuts, factCount1);

		// quan he dien ra tai
		loadFact("diễn ra tại", nhanEvents, nhanCountries, ngayTrichRuts, factCount1);

		// quan he thuoc nuoc
		loadFact("thuộc nước", nhanLocations, nhanCountries, ngayTrichRuts, factCount1);

		// quan he thanh lap vao
		loadFact("thành lập vào", nhanOrganizations, nhanTimes, ngayTrichRuts, factCount1);

		// quan he quan li
		loadFact("quản lí", nhanPersons, nhanOrganizations, ngayTrichRuts, factCount1);

		// quanhe phat bieu tai
		loadFact("phát biểu tại", nhanPersons, nhanEvents, ngayTrichRuts, factCount1);

		// quan he ki ket
		loadFact("kí kết", nhanPersons, nhanAggrements, ngayTrichRuts, factCount2);

		dao.close();
	}

	/**
	 * thực hiện sinh và đẩy dữ liệu vào database
	 * 
	 * @param soLuong
	 * @throws IOException
	 */
	public void loadFact(String fact, ArrayList<String> objects, ArrayList<String> subjects,
			ArrayList<String> ngayTrichRuts, int soLuong) {
		int start = 0;
		int size;
		while (soLuong > 0) {
			size = Math.min(soLuong, MAXSIZE);
			ArrayList<Fact> factKiket = GenerateFacts.generate(fact, objects, subjects, ngayTrichRuts, start, size);
			dao.addFact(factKiket);
			start += size;
			soLuong -= size;
			factKiket.clear();
		}
	}

	/**
	 * thực hiện sinh và đẩy dữ liệu vào database
	 * 
	 * @param soLuong
	 * @throws IOException
	 */
	public void loadCountry(int soLuong) throws IOException {
		gen = new GenerateCountries();
		gen.readAtribute();
		file = new File("data/key_country.txt");
		int start = 0;
		int size;
		while (soLuong > 0) {
			size = Math.min(soLuong, MAXSIZE);
			ArrayList<Country> dsCountries = (ArrayList<Country>) gen.generate(start, size, file);
			dao.addCountry(dsCountries);
			start += size;
			soLuong -= size;
			dsCountries.clear();
		}
	}

	/**
	 * thực hiện sinh và đẩy dữ liệu vào database
	 * 
	 * @param soLuong
	 * @throws IOException
	 */
	public void loadEvent(int soLuong) throws IOException {
		gen = new GenerateEvents();
		gen.readAtribute();
		file = new File("data/key_event.txt");
		int start = 0;
		int size = 0;
		while (soLuong > 0) {
			size = Math.min(soLuong, MAXSIZE);
			ArrayList<Event> dsEvents = (ArrayList<Event>) gen.generate(start, size, file);
			dao.addEvent(dsEvents);
			start += size;
			soLuong -= size;
			dsEvents.clear();
		}
	}

	/**
	 * thực hiện sinh và đẩy dữ liệu vào database
	 * 
	 * @param soLuong
	 * @throws IOException
	 */
	public void loadLocation(int soLuong) throws IOException {
		gen = new GenerateLocations();
		gen.readAtribute();
		file = new File("data/key_location.txt");
		int start = 0;
		int size;
		while (soLuong > 0) {
			size = Math.min(soLuong, MAXSIZE);
			ArrayList<Location> dsLocations = (ArrayList<Location>) gen.generate(start, size, file);
			dao.addLocation(dsLocations);
			start += size;
			soLuong -= size;
			dsLocations.clear();
		}
	}

	/**
	 * thực hiện sinh và đẩy dữ liệu vào database
	 * 
	 * @param soLuong
	 * @throws IOException
	 */
	public void loadOrganization(int soLuong) throws IOException {
		gen = new GenerateOrganizations();
		gen.readAtribute();
		file = new File("data/key_organization.txt");
		int start = 0;
		int size = 0;
		while (soLuong > 0) {
			size = Math.min(soLuong, MAXSIZE);
			ArrayList<Organization> dsOrganizations = (ArrayList<Organization>) gen.generate(start, size, file);
			dao.addOrganization(dsOrganizations);
			start += size;
			soLuong -= size;
			dsOrganizations.clear();
		}

	}

	/**
	 * thực hiện sinh và đẩy dữ liệu vào database
	 * 
	 * @param soLuong
	 * @throws IOException
	 */
	public void loadPerson(int soLuong) throws IOException {
		gen = new GeneratePersons();
		gen.readAtribute();
		file = new File("data/key_person.txt");
		int start = 0;
		int size;
		while (soLuong > 0) {
			size = Math.min(soLuong, MAXSIZE);
			ArrayList<Person> dsPersons = (ArrayList<Person>) gen.generate(start, size, file);
			dao.addPerson(dsPersons);
			start += size;
			soLuong -= size;
			dsPersons.clear();
		}

	}

	/**
	 * thực hiện sinh và đẩy dữ liệu vào database
	 * 
	 * @param soLuong
	 * @throws IOException
	 */
	public void loadTime(int soLuong) throws IOException {
		gen = new GenerateTimes();
		gen.readAtribute();
		file = new File("data/key_time.txt");
		int start = 0;
		int size;
		while (soLuong > 0) {
			size = Math.min(soLuong, MAXSIZE);
			ArrayList<Time> dsTimes = (ArrayList<Time>) gen.generate(start, size, file);
			dao.addTime(dsTimes);
			start += size;
			soLuong -= size;
			dsTimes.clear();
		}
	}

	/**
	 * thực hiện sinh và đẩy dữ liệu vào database
	 * 
	 * @param soLuong
	 * @throws IOException
	 */
	public void loadAggrement(int soLuong) throws IOException {
		gen = new GenerateAggrement();
		gen.readAtribute();
		file = new File("data/key_aggrement.txt");
		int start = 0;
		int size;
		while (soLuong > 0) {
			size = Math.min(soLuong, MAXSIZE);
			ArrayList<Aggrement> dsAggrement = (ArrayList<Aggrement>) gen.generate(start, size, file);
			dao.addAggrement(dsAggrement);
			start += size;
			soLuong -= size;
			dsAggrement.clear();
		}
	}

}
