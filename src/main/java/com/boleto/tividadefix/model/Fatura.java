package com.boleto.tividadefix.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "fatura")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFatura;
    @NotBlank(message = "A numero Cartão não pode estar em branco")
    @Pattern(regexp = "\\d{16}", message = "a numero deve ter 16 digitos")
    private String numeroCartao;
    @NotBlank(message = "nome do pagador não pode ser nulo")
    @Size(min = 3, max = 100, message = "O nome do pagador deve ter entre 3 e 100 caracteres")
    private String nomeTitular;
    @NotNull(message = "O valor não pode ser nulo")
    @DecimalMin(value = "10.0", message ="o valor deve ter no minimo 10 reais" )
    @DecimalMax(value = "5000.0", message = "o valor deve ser de no maximo 5000")
    private Double valor;
    @NotNull(message = "A data de vencimento não pode ser nula")
    @FutureOrPresent(message = "A data de vencimento não pode ser no passado")
    private LocalDate dataVencimento;
    @NotBlank(message = "email nãp pode ser vazio")
    @Email(message = "email invalido")
    private String emailContato;


}
