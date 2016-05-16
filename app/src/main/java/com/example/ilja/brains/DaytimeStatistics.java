package com.example.ilja.brains;

import java.util.Date;

/**
 * Created by Ilja on 16.05.2016.
 */
public class DaytimeStatistics implements IEntity {
    private long id;
    private String date;
    private long operationTypeId;
    private int counter;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


}
