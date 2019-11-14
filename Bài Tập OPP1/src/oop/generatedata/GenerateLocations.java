package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Location;

public class GenerateLocations extends Generate{
	/**
	 * sinh danh sach thuc the  Location
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Location>
	 */
	@Override
	public ArrayList<Location> generate(int n) {
	ArrayList<Location> dsLocation = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = readData("data/Location_nhan.txt");
		
		ArrayList<String> dinhDanhs = readData("data/Location_dinhDanh.txt");

		
		ArrayList<String> moTas = readData("data/Location_moTa.txt");

		
		ArrayList<String> links = readData("data/Location_link.txt");
		
		ArrayList<String> ngayTrichRuts = readData("data/NgayTrichRut.txt");

		
		
		
		
		for(int i=0;i<n;i++) {
			Location coun=new Location();
			coun.setDinhDanh(randomData(dinhDanhs));
			coun.setLink(randomData(links));
			coun.setMoTa(randomData(moTas));
			coun.setNgayTrichRut(randomData(ngayTrichRuts));
			coun.setNhanHienThi(randomData(nhanHienthis));
			dsLocation.add(coun);
		}
		return dsLocation;

	}

}
