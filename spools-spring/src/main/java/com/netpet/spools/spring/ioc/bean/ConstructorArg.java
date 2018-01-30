package com.netpet.spools.spring.ioc.bean;

public class ConstructorArg {

    private int index;

    private String ref;

    private String name;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ConstructorArg{" +
                "index=" + index +
                ", ref='" + ref + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
