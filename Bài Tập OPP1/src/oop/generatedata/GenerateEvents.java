package oop.generatedata;

import java.util.ArrayList;

import oop.beans.Event;

public class GenerateEvents extends Generate {
	/**
	 * sinh danh sach thuc the  Event
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Event>
	 */
	@Override
	public ArrayList<Event> generate(int n) {
ArrayList<Event> dsEvent = new ArrayList<>();
		
		ArrayList<String> nhanHienthis = readData("data/Event_nhan.txt");
		
		ArrayList<String> dinhDanhs = readData("data/Event_dinhDanh.txt");

		
		ArrayList<String> moTas = readData("data/Event_moTa.txt");

		
		ArrayList<String> links = readData("data/Event_link.txt");
		
		ArrayList<String> ngayTrichRuts = readData("data/NgayTrichRut.txt");

	
		
		for(int i=0;i<n;i++) {
			Event coun=new Event();
			coun.setDinhDanh(randomData(dinhDanhs));
			coun.setLink(randomData(links));
			coun.setMoTa(randomData(moTas));
			coun.setNgayTrichRut(randomData(ngayTrichRuts));
			coun.setNhanHienThi(randomData(nhanHienthis));
			dsEvent.add(coun);
		}
		return dsEvent;

	}
	

}
