package oop.generatedata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface IGenerate {
	public void readAtribute();

	public ArrayList<?> generate(int start, int n, File fileWrtie) throws IOException;
}
