package com.boleto.tividadefix.service;

import com.boleto.tividadefix.model.Fatura;
import com.boleto.tividadefix.repository.FaturaRepositoy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {

    private final FaturaRepositoy faturaRepositoy;

    public FaturaService(FaturaRepositoy faturaRepositoy) {
        this.faturaRepositoy = faturaRepositoy;
    }

    public List<Fatura> listarTodos(){
        return faturaRepositoy.findAll();
    }

    public Optional<Fatura> buscarPorId(Long id) {
        return faturaRepositoy.findById(id);
    }

    public Fatura salvar(Fatura faturaNova) {
        return faturaRepositoy.save(faturaNova);
    }


}
