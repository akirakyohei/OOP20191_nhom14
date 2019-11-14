package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Country;

public class GenerateCountries extends Generate {
	/**
	 * sinh danh sach thuc the  Country
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Country>
	 */
	@Override
	public  ArrayList<Country> generate(int n) {
ArrayList<Country> dsCountry = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = readData("data/Country_nhan.txt");
		
		ArrayList<String> dinhDanhs = readData("data/Country_dinhDanh.txt");

		
		ArrayList<String> moTas = readData("data/Country_moTa.txt");

		
		ArrayList<String> links = readData("data/Country_link.txt");
		
		ArrayList<String> ngayTrichRuts = readData("data/NgayTrichRut.txt");

		
		ArrayList<String> dienTichs = readData("data/Country_dienTich.txt");
		
		
		for(int i=0;i<n;i++) {
			Country coun=new Country();
			coun.setDienTich(randomData(dienTichs));
			coun.setDinhDanh(randomData(dinhDanhs));
			coun.setLink(randomData(links));
			coun.setMoTa(randomData(moTas));
			coun.setNgayTrichRut(randomData(ngayTrichRuts));
			coun.setNhanHienThi(randomData(nhanHienthis));
			dsCountry.add(coun);
		}
		return dsCountry;

	}

}
