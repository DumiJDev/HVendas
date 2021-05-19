package com.tecnoheli.hvendas.modelos.property;

import java.util.List;

/**
 * Classe contendo os dados do cliente
 *
 * @author TecnoHeli
 */
public class ClienteProperty {

    private String id;
    private String nome;
    private String telefone;

    private List<VendaProperty> compras;

    public ClienteProperty(String id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
}
