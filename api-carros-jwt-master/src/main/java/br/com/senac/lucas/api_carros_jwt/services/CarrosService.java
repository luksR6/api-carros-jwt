package br.com.senac.lucas.api_carros_jwt.services;

import br.com.senac.lucas.api_carros_jwt.entitys.Carros;
import br.com.senac.lucas.api_carros_jwt.exceptions.CarroException;
import br.com.senac.lucas.api_carros_jwt.exceptions.SenacException;
import br.com.senac.lucas.api_carros_jwt.repositorys.CarrosRepository;
import br.com.senac.lucas.api_carros_jwt.repositorys.MarcasRepository;
import br.com.senac.lucas.api_carros_jwt.repositorys.ModelosRepository;
import br.com.senac.lucas.api_carros_jwt.utils.ValidacoesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarrosService {

    @Autowired
    private CarrosRepository carrosRepository;

    @Autowired
    private MarcasRepository marcasRepository;

    @Autowired
    private ModelosRepository modelosRepository;

    public Carros criarCarros(Carros carro) throws SenacException {

        if (!carro.isNovo() && (carro.getQuilometragemRodada() <= 0)){
            throw new CarroException("Se o carro é usado deve ser informado a quilometragem rodada");
        }

        if (carro.getModelo().getId() == null){
            throw new SenacException("O carro deve ser informado um Modelo");
        }

        return carrosRepository.save(carro);
    }

    public Carros atualizarCarros(Long id, Carros carro) {

        ValidacoesUtils.validarSeRegistroExiste(carrosRepository, id);

        if (!carro.isNovo() && (carro.getQuilometragemRodada() <= 0)){
            throw new CarroException("Se o carro é usado deve ser informado a quilometragem rodada");
        }

        carro.setId(id);

        return carrosRepository.save(carro);
    }

    public List<Carros> listarCarros() {
        List<Carros> carrosResult = carrosRepository.findAll();

        if (carrosResult.isEmpty()){
            throw new CarroException("Nenhum carro encontrado");
        }

        return carrosResult;
    }

    public void excluirCarros(Long id) {
        ValidacoesUtils.validarSeRegistroExiste(carrosRepository, id);

        carrosRepository.deleteById(id);
    }
}
