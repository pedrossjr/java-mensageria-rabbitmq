package io.github.pedrossjr.pedidos.processador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_produtos")
public class Produto {

    @Id
    private UUID id = UUID.randomUUID();
    private String nome;
    private BigDecimal valor;

}
