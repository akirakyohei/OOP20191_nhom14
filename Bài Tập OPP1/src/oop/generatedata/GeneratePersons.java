package oop.generatedata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import oop.beans.Person;

public class GeneratePersons implements IGenerate {
	private ArrayList<String> nhanHienThis;
	private ArrayList<String> dinhDanhs;
	private ArrayList<String> moTas;
	private ArrayList<String> links;
	private ArrayList<String> chucVus;
	private ArrayList<String> quocTichs;

	// lấy các thuộc tính của đối tượng
	@Override
	public void readAtribute() {
		nhanHienThis = Data.readData("data/Person_nhan.txt");
		dinhDanhs = Data.readData("data/Person_dinhDanh.txt");
		moTas = Data.readData("data/Person_moTa.txt");
		links = Data.readData("data/Person_link.txt");
		chucVus = Data.readData("data/Person_chucVu.txt");
		quocTichs = Data.readData("data/Person_quocTich.txt");
	}

	/**
	 * sinh danh sach thuc the Person
	 * 
	 * @param start          : vị trí bắt đầu đánh định danh thực thể
	 * @param n              :so luong thuc the sinh ra
	 * @param fileWrite:file lưu trữ định danh đối tượng
	 * @return ArrayList<Person>
	 */

	@Override
	public ArrayList<Person> generate(int start, int n, File fileWrite) throws IOException {
		ArrayList<Person> dsPerson = new ArrayList<>();

		// mở ghi file
		FileWriter fw = new FileWriter(fileWrite, true);

		// tạo các đối tượng lưu trữ
		for (int i = start; i < n + start; i++) {
			Person coun = new Person();
			coun.setDinhDanh(Data.randomData(dinhDanhs) + "_" + i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNhanHienThi(Data.randomData(nhanHienThis));
			coun.setChucVu(Data.randomData(chucVus));
			coun.setQuocTich(Data.randomData(quocTichs));
			dsPerson.add(coun);
			// ghi dinhdanh vao file
			fw.write(coun.getDinhDanh() + "\n");
		}

		// đóng file
		fw.close();

		return dsPerson;
	}
}
