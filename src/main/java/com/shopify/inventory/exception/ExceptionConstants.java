package com.shopify.inventory.exception;

public enum ExceptionConstants {
	
	ITEM_NOT_FOUND("item.not.found"),
	ITEM_ID_REQUIRED("item.id.required"),
	INPUT_PARAM_MISSING("input.parameter.missing"),
	RESOURCE_NOT_FOUND_ERROR("resource.not.found"),
	GENERAL_ERROR("general.error");
	
	private final String type;

	private ExceptionConstants(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}

}
