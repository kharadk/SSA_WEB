package com.ssa.bo;


import java.util.Date;

import lombok.Data;

@Data
public class UserRequest {
	protected String firstName;
	protected String lastName;
	protected String gender;
	protected String dob;
	protected String stateName;
	//protected byte[] photo;

}
