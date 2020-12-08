package com.ssa.service;

import com.ssa.bo.UserRequest;
import com.ssa.bo.UserResponse;
import com.ssa.exception.NoDataFoundException;

public interface UserService {
      
	
	public Long ssnEnrollment(UserRequest user) ;
	
	public UserResponse getUserDataBySSN(Long ssnNo) throws NoDataFoundException;
}
