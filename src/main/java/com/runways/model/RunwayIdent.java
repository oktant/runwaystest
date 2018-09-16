package com.runways.model;

/**
 * DAO Report for 10 most common runway identifications
 * @author oalizada
 */
public class RunwayIdent {

    private String ident;
    private int count;



    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "RunwayIdent{" +
                "ident='" + ident + '\'' +
                ", count=" + count +
                '}';
    }
}
