package oop.beans;

public class Organization extends Entity {
	private String truSo;

	/**
	 * @return the truSo
	 */
	public String getTruSo() {
		return truSo;
	}

	/**
	 * @param truSo the truSo to set
	 */
	public void setTruSo(String truSo) {
		this.truSo = truSo;
	}

	@Override
	public String toString() {
		return "Organization [dinhDanh=" + this.getDinhDanh() + ", nhan=" + this.getNhanHienThi() + ", moTa="
				+ this.getMoTa() + ", link=" + this.getLink() + ", truSo =" + this.getTruSo() + "]";
	}

}
