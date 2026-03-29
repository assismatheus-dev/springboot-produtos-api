package br.com.assismatheus.spring_boot_essentials.controller;

import br.com.assismatheus.spring_boot_essentials.dto.request.ProdutoRequestDTO;
import br.com.assismatheus.spring_boot_essentials.dto.response.ProdutoResponseDTO;
import br.com.assismatheus.spring_boot_essentials.service.ProdutoService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ProdutoResponseDTO salvar(@RequestBody @Valid ProdutoRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<ProdutoResponseDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProdutoResponseDTO atualizarTotal(@PathVariable Long id,
                                             @RequestBody @Valid ProdutoRequestDTO dto) {
        return service.atualizarTotal(id, dto);
    }

    @PatchMapping("/{id}")
    public ProdutoResponseDTO atualizarParcial(@PathVariable Long id,
                                               @RequestBody ProdutoRequestDTO dto) {
        return service.atualizarParcial(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }
}
