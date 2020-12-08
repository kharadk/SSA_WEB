package com.ssa.exception.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssa.bo.UserResponse;
import com.ssa.constant.AppConstant;
import com.ssa.exception.NoDataFoundException;
import com.ssa.exception.bo.Error;
import com.ssa.props.AppProperties;

@RestController
@RestControllerAdvice
public class RestExceptionController {
	@Autowired
	AppProperties propsMessages;

	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<Error> handleNoDataFoundException() {
		Error error = new Error(404, propsMessages.getMsg().get(AppConstant.NO_DATA_FOUND), new Date());
		
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}
}
