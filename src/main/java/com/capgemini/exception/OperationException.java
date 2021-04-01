package com.capgemini.exception;

public class OperationException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private String message;

	public OperationException() 
	{

	}

	public OperationException(String message)
	{
		super(message);
		this.message=message;
	}

	public OperationException(String message,Exception e) 
	{
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() 
	{
		return "OperationException [message= " + message + "]";
	}

	public String getMessage()
	{
		return message;
	}	
}
