package com.capgemini.exception;

public class AssociateException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private String message;

	public AssociateException() 
	{

	}

	public AssociateException(String message)
	{
		super(message);
		this.message=message;
	}

	public AssociateException(String message,Exception e) 
	{
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() 
	{
		return "AssociateException [message=" + message + "]";
	}

	public String getMessage()
	{
		return message;
	}	
}
