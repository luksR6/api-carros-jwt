package br.com.senac.lucas.api_carros_jwt.services;

import br.com.senac.lucas.api_carros_jwt.entitys.Modelos;
import br.com.senac.lucas.api_carros_jwt.repositorys.ModelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelosService {

    @Autowired
    private ModelosRepository modelosRepository;

    public Modelos criarModelos(Modelos modelos) {
        return modelosRepository.save(modelos);
    }

    public Modelos atualizarModelos(Long id, Modelos modelos) {
        return modelosRepository.save(modelos);
    }

    public List<Modelos> carregarModelos(){
        List<Modelos> modelosResult = modelosRepository.findAll();

        return modelosResult;
    }

    public void excluirModelos(Long id){
        modelosRepository.deleteById(id);
    }
}
