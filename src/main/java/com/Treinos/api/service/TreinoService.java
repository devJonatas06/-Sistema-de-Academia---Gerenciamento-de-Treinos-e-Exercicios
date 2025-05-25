package com.Treinos.api.service;

import com.Treinos.api.entity.Treino;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TreinoService {
    List<Treino> findAll();
    Treino findById(int id);
    void save(Treino treino);
    void deleteById(int id);
}

