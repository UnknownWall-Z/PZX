/**
 * 
 */
/**
 * @author wall
 *
 */
package com.memory.pzp.base.query;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class PageResult{
	
	private List<?> listData;
	private Integer totalCount;
	private Integer currentPage;
	private Integer prePage;
	private Integer nextPage;
	private Integer pageSize;
	private Integer totalPage;
	
	public PageResult(List<?> listData, Integer totalCount, Integer currentPage, Integer pageSize) {
		super();
		this.listData = listData;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		this.prePage = currentPage-1>0?currentPage-1:1;
		this.nextPage = currentPage+1<=this.totalPage?currentPage+1:this.totalPage;
	}

	public Integer getTotalPage(){
		return totalPage==0?1:totalPage;
	}
	
	public static PageResult empty(int pageSize){
		return new PageResult(new ArrayList<>(),0,1,pageSize);
	}
}