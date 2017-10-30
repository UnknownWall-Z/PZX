package com.memory.pzp.base.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class QueryObject {

	/***
	 * 是否分页 1为是 0为否
	 */
	private int isPaging = 1;

	private Integer currentPage=1;
	private Integer pageSize=10;

	public int getStart(){
		return (currentPage-1)*pageSize;
	}
	
}