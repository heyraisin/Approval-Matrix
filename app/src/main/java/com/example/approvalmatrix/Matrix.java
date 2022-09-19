package com.example.approvalmatrix;

public class Matrix {
    int id;
    String name;
    String feature;
    long minApproval;
    long maxApproval;
    long numOfApproval;

    public Matrix() {
        super();
    }

    public Matrix(int id, String name, String feature, long minApproval, long maxApproval, long numOfApproval) {
        super();
        this.id = id;
        this.name = name;
        this.feature = feature;
        this.minApproval = minApproval;
        this.maxApproval = maxApproval;
        this.numOfApproval = numOfApproval;
    }

    public Matrix(String name, String feature, long minApproval, long maxApproval, long numOfApproval) {
        this.name = name;
        this.feature = feature;
        this.minApproval = minApproval;
        this.maxApproval = maxApproval;
        this.numOfApproval = numOfApproval;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public long getMinApproval() {
        return minApproval;
    }

    public void setMinApproval(long minApproval) {
        this.minApproval = minApproval;
    }

    public long getMaxApproval() {
        return maxApproval;
    }

    public void setMaxApproval(long maxApproval) {
        this.maxApproval = maxApproval;
    }

    public long getNumOfApproval() {
        return numOfApproval;
    }

    public void setNumOfApproval(long numOfApproval) {
        this.numOfApproval = numOfApproval;
    }
}
