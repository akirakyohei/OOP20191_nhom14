package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Person;

public class GeneratePersons implements IGenerate {
	/**
	 * sinh danh sach thuc the Person
	 * @param n : so thuc the sinh ra
	 * @return ArrayList<Person>
	 */
	@Override
	public ArrayList<Person> generate(int n) {
        ArrayList<Person> dsPerson = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = Data.readData("data/Person_nhan.txt");
		
		ArrayList<String> dinhDanhs = Data.readData("data/Person_dinhDanh.txt");

		
		ArrayList<String> moTas = Data.readData("data/Person_moTa.txt");

		
		ArrayList<String> links = Data.readData("data/Person_link.txt");
		
		ArrayList<String> ngayTrichRuts = Data.readData("data/NgayTrichRut.txt");

		
		ArrayList<String> chucVus = Data.readData("data/Person_chucVu.txt");
		
		
		ArrayList<String> quocTichs = Data.readData("data/Person_quocTich.txt");
		
		for(int i=0;i<n;i++) {
			Person coun=new Person();
			coun.setDinhDanh(Data.randomData(dinhDanhs)+"_"+i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNgayTrichRut(Data.randomData(ngayTrichRuts));
			coun.setNhanHienThi(Data.randomData(nhanHienthis));
			coun.setChucVu(Data.randomData(chucVus));
			coun.setQuocTich(Data.randomData(quocTichs));
			dsPerson.add(coun);
		}
		return dsPerson;

	}
}
