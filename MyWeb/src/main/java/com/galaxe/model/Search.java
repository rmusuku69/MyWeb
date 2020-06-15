package com.galaxe.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Search {
	@NotEmpty
	private String searchParam;
	@NotEmpty
	private String searchCriteria;
	public String getSearchParam() {
		return searchParam;
	}
	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}
	public String getSearchCriteria() {
		return searchCriteria;
	}
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
}
