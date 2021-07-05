package com.vo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/6/23 16:39
 */
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 总记录数 */
    private long total;
    /** 列表数据 */
    private List<?> data;
    /** 消息状态码 */
    private int code;

    private int pageNum;// 当前页
    private int firstPage;// 第一页
    private int lastPage;// 最后一页
    private int pageSize;// 每页条数 每页的数量
    private String msg;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }
    /**
     * 分页
     *
     * @param list
     * 列表数据
     * @param total
     * 总记录数
     */
    public TableDataInfo(List<?> list, int total) {
        this.data = list;
        this.total = total;
    }

    public static TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setData(list);
        rspData.setMsg("success");
        rspData.setTotal(new PageInfo(list).getTotal());
        rspData.setPageNum(new PageInfo(list).getPageNum());
        rspData.setPageSize(new PageInfo(list).getPageSize());
//        rspData.setFirstPage(1);
//        rspData.setLastPage(new PageInfo(list).getLastPage());
        return rspData;
    }

    /**
     * 设置请求分页数据
     */
    public static void startPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
