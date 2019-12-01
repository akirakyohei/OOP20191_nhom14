package oop.generatedata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import oop.beans.Aggrement;

public class GenerateAggrement implements IGenerate {
	private ArrayList<String> nhanHienThis;
	private ArrayList<String> dinhDanhs;
	private ArrayList<String> moTas;
	private ArrayList<String> links;

	@Override
	public void readAtribute() {
		// đọc dữ liệu trong file
		nhanHienThis = Data.readData("data/Aggrement_nhan.txt");
		dinhDanhs = Data.readData("data/Aggrement_dinhDanh.txt");
		moTas = Data.readData("data/Aggrement_moTa.txt");
		links = Data.readData("data/Aggrement_link.txt");
	}

	@Override
	public ArrayList<Aggrement> generate(int start, int n, File fileWrtie) throws IOException {
		ArrayList<Aggrement> dsAggrement = new ArrayList<>();

		// mở ghi file
		FileWriter fw = new FileWriter(fileWrtie, true);
		for (int i = start; i < n + start; i++) {
			Aggrement aggrement = new Aggrement();
			aggrement.setDinhDanh(Data.randomData(dinhDanhs) + "_" + i);
			aggrement.setLink(Data.randomData(links));
			aggrement.setMoTa(Data.randomData(moTas));
			aggrement.setNhanHienThi(Data.randomData(nhanHienThis));
			dsAggrement.add(aggrement);

			// ghi dinh danh vao file
			fw.write(aggrement.getDinhDanh() + "\n");
		}

		// đóng file
		fw.close();

		return dsAggrement;

	}

}
