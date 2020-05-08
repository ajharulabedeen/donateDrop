package com.donatedrop.agent;

public class RequestGetAgentRequests {
    private int start;
    private int max;
    private String column;
    private String key;

    public RequestGetAgentRequests() {
    }

    public RequestGetAgentRequests(int start, int max, String column, String key) {
        this.start = start;
        this.max = max;
        this.column = column;
        this.key = key;
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

    @Override
    public String toString() {
        return "RequestGetAgentRequests{" +
                "start=" + start +
                ", max=" + max +
                ", column='" + column + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
