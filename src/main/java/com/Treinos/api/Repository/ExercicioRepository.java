package com.Treinos.api.Repository;

import com.Treinos.api.entity.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Integer> {
    List<Exercicio> findByTreinoId(int treinoId);
}

