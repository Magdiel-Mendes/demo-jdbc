package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int Id;
	private String name;
	
	public Department(){}
	
	public Department(int id, String name) {
		Id = id;
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
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
		return Id == other.Id;
	}
	
	@Override
	public String toString() {
		return "id " + Id + ", " + name;
	}
}
