package oop.generatedata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import oop.beans.Location;

public class GenerateLocations implements IGenerate {
	private ArrayList<String> nhanHienThis;
	private ArrayList<String> dinhDanhs;
	private ArrayList<String> moTas;
	private ArrayList<String> links;

	@Override
	public void readAtribute() {
		nhanHienThis = Data.readData("data/Location_nhan.txt");
		dinhDanhs = Data.readData("data/Location_dinhDanh.txt");
		moTas = Data.readData("data/Location_moTa.txt");
		links = Data.readData("data/Location_link.txt");
	}

	/**
	 * sinh danh sach thuc the Location
	 * 
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Location>
	 */
	@Override
	public ArrayList<Location> generate(int start, int n, File fileWrite) throws IOException {
		ArrayList<Location> dsLocation = new ArrayList<>();

		// mở ghi file
		FileWriter fw = new FileWriter(fileWrite, true);
		for (int i = start; i < n + start; i++) {
			Location coun = new Location();
			coun.setDinhDanh(Data.randomData(dinhDanhs) + "_" + i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNhanHienThi(Data.randomData(nhanHienThis));
			dsLocation.add(coun);

			// ghi dinhdanh vao file
			fw.write(coun.getDinhDanh() + "\n");
		}

		// đóng file
		fw.close();

		return dsLocation;

	}

}
