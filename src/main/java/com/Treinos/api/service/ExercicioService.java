package com.Treinos.api.service;

import com.Treinos.api.entity.Exercicio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ExercicioService {
    List<Exercicio> findAll();
    Exercicio findById(int id);
    void save(Exercicio exercicio);
    void deleteById(int id);

    List<Exercicio> findByTreinoId(int treinoId);

}
