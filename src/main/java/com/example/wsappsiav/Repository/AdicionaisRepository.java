package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdicionaisRepository extends JpaRepository<Adicional, Long> {
}

