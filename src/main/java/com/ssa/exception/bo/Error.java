package com.ssa.exception.bo;

import java.util.Date;

import lombok.Data;

@Data
public class Error {

	protected int errorCode;
	protected String description;
	protected Date date;

	public Error(int errorCode, String description, Date date) {
		this.errorCode = errorCode;
		this.description = description;
		this.date = date;
	}

}
