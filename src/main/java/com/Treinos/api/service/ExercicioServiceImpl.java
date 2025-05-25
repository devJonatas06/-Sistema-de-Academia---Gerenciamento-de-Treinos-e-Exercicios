package com.Treinos.api.service;

import com.Treinos.api.entity.Exercicio;
import com.Treinos.api.Repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioServiceImpl implements ExercicioService {
    @Override
    public List<Exercicio> findByTreinoId(int treinoId) {
        return exercicioRepository.findByTreinoId(treinoId);
    }

    private final ExercicioRepository exercicioRepository;

    public ExercicioServiceImpl(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    @Override
    public List<Exercicio> findAll() {
        return exercicioRepository.findAll();
    }

    @Override
    public Exercicio findById(int id) {
        Optional<Exercicio> result = exercicioRepository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Exercício não encontrado - Id: " + id));
    }

    @Override
    public void save(Exercicio exercicio) {
        exercicioRepository.save(exercicio);
    }

    @Override
    public void deleteById(int id) {
        exercicioRepository.deleteById(id);
    }
}

