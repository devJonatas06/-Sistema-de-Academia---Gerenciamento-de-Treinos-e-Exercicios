package com.Treinos.api.service;

import com.Treinos.api.Repository.TreinoRepository;
import com.Treinos.api.entity.Treino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TreinoServiceImpl implements TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoServiceImpl(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    @Override
    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }

    @Override
    public Treino findById(int id) {
        Optional<Treino> result = treinoRepository.findById(id);

        Treino treino = null;

        if (result.isPresent()) {
            treino = result.get();
        } else {
            throw new RuntimeException("Não foi encontrado treino com id - " + id);
        }

        return treino;
    }

    @Override
    public void save(Treino treino) {
        treinoRepository.save(treino);
    }

    @Override
    public void deleteById(int id) {
        treinoRepository.deleteById(id);
    }
}