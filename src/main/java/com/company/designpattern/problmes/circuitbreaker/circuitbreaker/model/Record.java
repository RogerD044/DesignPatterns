package com.company.designpattern.problmes.circuitbreaker.circuitbreaker.model;

public class Record {
    private long captureTimeInMillis;
    private boolean isFailure;

    public Record(long captureTimeInMillis, boolean isFailure) {
        this.captureTimeInMillis = captureTimeInMillis;
        this.isFailure = isFailure;
    }

    public long getCaptureTimeInMillis() {
        return captureTimeInMillis;
    }

    public boolean isFailure() {
        return isFailure;
    }

    public void setCaptureTimeInMillis(long captureTimeInMillis) {
        this.captureTimeInMillis = captureTimeInMillis;
    }

    public void setFailure(boolean failure) {
        isFailure = failure;
    }
}
