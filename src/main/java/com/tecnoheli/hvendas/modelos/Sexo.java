package com.tecnoheli.hvendas.modelos;

public enum Sexo {

    Masculino("M"),
    Feminino("F");

    private final String s;

    Sexo(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

}
