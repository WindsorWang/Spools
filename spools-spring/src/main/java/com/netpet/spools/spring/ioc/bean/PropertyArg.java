package com.netpet.spools.spring.ioc.bean;

public class PropertyArg {

    private String name;

    private String value;

    private String typeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "PropertyArg{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
