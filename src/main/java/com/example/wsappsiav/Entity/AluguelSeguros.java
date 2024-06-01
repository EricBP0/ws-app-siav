package com.example.wsappsiav.Entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "siav", name = "tb_aluguel_seguros")
public class AluguelSeguros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "seguro_id")
    @ManyToOne
    private Seguro seguroId;

    @JoinColumn(name = "aluguel_id")
    @ManyToOne
    private Aluguel aluguelId;

    public Seguro getSeguroId() {
        return seguroId;
    }

    public void setSeguroId(Seguro seguroId) {
        this.seguroId = seguroId;
    }

    public Aluguel getAluguelId() {
        return aluguelId;
    }

    public void setAluguelId(Aluguel aluguelId) {
        this.aluguelId = aluguelId;
    }
}
