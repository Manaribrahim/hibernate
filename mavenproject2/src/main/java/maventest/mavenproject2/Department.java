package maventest.mavenproject2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
	private int id;
	private int depNumber;
	private String depName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepNumber() {
		return depNumber;
	}
	public void setDepNumber(int depNumber) {
		this.depNumber = depNumber;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	

}