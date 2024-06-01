package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Aluguel;
import com.example.wsappsiav.Entity.AluguelSeguros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AluguelSegurosRepository extends JpaRepository<AluguelSeguros, Long> {

    @Query(value = "SELECT s FROM AluguelSeguros s WHERE s.aluguelId =:aluguel")
    List<AluguelSeguros> getAluguelSegurosRepositoriesByAluguelId(Aluguel aluguel);

}
