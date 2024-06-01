package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Grupo;
import com.example.wsappsiav.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    @Query(value = "SELECT v FROM Veiculo v JOIN Grupo g on g.type =:type WHERE g.id = v.grupoId.id")
    List<Veiculo> getVeiculosByGrupoId(String type);
}

