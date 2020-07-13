package com.donatedrop.post;

public class PostSearch {
    String dateType;
    String startDate;
    String endDate;
    int start;
    int max;
    String key;
    String column;
    String userID;
    String orderBy;
    String orderType;

    public PostSearch() {
    }

    public PostSearch(String dateType, String startDate, String endDate, int start, int max, String key, String column, String userID, String orderBy, String orderType) {
        this.dateType = dateType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.start = start;
        this.max = max;
        this.key = key;
        this.column = column;
        this.userID = userID;
        this.orderBy = orderBy;
        this.orderType = orderType;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "PostSearch{" +
                "dateType='" + dateType + ", startDate='" +
                '\'' + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", start=" + start +
                ", max=" + max +
                ", key='" + key + '\'' +
                ", column='" + column + '\'' +
                ", userID='" + userID + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
