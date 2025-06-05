package br.com.senac.lucas.api_carros_jwt.services;

import br.com.senac.lucas.api_carros_jwt.entitys.Modelos;
import br.com.senac.lucas.api_carros_jwt.exceptions.CarroException;
import br.com.senac.lucas.api_carros_jwt.exceptions.SenacException;
import br.com.senac.lucas.api_carros_jwt.repositorys.MarcasRepository;
import br.com.senac.lucas.api_carros_jwt.repositorys.ModelosRepository;
import br.com.senac.lucas.api_carros_jwt.utils.ValidacoesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelosService {

    @Autowired
    private ModelosRepository modelosRepository;

    @Autowired
    private MarcasRepository marcasRepository;

    public Modelos criarModelos(Modelos modelo) {
        if (modelo.getMarcas().getId() == null) {
            throw new SenacException("Deve ser informado um marca");
        }

        return modelosRepository.save(modelo);
    }

    public Modelos atualizarModelos(Long id, Modelos modelo) {
        ValidacoesUtils.validarSeRegistroExiste(modelosRepository, id);

        modelo.setId(id);

        return modelosRepository.save(modelo);
    }

    public List<Modelos> carregarModelos(){
        List<Modelos> modelosResult = modelosRepository.findAll();

        if (modelosResult.isEmpty()) {
            throw new CarroException("Nenhum modelo encontrado");
        }
        return modelosResult;
    }

    public void excluirModelos(Long id){
        ValidacoesUtils.validarSeRegistroExiste(modelosRepository, id);
        modelosRepository.deleteById(id);
    }
}
