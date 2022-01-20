package com.shopify.inventory.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.shopify.inventory.exception.ExceptionConstants;
import com.shopify.inventory.exception.InventoryException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;

	/*
	 * General Exception handler to catch generalize exception and throw it 
	 * with custom message from properties file
	 * */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception ex) {

		logger.error(ex.getMessage(), ex);

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setErrorMsg(environment.getProperty(ExceptionConstants.GENERAL_ERROR.toString()));

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}

	/*
	 * User defined Exception handler to catch exception of type InventoryException 
	 * and throw it with custom message from properties file
	 * */
	@ExceptionHandler(InventoryException.class)
	public ResponseEntity<ErrorInfo> InventoryExceptionHandler(InventoryException ex) {

		logger.error(ex.getMessage(), ex);

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());

		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	/*
	 * Handlers to catch System defined exception with user defined message
	 * */
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorInfo> NoSuchRequestHandler(NoHandlerFoundException ex) {

		logger.error(ex.getMessage(), ex);

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorInfo.setErrorMsg(environment.getProperty(ExceptionConstants.RESOURCE_NOT_FOUND_ERROR.toString()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ErrorInfo> requestParameterExceptionHandler(MissingServletRequestParameterException ex) {

		logger.error(ex.getMessage(), ex);

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(
				ex.getMessage() + " " + environment.getProperty(ExceptionConstants.INPUT_PARAM_MISSING.toString()));

		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
}
