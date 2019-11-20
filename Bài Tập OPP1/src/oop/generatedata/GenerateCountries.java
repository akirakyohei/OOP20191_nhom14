package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Country;

public class GenerateCountries implements IGenerate {
	/**
	 * sinh danh sach thuc the  Country
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Country>
	 */
	@Override
	public  ArrayList<Country> generate(int n) {
ArrayList<Country> dsCountry = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = Data.readData("data/Country_nhan.txt");
		
		ArrayList<String> dinhDanhs = Data.readData("data/Country_dinhDanh.txt");

		
		ArrayList<String> moTas = Data.readData("data/Country_moTa.txt");

		
		ArrayList<String> links = Data.readData("data/Country_link.txt");
		
		ArrayList<String> ngayTrichRuts = Data.readData("data/NgayTrichRut.txt");

		
		ArrayList<String> dienTichs = Data.readData("data/Country_dienTich.txt");
		
		
		for(int i=0;i<n;i++) {
			Country coun=new Country();
			coun.setDienTich(Data.randomData(dienTichs));
			coun.setDinhDanh(Data.randomData(dinhDanhs)+"_"+i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNgayTrichRut(Data.randomData(ngayTrichRuts));
			coun.setNhanHienThi(Data.randomData(nhanHienthis));
			dsCountry.add(coun);
		}
		return dsCountry;

	}

}
