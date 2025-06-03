package br.com.senac.lucas.api_carros_jwt.repositorys;

import br.com.senac.lucas.api_carros_jwt.entitys.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByEmail(String email);
}
