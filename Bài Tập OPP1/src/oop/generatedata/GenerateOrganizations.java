package oop.generatedata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import oop.beans.Organization;

public class GenerateOrganizations implements IGenerate {
	private ArrayList<String> nhanHienThis;
	private ArrayList<String> dinhDanhs;
	private ArrayList<String> moTas;
	private ArrayList<String> links;
	private ArrayList<String> truSos;

	/**
	 * lấy các thuộc tính đối tượng
	 */
	@Override
	public void readAtribute() {
		nhanHienThis = Data.readData("data/Organization_nhan.txt");
		dinhDanhs = Data.readData("data/Organization_dinhDanh.txt");
		moTas = Data.readData("data/Organization_moTa.txt");
		links = Data.readData("data/Organization_link.txt");
		truSos = Data.readData("data/Organization_truSo.txt");
	}

	/**
	 * sinh danh sach thuc the Organization
	 * 
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Organization>
	 */
	@Override
	public ArrayList<Organization> generate(int start, int n, File fileWrite) throws IOException {
		ArrayList<Organization> dsOrganization = new ArrayList<>();
		// mở ghi file
		FileWriter fw = new FileWriter(fileWrite, true);
		// tạo các đối tượng lưu trữ
		for (int i = start; i < n + start; i++) {
			Organization coun = new Organization();
			coun.setDinhDanh(Data.randomData(dinhDanhs) + "_" + i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNhanHienThi(Data.randomData(nhanHienThis));
			coun.setTruSo(Data.randomData(truSos));
			dsOrganization.add(coun);
			// ghi dinhdanh vao file
			fw.write(coun.getDinhDanh() + "\n");
		}
		// đóng file
		fw.close();

		return dsOrganization;
	}

}
