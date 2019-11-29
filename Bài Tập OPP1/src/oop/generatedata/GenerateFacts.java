package oop.generatedata;

import java.util.ArrayList;
import java.util.Random;

import oop.beans.Fact;

public class GenerateFacts {

	public static ArrayList<Fact> generate(String fact, ArrayList<String> objects, ArrayList<String> subjects,
			ArrayList<String> ngayTrichRuts, int start, int soLuong) {
		ArrayList<Fact> facts = new ArrayList<>();
		for (int i = start; i < soLuong + start; i++) {
			Random ran = new Random();
			String object = objects.get(ran.nextInt(objects.size()));
			String subject = subjects.get(ran.nextInt(subjects.size()));
			String ngayTrichRut = ngayTrichRuts.get(ran.nextInt(ngayTrichRuts.size()));
			facts.add(new Fact(object, fact, subject, ngayTrichRut));
		}
		return facts;
	}
}
