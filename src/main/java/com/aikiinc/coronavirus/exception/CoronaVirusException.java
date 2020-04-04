package com.aikiinc.coronavirus.exception;

public class CoronaVirusException extends Exception {
	private static final long serialVersionUID = 6287801226203998237L;

	public CoronaVirusException(String message) {
		super(message);
	}

	public CoronaVirusException(Throwable cause) {
		super(cause);
	}

	public CoronaVirusException() {
	}

}
