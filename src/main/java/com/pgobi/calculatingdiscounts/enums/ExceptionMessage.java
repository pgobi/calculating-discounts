package com.pgobi.calculatingdiscounts.enums;

public enum ExceptionMessage {
	SOMETHING_WENT_WRONG("Something went wrong"),
	TRANSACTION_NOT_ADD("Can not add the new traasaction"),
	TRANSACTION_NOT_FOUND("Transaction not found"),
	CUSTOMETR_NOT_FOUND("Custometr not found"),
	CART_NOT_FOUND("Cart not found"),
	ORDER_NOT_FOUND("Order not found"),
	;
	private final String value;

	ExceptionMessage(String value){
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
