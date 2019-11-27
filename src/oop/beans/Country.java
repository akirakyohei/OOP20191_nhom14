package oop.beans;

public class Country extends Entity {
	private String dienTich;

	/**
	 * @return the dienTich
	 */
	public String getDienTich() {
		return dienTich;
	}

	/**
	 * @param dienTich the dienTich to set
	 */
	public void setDienTich(String dienTich) {
		this.dienTich = dienTich;
	}
	 @Override
	  public String toString()
	  {
	    return 
	      "Organization [dinhDanh=" + this.dinhDanh + ", nhan=" + this.nhanHienThi + ", moTa=" + this.moTa + ", link=" + this.link + ", dienTich =" + this.dienTich + "]";
	  }
}
