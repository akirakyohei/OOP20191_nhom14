package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Person;

public class GeneratePersons extends Generate {
	/**
	 * sinh danh sach thuc the Person
	 * @param n : so thuc the sinh ra
	 * @return ArrayList<Person>
	 */
	@Override
	public ArrayList<Person> generate(int n) {
        ArrayList<Person> dsPerson = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = readData("data/Person_nhan.txt");
		
		ArrayList<String> dinhDanhs = readData("data/Person_dinhDanh.txt");

		
		ArrayList<String> moTas = readData("data/Person_moTa.txt");

		
		ArrayList<String> links = readData("data/Person_link.txt");
		
		ArrayList<String> ngayTrichRuts = readData("data/NgayTrichRut.txt");

		
		ArrayList<String> chucVus = readData("data/Person_chucVu.txt");
		
		
		ArrayList<String> quocTichs = readData("data/Person_quocTich.txt");
		
		for(int i=0;i<n;i++) {
			Person coun=new Person();
			coun.setDinhDanh(randomData(dinhDanhs));
			coun.setLink(randomData(links));
			coun.setMoTa(randomData(moTas));
			coun.setNgayTrichRut(randomData(ngayTrichRuts));
			coun.setNhanHienThi(randomData(nhanHienthis));
			coun.setChucVu(randomData(chucVus));
			coun.setQuocTich(randomData(quocTichs));
			dsPerson.add(coun);
		}
		return dsPerson;

	}
}
