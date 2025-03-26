package com.boleto.tividadefix.controller;

import com.boleto.tividadefix.model.Fatura;
import com.boleto.tividadefix.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;
    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping("/pegarTodas")
    public List<Fatura> listFaturas() {
        return  faturaService.listarTodos();
    }

    @GetMapping("/pegarPorId{id}")
    public ResponseEntity<Fatura> buscarBoleto(@PathVariable Long id){
        Optional<Fatura> fatura = faturaService.buscarPorId(id);
        return fatura.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/salvarFatura")
    public ResponseEntity<Fatura> salvarFatura(@RequestBody Fatura fatura) {
        Fatura novaFatura = faturaService.salvar(fatura);
        return ResponseEntity.ok(novaFatura);
    }

}
