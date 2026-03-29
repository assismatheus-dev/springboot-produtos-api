package br.com.assismatheus.spring_boot_essentials.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}
