package br.com.senac.lucas.api_carros_jwt.services;

import br.com.senac.lucas.api_carros_jwt.entitys.Marcas;
import br.com.senac.lucas.api_carros_jwt.exceptions.CarroException;
import br.com.senac.lucas.api_carros_jwt.repositorys.CarrosRepository;
import br.com.senac.lucas.api_carros_jwt.repositorys.MarcasRepository;
import br.com.senac.lucas.api_carros_jwt.utils.ValidacoesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcasService {

    @Autowired
    private MarcasRepository marcasRepository;

    public Marcas criarMarca(Marcas marcas) {

        return marcasRepository.save(marcas);
    }

    public Marcas atualizarMarca(Long id, Marcas marcas) {
        ValidacoesUtils.validarSeRegistroExiste(marcasRepository, id);

        marcas.setId(id);

        return marcasRepository.save(marcas);
    }

    public List<Marcas> carregarMarcas() {
        List<Marcas> marcasResult = marcasRepository.findAll();

        if (marcasResult.isEmpty()){
            throw new CarroException("Nenhuma marca encontrada");
        }

        return marcasResult;
    }

    public void excluirMarca(Long id) {
        ValidacoesUtils.validarSeRegistroExiste(marcasRepository, id);

        marcasRepository.deleteById(id);
    }
}
