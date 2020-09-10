package web_study_10.dto;

public class Department {
	private int deptNo;
	private String deptName;
	private int deptFloor;

	public Department() {}

	public Department(int deptNo) {
		super();
		this.deptNo = deptNo;
	}
	
	public Department(int deptNo, String deptName) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public Department(int deptNo, String deptName, int deptFloor) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.deptFloor = deptFloor;
	}

	@Override
	public String toString() {
		return String.format("Department [deptNo=%s, deptName=%s, deptFloor=%s]", deptNo, deptName, deptFloor);
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptFloor() {
		return deptFloor;
	}

	public void setDeptFloor(int deptFloor) {
		this.deptFloor = deptFloor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptNo != other.deptNo)
			return false;
		return true;
	}

}
