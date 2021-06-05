package com.tecnoheli.hvendas.models.property;

public enum SexoProperty {

    Masculino("M"),
    Feminino("M");

    private final String s;

    SexoProperty(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

}
