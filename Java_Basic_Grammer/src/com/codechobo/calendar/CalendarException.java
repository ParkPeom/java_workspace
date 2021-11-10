package com.codechobo.calendar;

public class CalendarException extends Exception {
	public CalendarException() {
		super("숫자를 입력해주세요");
	}
	public CalendarException(String msg) {
		super(msg);
	}
}
