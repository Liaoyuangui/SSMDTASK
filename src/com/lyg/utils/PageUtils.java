package com.lyg.utils;

import java.io.Serializable;

public class PageUtils implements Serializable{
	
	 private static final long serialVersionUID = -3198048449643774660L; 
     
	    private int pageNow = 1; // 当前页数 
	   
	    private int pageSize = 10; // 每页显示记录的条数 
	   
	    private int totalCount; // 总的记录条数 
	   
	    private int totalPageCount; // 总的页数 
	   
	    @SuppressWarnings("unused") 
	    private int startPos; // 开始位置，从0开始 
	    
	    private Object dataList; //数据集合
	 
	       
	    public PageUtils(){};
	    
	    /**
	     * 通过构造函数 传入  总记录数  和  当前页
	     * @param totalCount
	     * @param pageNow
	     */ 
	    public PageUtils(int totalCount, int pageNow) { 
	        this.totalCount = totalCount; 
	        this.pageNow = pageNow; 
	    } 
	       
	    /**
	     * 取得总页数，总页数=总记录数/每页显示记录的条数  
	     * @return
	     */ 
	    public int getTotalPageCount() { 
	        totalPageCount = getTotalCount() / getPageSize(); 
	        return (totalCount % pageSize == 0) ? totalPageCount  //总页数
	                : totalPageCount + 1; 
	    } 
	   
	    public void setTotalPageCount(int totalPageCount) { 
	        this.totalPageCount = totalPageCount; 
	    } 
	   
	    public int getPageNow() { 
	        return pageNow; 
	    } 
	   
	    public void setPageNow(int pageNow) { 
	        this.pageNow = pageNow; 
	    } 
	   
	    public int getPageSize() { 
	        return pageSize; 
	    } 
	   
	    public void setPageSize(int pageSize) { 
	        this.pageSize = pageSize; 
	    } 
	   
	    public int getTotalCount() { 
	        return totalCount; 
	    } 
	   
	    public void setTotalCount(int totalCount) { 
	        this.totalCount = totalCount; 
	    } 
	    /**
	     * 取得选择记录的初始位置
	     * @return
	     */ 
	    public int getStartPos() { 
	        return (pageNow - 1) * pageSize; 
	    } 
	   
	    public void setStartPos(int startPos) { 
	        this.startPos = startPos; 
	    }

		public Object getDataList() {
			return dataList;
		}

		public void setDataList(Object dataList) {
			this.dataList = dataList;
		}


}