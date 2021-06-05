package com.tecnoheli.hvendas.models.builder;

import com.tecnoheli.hvendas.models.BI;
import com.tecnoheli.hvendas.models.Sexo;

import java.time.LocalDate;

public class BIBuilder {

    private String numero;
    private String nome;
    private String nomeDoPai;
    private String nomeDaMae;
    private String residencia;
    private LocalDate dataDeNascimento;
    private Sexo sexo;

    private BIBuilder() {
    }

    public static BIBuilder novoBI() {
        return new BIBuilder();
    }

    public BIBuilder comNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public BIBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public BIBuilder comNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
        return this;
    }

    public BIBuilder comNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
        return this;
    }

    public BIBuilder comResidencia(String residencia) {
        this.residencia = residencia;
        return this;
    }

    public BIBuilder comDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public BIBuilder comSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public BI build() {
        final var bi = new BI();

        bi.setSexo(this.sexo);
        bi.setNome(this.nome);
        bi.setDataDeNascimento(this.dataDeNascimento);
        bi.setResidencia(this.residencia);
        bi.setNomeDoPai(this.nomeDoPai);
        bi.setNomeDaMae(this.nomeDaMae);
        bi.setNumero(this.numero);

        return bi;
    }
}
