package com.boleto.tividadefix.repository;
import com.boleto.tividadefix.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepositoy extends JpaRepository<Fatura,Long> {
}
