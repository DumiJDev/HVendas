package com.tecnoheli.hvendas.models.dao;

import com.tecnoheli.hvendas.models.Item;

import java.util.List;

public class ItemDAO implements HVIDAO<Item> {
    @Override
    public void excluir(Item item) {
        excluir(item.getCodigo(), Item.class);
    }

    @Override
    public List<Item> listarTodos() {
        return listarTodos(Item.class);
    }

    @Override
    public Item recuperar(Object id) {
        return recuperar(id, Item.class);
    }

    @Override
    public boolean existe(Object id) {
        return existe(id, Item.class);
    }
}
