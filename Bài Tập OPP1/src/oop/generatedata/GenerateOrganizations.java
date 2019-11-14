package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Organization;

public class GenerateOrganizations extends Generate {
	/**
	 * sinh danh sach thuc the  Organization
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Organization>
	 */
	@Override
	public ArrayList<Organization> generate(int n) {
ArrayList<Organization> dsOrganization = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = readData("data/Organization_nhan.txt");
		
		ArrayList<String> dinhDanhs = readData("data/Organization_dinhDanh.txt");

		
		ArrayList<String> moTas = readData("data/Organization_moTa.txt");

		
		ArrayList<String> links = readData("data/Organization_link.txt");
		
		ArrayList<String> ngayTrichRuts = readData("data/NgayTrichRut.txt");

		
		ArrayList<String> truSos = readData("data/Organization_truSo.txt");
		
		
		for(int i=0;i<n;i++) {
			Organization coun=new Organization();
			coun.setDinhDanh(randomData(dinhDanhs));
			coun.setLink(randomData(links));
			coun.setMoTa(randomData(moTas));
			coun.setNgayTrichRut(randomData(ngayTrichRuts));
			coun.setNhanHienThi(randomData(nhanHienthis));
			coun.setTruSo(randomData(truSos));
			dsOrganization.add(coun);
		}
		return dsOrganization;

	}

}
