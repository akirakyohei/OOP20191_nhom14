package oop.beans;

public abstract class Entity {

	protected String dinhDanh;
	protected String nhanHienThi;
	protected String moTa;
	protected String link;

	/**
	 * @return the dinhDanh
	 */
	public String getDinhDanh() {
		return dinhDanh;
	}

	/**
	 * @return the moTa
	 */
	public String getMoTa() {
		return moTa;
	}

	/**
	 * @param dinhDanh the dinhDanh to set
	 */
	public void setDinhDanh(String dinhDanh) {
		this.dinhDanh = dinhDanh;
	}

	/**
	 * @param moTa the moTa to set
	 */
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	/**
	 * @return the nhanHienThi
	 */
	public String getNhanHienThi() {
		return nhanHienThi;
	}

	/**
	 * @param nhanHienThi the nhanHienThi to set
	 */
	public void setNhanHienThi(String nhanHienThi) {
		this.nhanHienThi = nhanHienThi;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return

		"Entity [dinhDanh=" + this.dinhDanh + ", nhan=" + this.nhanHienThi + ", moTa=" + this.moTa + ", link="
				+ this.link + "]";
	}

}
