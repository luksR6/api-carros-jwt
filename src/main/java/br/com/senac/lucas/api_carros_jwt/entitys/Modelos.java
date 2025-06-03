package br.com.senac.lucas.api_carros_jwt.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Modelos extends EntidadeMaster {

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marcas marcas;

    @OneToMany(mappedBy = "modelo")
    private List<Carros> carros;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public List<Carros> getCarros() {
        return carros;
    }

    public void setCarros(List<Carros> carros) {
        this.carros = carros;
    }
}
