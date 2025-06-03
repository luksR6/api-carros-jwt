package br.com.senac.lucas.api_carros_jwt.repositorys;

import br.com.senac.lucas.api_carros_jwt.entitys.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrosRepository extends JpaRepository<Carros, Long> {
}
