package br.com.senac.lucas.api_carros_jwt.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Carros extends EntidadeMaster {

    @Column
    private LocalDate anoFabricacao;

    private String cor;

    private boolean novo;

    private double quilometragemRodada;

    @ManyToOne(optional = false)
    @JoinColumn(name = "modelo_id")
    private Modelos modelo;

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public double getQuilometragemRodada() {
        return quilometragemRodada;
    }

    public void setQuilometragemRodada(double quilometragemRodada) {
        this.quilometragemRodada = quilometragemRodada;
    }

    public Modelos getModelo() {
        return modelo;
    }

    public void setModelo(Modelos modelo) {
        this.modelo = modelo;
    }
}
