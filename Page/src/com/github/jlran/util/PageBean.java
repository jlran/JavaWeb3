package com.github.jlran.util;

import java.util.List;

/**
 * ��װ��ҳ�Ĳ���
 * @author jlran
 *
 */
public class PageBean<T> {
	private int currentPage = 1; //��ǰҳ��Ĭ��Ϊ1
	private int pageCount = 4;	//ÿҳ��ʾ������
	private int totalCount;	//�ܼ�¼��
	private int totalPage;//��ҳ��
	private List<T> pageDate; //��ҳ��ѯ��������
	
	
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
	//������ҳ��
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
