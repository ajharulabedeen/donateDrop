package com.donatedrop.agent.admin.models;

public class RequestGetAgentRequestsReview {
    private int start;
    private int max;
    private String column;
    private String key;
    private String statusType;

    public RequestGetAgentRequestsReview() {
    }

    public RequestGetAgentRequestsReview(int start, int max, String column, String key, String statusType) {
        this.start = start;
        this.max = max;
        this.column = column;
        this.key = key;
        this.statusType = statusType;
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

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "RequestGetAgentRequestsReview{" +
                "start=" + start +
                ", max=" + max +
                ", column='" + column + '\'' +
                ", key='" + key + '\'' +
                ", statusType='" + statusType + '\'' +
                '}';
    }
}
