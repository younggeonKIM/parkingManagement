package com.co.parking.entity;

import java.io.Serializable;

public class ParkId implements Serializable {

	private int parkFloor;
	private String parkNum;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + parkFloor;
		result = prime * result + ((parkNum == null) ? 0 : parkNum.hashCode());
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
		ParkId other = (ParkId) obj;
		if (parkFloor != other.parkFloor)
			return false;
		if (parkNum == null) {
			if (other.parkNum != null)
				return false;
		} else if (!parkNum.equals(other.parkNum))
			return false;
		return true;
	}
	
	public ParkId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
