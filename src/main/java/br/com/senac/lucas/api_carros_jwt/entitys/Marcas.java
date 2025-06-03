package br.com.senac.lucas.api_carros_jwt.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Marcas extends EntidadeMaster {

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<Modelos> modelos;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Modelos> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelos> modelos) {
        this.modelos = modelos;
    }
}
