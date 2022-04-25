package org.restapi.crud.crud.model;

//model class
public class crudmodel {
	private int empid;
	private int nic;
	private String name;
	private String address;
	private String dept;
	private int contact;

	public crudmodel() {
		//constructor
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getNic() {
		return nic;
	}

	public void setNic(int nic) {
		this.nic = nic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	

}
