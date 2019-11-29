package oop.generatedata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import oop.beans.Country;

public class GenerateCountries implements IGenerate {
	private ArrayList<String> nhanHienThis;
	private ArrayList<String> dinhDanhs;
	private ArrayList<String> moTas;
	private ArrayList<String> links;
	private ArrayList<String> dienTichs;

	@Override
	public void readAtribute() {
		nhanHienThis = Data.readData("data/Country_nhan.txt");
		dinhDanhs = Data.readData("data/Country_dinhDanh.txt");
		moTas = Data.readData("data/Country_moTa.txt");
		links = Data.readData("data/Country_link.txt");
		dienTichs = Data.readData("data/Country_dienTich.txt");
	}

	/**
	 * sinh danh sach thuc the Country
	 * 
	 * @param n :so luong thuc the sinh ra
	 * @return ArrayList<Country>
	 * @throws IOException
	 */
	@Override
	public ArrayList<Country> generate(int start, int n, File fileWrite) throws IOException {
		ArrayList<Country> dsCountry = new ArrayList<>();

		// mở ghi file
		FileWriter fw = new FileWriter(fileWrite, true);

		// sinh dữ liệu
		for (int i = start; i < n + start; i++) {

			Country coun = new Country();
			coun.setDienTich(Data.randomData(dienTichs));
			coun.setDinhDanh(Data.randomData(dinhDanhs) + "_" + i);
			coun.setLink(Data.randomData(links));
			coun.setMoTa(Data.randomData(moTas));
			coun.setNhanHienThi(Data.randomData(nhanHienThis));
			dsCountry.add(coun);

			// ghi dinhdanh vao file
			fw.write(coun.getDinhDanh() + "\n");
		}

		// đóng file
		fw.close();

		return dsCountry;

	}

	public static void main(String[] args) {
		GenerateCountries count = new GenerateCountries();
		File file = new File("data/key_country.txt");

		try {
			file.delete();
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			count.generate(0, 2000, file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		ArrayList<String> arr = Data.readData("data/key_country.txt");
		for (String s : arr) {
			System.out.println(s);
		}

	}
}
