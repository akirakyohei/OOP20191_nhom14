package oop.beans;

public class Location extends Entity {
	private String country;

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Location [dinhDanh=" + this.getDinhDanh() + ", nhan=" + this.getNhanHienThi() + ", moTa="
				+ this.getMoTa() + ", link=" + this.getLink() + "datNuoc" + this.getCountry() + "]";

	}

}
