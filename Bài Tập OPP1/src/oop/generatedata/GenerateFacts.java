package oop.generatedata;

import java.util.ArrayList;
import java.util.Random;

import oop.beans.Entity;
import oop.beans.Fact;

public class GenerateFacts {

	public static ArrayList<Fact> generate(String fact,ArrayList<? extends Entity> objects,ArrayList<? extends Entity> subjects,int soLuong) {
		ArrayList<Fact> facts=new ArrayList<>();
		for(int i=0;i<soLuong;i++) {
			Random ran=new Random();
			String object = objects.get(ran.nextInt(soLuong)).getDinhDanh();
			
			String subject =subjects.get(ran.nextInt(soLuong)).getDinhDanh();
			facts.add(new Fact(object, fact, subject));
		}
		return facts;
	}
}
