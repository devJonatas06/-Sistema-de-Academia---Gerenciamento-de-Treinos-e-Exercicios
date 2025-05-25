package com.Treinos.api.Repository;

import com.Treinos.api.entity.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TreinoRepository extends JpaRepository<Treino, Integer> {
}
