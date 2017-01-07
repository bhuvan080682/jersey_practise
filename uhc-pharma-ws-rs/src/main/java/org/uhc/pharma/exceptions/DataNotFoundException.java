package org.uhc.pharma.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

import javassist.SerialVersionUID;

public class DataNotFoundException extends RuntimeException {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7497367734003805032L;

	public DataNotFoundException(String message){
		super(message);
	}
	

}
