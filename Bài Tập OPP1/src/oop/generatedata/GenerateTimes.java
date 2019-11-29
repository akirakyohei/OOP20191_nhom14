package oop.generatedata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import oop.beans.Time;

public class GenerateTimes implements IGenerate {
	private ArrayList<String> nhanHienThis;
	private ArrayList<String> dinhDanhs;
	private ArrayList<String> moTas;
	private ArrayList<String> links;

	/**
	 * lấy dữ liệu thuộc tính của đối tượng
	 *
	 */
	@Override
	public void readAtribute() {

		nhanHienThis = Data.readData("data/Time_nhan.txt");
		dinhDanhs = Data.readData("data/Time_dinhDanh.txt");
		moTas = Data.readData("data/Time_moTa.txt");
		links = Data.readData("data/Time_link.txt");

	}

	/**
	 * sinh danh sach thuc the Time
	 * 
	 * @param start          : vị trí bắt đầu đánh định danh thực thể
	 * @param n              :so luong thuc the sinh ra
	 * @param fileWrite:file lưu trữ định danh đối tượng
	 * @return ArrayList<Time>
	 */
	@Override
	public ArrayList<Time> generate(int start, int n, File fileWrite) throws IOException {
		ArrayList<Time> dsTime = new ArrayList<>();

		// mở ghi file
		FileWriter fw = new FileWriter(fileWrite, true);
		// tạo đối tượng để lưu trữ
		for (int i = start; i < n + start; i++) {
			Time coun = new Time();
			coun.setDinhDanh(Data.randomData(dinhDanhs) + "_" + i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNhanHienThi(Data.randomData(nhanHienThis));
			dsTime.add(coun);
			// ghi dinhdanh vao file
			fw.write(coun.getDinhDanh() + "\n");
		}
		// đóng file
		fw.close();

		return dsTime;
	}

}
