package com.exemplo.Logistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logistica")
public class LogisticaController {

    @Autowired
    private LogisticaService logisticaService;

    @PostMapping("/entrada")
    public Evento registrarEntrada(@RequestParam String placa, @RequestParam String motorista) {
        return logisticaService.registrarEntrada(placa, motorista);
    }

    @PostMapping("/saida")
    public Evento registrarSaida(@RequestParam String placa) {
        return logisticaService.registrarSaida(placa);
    }
}
