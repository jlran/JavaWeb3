package com.github.jlran.util;

import java.util.List;

/**
 * 封装分页的参数
 * @author jlran
 *
 */
public class PageBean<T> {
	private int currentPage = 1; //当前页，默认为1
	private int pageCount = 4;	//每页显示的行数
	private int totalCount;	//总记录数
	private int totalPage;//总页数
	private List<T> pageDate; //分页查询到的数据
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	//返回总页数
	public int getTotalPage() {
		if(totalCount % pageCount == 0){
			totalPage = totalCount / pageCount;
		}else{
			totalPage = totalCount / pageCount + 1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageDate() {
		return pageDate;
	}
	public void setPageDate(List<T> pageDate) {
		this.pageDate = pageDate;
	}
}
