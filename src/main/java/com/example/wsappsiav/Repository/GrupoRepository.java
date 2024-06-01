package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo,Long> {

    List<Grupo> getGruposByType(String type);

}
