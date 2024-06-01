package com.example.wsappsiav.Entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "siav", name = "tb_aluguel_adicionais")
public class AluguelAdicionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "adicionais_id")
    @ManyToOne
    private Adicional adicionalId;

    @JoinColumn(name = "aluguel_id")

    @ManyToOne
    private Aluguel aluguelId;

    public Adicional getAdicionalId() {
        return adicionalId;
    }

    public void setAdicionalId(Adicional adicionalId) {
        this.adicionalId = adicionalId;
    }

    public Aluguel getAluguelId() {
        return aluguelId;
    }

    public void setAluguelId(Aluguel aluguelId) {
        this.aluguelId = aluguelId;
    }
}
