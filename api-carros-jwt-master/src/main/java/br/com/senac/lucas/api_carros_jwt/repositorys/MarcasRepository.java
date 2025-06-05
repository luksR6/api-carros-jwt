package br.com.senac.lucas.api_carros_jwt.repositorys;

import br.com.senac.lucas.api_carros_jwt.entitys.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Long> {
}
