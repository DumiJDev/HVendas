package com.tecnoheli.hvendas.modelos.property;

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
