package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Aluguel;
import com.example.wsappsiav.Entity.AluguelAdicionais;
import com.example.wsappsiav.Entity.AluguelSeguros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AluguelAdicionaisRepository extends JpaRepository<AluguelAdicionais, Long> {
    @Query(value = "SELECT a FROM AluguelAdicionais a WHERE a.aluguelId =:aluguel")
    List<AluguelAdicionais> getAluguelSegurosRepositoriesByAluguelId(Aluguel aluguel);
}
