package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Aggrement;

public class GenerateAggrement implements IGenerate{

	@Override
	public ArrayList<Aggrement> generate(int n) {
ArrayList<Aggrement> dsAggrement = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = Data.readData("data/Aggrement_nhan.txt");
		
		ArrayList<String> dinhDanhs = Data.readData("data/Aggrement_dinhDanh.txt");

		
		ArrayList<String> moTas = Data.readData("data/Aggrement_moTa.txt");

		
		ArrayList<String> links = Data.readData("data/Aggrement_link.txt");
		
		ArrayList<String> ngayTrichRuts = Data.readData("data/NgayTrichRut.txt");

	
		
		for(int i=0;i<n;i++) {
			Aggrement aggrement=new Aggrement();
			aggrement.setDinhDanh(Data.randomData(dinhDanhs)+"_"+i);
			aggrement.setLink(Data.randomData(links));
			aggrement.setMoTa(Data.randomData(moTas));
			aggrement.setNgayTrichRut(Data.randomData(ngayTrichRuts));
			aggrement.setNhanHienThi(Data.randomData(nhanHienthis));
			dsAggrement.add(aggrement);
		}
		return dsAggrement;

		}

}
