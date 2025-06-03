package br.com.senac.lucas.api_carros_jwt.services;

import br.com.senac.lucas.api_carros_jwt.entitys.Carros;
import br.com.senac.lucas.api_carros_jwt.repositorys.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrosService {

    @Autowired
    private CarrosRepository carrosRepository;

    public Carros criarCarros(Carros carros) {
        return carrosRepository.save(carros);
    }

    public Carros atualizarCarros(Long id, Carros carros) {
        return carrosRepository.save(carros);
    }

    public List<Carros> listarCarros() {
        List<Carros> carrosResult = carrosRepository.findAll();

        return carrosResult;
    }

    public void excluirCarros(Long id) {
        carrosRepository.deleteById(id);
    }
}
