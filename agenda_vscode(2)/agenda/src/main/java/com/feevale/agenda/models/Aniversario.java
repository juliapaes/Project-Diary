package com.feevale.agenda.models;

import java.io.Serializable;

public class Aniversario implements Serializable {

    private static final long serialVersionUID = 1L;

    private int dia;
    private int mes;
    private int ano;

    public Aniversario() {
    }

    public Aniversario(int auxDia, int auxMes, int auxAno) {
        this.dia = auxDia;
        this.mes = auxMes;
        this.ano = auxAno;
    }

    public void setDia(int auxDia) {
        this.dia = auxDia;
    }

    public void setMes(int auxMes) {
        this.mes = auxMes;
    }

    public void setAno(int auxAno) {
        this.ano = auxAno;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    // retornar a data de aniversário formatada
    public String getAniversarioFormatado() {
        String dataAniversario;
        dataAniversario = this.dia + "/" + this.mes + "/" + this.ano;
        return dataAniversario;
    }

}