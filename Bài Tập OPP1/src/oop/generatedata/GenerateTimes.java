package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Time;

public class GenerateTimes implements IGenerate {

	/**
	 * sinh danh sach thuc the  Time
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Time>
	 */
	@Override
	public ArrayList<Time> generate(int n) {
ArrayList<Time> dsTime = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = Data.readData("data/Time_nhan.txt");
		
		ArrayList<String> dinhDanhs = Data.readData("data/Time_dinhDanh.txt");

		
		ArrayList<String> moTas = Data.readData("data/Time_moTa.txt");

		
		ArrayList<String> links = Data.readData("data/Time_link.txt");
		
		ArrayList<String> ngayTrichRuts = Data.readData("data/NgayTrichRut.txt");

	
		
		for(int i=0;i<n;i++) {
			Time coun=new Time();
			coun.setDinhDanh(Data.randomData(dinhDanhs)+"_"+i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNgayTrichRut(Data.randomData(ngayTrichRuts));
			coun.setNhanHienThi(Data.randomData(nhanHienthis));
			dsTime.add(coun);
		}
		return dsTime;

		}

}
