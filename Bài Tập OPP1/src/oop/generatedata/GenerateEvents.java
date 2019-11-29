package oop.generatedata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import oop.beans.Event;

public class GenerateEvents implements IGenerate {
	private ArrayList<String> nhanHienThis;
	private ArrayList<String> dinhDanhs;
	private ArrayList<String> moTas;
	private ArrayList<String> links;

	@Override
	public void readAtribute() {
		nhanHienThis = Data.readData("data/Event_nhan.txt");
		dinhDanhs = Data.readData("data/Event_dinhDanh.txt");
		moTas = Data.readData("data/Event_moTa.txt");
		links = Data.readData("data/Event_link.txt");

	}

	/**
	 * sinh danh sach thuc the Event
	 * 
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Event>
	 */
	@Override
	public ArrayList<Event> generate(int start, int n, File fileWrite) throws IOException {
		ArrayList<Event> dsEvent = new ArrayList<>();

		// mở ghi file
		FileWriter fw = new FileWriter(fileWrite, true);

		for (int i = start; i < n + start; i++) {
			Event coun = new Event();
			coun.setDinhDanh(Data.randomData(dinhDanhs) + "_" + i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNhanHienThi(Data.randomData(nhanHienThis));
			dsEvent.add(coun);

			// ghi dinhdanh vao file
			fw.write(coun.getDinhDanh() + "\n");
		}

		// đóng file
		fw.close();

		return dsEvent;

	}

}
