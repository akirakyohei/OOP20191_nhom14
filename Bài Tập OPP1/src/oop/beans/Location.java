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
		 return 
			      "Location [dinhDanh=" + this.dinhDanh + ", nhan=" + this.nhanHienThi + ", moTa=" + this.moTa + ", link=" + this.link + ", ngayTrichRut=" + this.ngayTrichRut + "datNuoc"+this.country + "]";
			  
	}

}
