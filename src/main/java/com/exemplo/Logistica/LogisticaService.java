package com.exemplo.Logistica;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticaService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public Evento registrarEntrada(String placa, String motorista) {
        Caminhao caminhao = caminhaoRepository.findByPlaca(placa);
        if (caminhao == null) {
            caminhao = new Caminhao();
            caminhao.setPlaca(placa);
            caminhao.setMotorista(motorista);
            caminhaoRepository.save(caminhao);
        }

        Evento evento = new Evento();
        evento.setTipo("ENTRADA");
        evento.setDataHora(LocalDateTime.now());
        evento.setCaminhao(caminhao);
        return eventoRepository.save(evento);
    }

    public Evento registrarSaida(String placa) {
        Caminhao caminhao = caminhaoRepository.findByPlaca(placa);
        if (caminhao == null) {
            throw new IllegalArgumentException("Caminhão não encontrado");
        }

        Evento evento = new Evento();
        evento.setTipo("SAIDA");
        evento.setDataHora(LocalDateTime.now());
        evento.setCaminhao(caminhao);
        return eventoRepository.save(evento);
    }
}
