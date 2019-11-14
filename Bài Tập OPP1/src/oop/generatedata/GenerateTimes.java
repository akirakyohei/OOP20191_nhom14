package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Time;

public class GenerateTimes extends Generate {

	/**
	 * sinh danh sach thuc the  Time
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Time>
	 */
	@Override
	public ArrayList<Time> generate(int n) {
ArrayList<Time> dsTime = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = readData("data/Time_nhan.txt");
		
		ArrayList<String> dinhDanhs = readData("data/Time_dinhDanh.txt");

		
		ArrayList<String> moTas = readData("data/Time_moTa.txt");

		
		ArrayList<String> links = readData("data/Time_link.txt");
		
		ArrayList<String> ngayTrichRuts = readData("data/NgayTrichRut.txt");

	
		
		for(int i=0;i<n;i++) {
			Time coun=new Time();
			coun.setDinhDanh(randomData(dinhDanhs));
			coun.setLink(randomData(links));
			coun.setMoTa(randomData(moTas));
			coun.setNgayTrichRut(randomData(ngayTrichRuts));
			coun.setNhanHienThi(randomData(nhanHienthis));
			dsTime.add(coun);
		}
		return dsTime;

		}

}
