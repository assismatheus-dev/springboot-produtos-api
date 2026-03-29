package br.com.assismatheus.spring_boot_essentials.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "O preço deve ser maior do que 0")
    private BigDecimal preco;

    @NotNull(message = "Quantidade é obrigatória")
    @Positive(message = "Quantidade deve ser positiva")
    private Integer quantidade;
}

