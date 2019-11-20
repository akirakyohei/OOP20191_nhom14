package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Location;

public class GenerateLocations implements IGenerate{
	/**
	 * sinh danh sach thuc the  Location
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Location>
	 */
	@Override
	public ArrayList<Location> generate(int n) {
	ArrayList<Location> dsLocation = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = Data.readData("data/Location_nhan.txt");
		
		ArrayList<String> dinhDanhs = Data.readData("data/Location_dinhDanh.txt");

		
		ArrayList<String> moTas = Data.readData("data/Location_moTa.txt");

		
		ArrayList<String> links = Data.readData("data/Location_link.txt");
		
		ArrayList<String> ngayTrichRuts = Data.readData("data/NgayTrichRut.txt");

		
		
		
		
		for(int i=0;i<n;i++) {
			Location coun=new Location();
			coun.setDinhDanh(Data.randomData(dinhDanhs)+"_"+i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNgayTrichRut(Data.randomData(ngayTrichRuts));
			coun.setNhanHienThi(Data.randomData(nhanHienthis));
			dsLocation.add(coun);
		}
		return dsLocation;

	}

}
