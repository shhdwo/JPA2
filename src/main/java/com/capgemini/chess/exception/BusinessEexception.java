package com.capgemini.chess.exception;

public abstract class BusinessEexception extends Exception {

	private static final long serialVersionUID = -2883942832292315127L;

	public BusinessEexception(String message) {
		super(message);
	}
}
