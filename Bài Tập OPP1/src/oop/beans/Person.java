package oop.beans;

public class Person extends Entity {
	private String chucVu;
	private String quocTich;

	/**
	 * @return the chucVu
	 */
	public String getChucVu() {
		return chucVu;
	}

	/**
	 * @return the quocTich
	 */
	public String getQuocTich() {
		return quocTich;
	}

	/**
	 * @param chucVu the chucVu to set
	 */
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	/**
	 * @param quocTich the quocTich to set
	 */
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	@Override
	public String toString() {
		return "Person [dinhDanh=" + this.getDinhDanh() + ", chucVu=" + this.getChucVu() + ", nhan="
				+ this.getNhanHienThi() + ", moTa=" + this.getMoTa() + ", link=" + this.getLink() + ", ngayTrichRut="
				+ "quocTich =" + this.quocTich + "]";
	}

}
