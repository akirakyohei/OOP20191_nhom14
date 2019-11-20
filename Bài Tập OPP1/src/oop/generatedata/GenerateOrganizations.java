package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Organization;

public class GenerateOrganizations implements IGenerate {
	/**
	 * sinh danh sach thuc the  Organization
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Organization>
	 */
	@Override
	public ArrayList<Organization> generate(int n) {
ArrayList<Organization> dsOrganization = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = Data.readData("data/Organization_nhan.txt");
		
		ArrayList<String> dinhDanhs = Data.readData("data/Organization_dinhDanh.txt");

		
		ArrayList<String> moTas = Data.readData("data/Organization_moTa.txt");

		
		ArrayList<String> links = Data.readData("data/Organization_link.txt");
		
		ArrayList<String> ngayTrichRuts = Data.readData("data/NgayTrichRut.txt");

		
		ArrayList<String> truSos = Data.readData("data/Organization_truSo.txt");
		
		
		for(int i=0;i<n;i++) {
			Organization coun=new Organization();
			coun.setDinhDanh(Data.randomData(dinhDanhs)+"_"+i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNgayTrichRut(Data.randomData(ngayTrichRuts));
			coun.setNhanHienThi(Data.randomData(nhanHienthis));
			coun.setTruSo(Data.randomData(truSos));
			dsOrganization.add(coun);
		}
		return dsOrganization;

	}

}
