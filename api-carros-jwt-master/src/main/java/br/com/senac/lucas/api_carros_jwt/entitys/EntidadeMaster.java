package br.com.senac.lucas.api_carros_jwt.entitys;

import jakarta.persistence.*;

@MappedSuperclass
public class EntidadeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
