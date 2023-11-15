package br.com.fiap.service;

import br.com.fiap.entity.Carro;
import br.com.fiap.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public void save(Carro carro) {
        carroRepository.save(carro);
    }

    public Optional<Carro> findById(Long id) {
        return carroRepository.findById(id);
    }

    public void deleteById(Long id) {
        carroRepository.deleteById(id);
    }

}
