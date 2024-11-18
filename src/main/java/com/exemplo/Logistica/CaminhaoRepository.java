package com.exemplo.Logistica;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
    Caminhao findByPlaca(String placa);
}
