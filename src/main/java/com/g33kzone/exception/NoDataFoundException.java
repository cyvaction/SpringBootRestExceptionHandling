package com.g33kzone.exception;

public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = -3011663589079396063L;
	private final int fetchId;

	public NoDataFoundException() {
		fetchId = 0;
	}

	public NoDataFoundException(int fetchId) {
		super();
		this.fetchId = fetchId;
	}

	public int getFetchId() {
		return fetchId;
	}

}
