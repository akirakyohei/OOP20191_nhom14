package oop.generatedata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface IGenerate {
	/**
	 *thêm mảng các thuộc tính của đối tượng
	 */
	public void readAtribute();
/**
 * sinh đối tượng 
 * @param start vị trí bắt đầu 
 * @param n số lượng 
 * @param fileWrtie file ghi định danh thuộc tính 
 * @return mảng các đối tượng 
 * @throws IOException
 */
	public ArrayList<?> generate(int start, int n, File fileWrtie) throws IOException;
}
