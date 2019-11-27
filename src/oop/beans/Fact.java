package oop.beans;

public class Fact  {
	private String subject;
	private String quanHe;
	private String object;
	
	
	
	
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	public Fact(String object, String quanHe, String subject) {
		super();
		this.subject = subject;
		this.quanHe = quanHe;
		this.object = object;
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

	
    
}
