package io.github.pedrossjr.pedidos.processador.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.pedrossjr.pedidos.processador.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_pedidos")
public class Pedido {

    @Id
    private UUID id = UUID.randomUUID();
    private String cliente;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();
    private BigDecimal valorTotal;
    private String emailNotificacao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();

}