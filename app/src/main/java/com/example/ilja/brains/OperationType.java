package com.example.ilja.brains;

/**
 * Created by Ilja on 16.05.2016.
 */
public class OperationType implements IEntity {
    private long id;
    private String name;
    private int counter;

    public OperationType(){

    }

    public OperationType(String name){
        setName(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
