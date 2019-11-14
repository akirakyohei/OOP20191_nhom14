package oop.beans;

public class Event extends Entity{

	public Event() {
		super();
	}
	@Override
	public String toString()
	{
	  return 
	  
	    "Entity [dinhDanh=" + this.dinhDanh + ", nhan=" + this.nhanHienThi + ", moTa=" + this.moTa + ", link=" + this.link + ", ngayTrichRut=" + this.ngayTrichRut + "]";
	}

}
