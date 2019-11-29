package oop.beans;

public class Fact {
	private String subject;
	private String quanHe;
	private String object;
	private String ngayTrichRut;

	public Fact(String subject, String quanHe, String object, String ngayTrichRut) {
		super();
		this.subject = subject;
		this.quanHe = quanHe;
		this.object = object;
		this.ngayTrichRut = ngayTrichRut;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return the quanHe
	 */
	public String getQuanHe() {
		return quanHe;
	}

	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @param quanHe the quanHe to set
	 */
	public void setQuanHe(String quanHe) {
		this.quanHe = quanHe;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return this.object + " " + this.quanHe + " " + this.subject;
	}

	/**
	 * @return the ngayTrichRut
	 */
	public String getNgayTrichRut() {
		return ngayTrichRut;
	}

	/**
	 * @param ngayTrichRut the ngayTrichRut to set
	 */
	public void setNgayTrichRut(String ngayTrichRut) {
		this.ngayTrichRut = ngayTrichRut;
	}

}
