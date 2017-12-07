package com.ma.util;

import java.util.ArrayList;

public class Page<T> {
	private long pageSize = 15;
	//当前页
	private long currentPage;
	//总页数
	private long pageTotal;

	private long startNum;

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	//待封装的数据对象
	private ArrayList<?> item;
	public ArrayList<?> getItem() {
		return item;
	}
	public void setItem(ArrayList<T> item) {
		this.item = item;
	}
	//调用时需传入总数据条数 和当前页
	public Page(long count,int currentPage){
		this.currentPage = currentPage;
		this.pageTotal = count / this.pageSize;
		if((count % this.pageSize) != 0){
			this.pageTotal++;
		}
		this.startNum = (currentPage-1)*pageSize+1;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
}
