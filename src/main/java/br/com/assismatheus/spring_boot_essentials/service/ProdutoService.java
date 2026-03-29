package br.com.assismatheus.spring_boot_essentials.service;

import br.com.assismatheus.spring_boot_essentials.database.repository.ProdutoRepository;
import br.com.assismatheus.spring_boot_essentials.database.entity.Produto;
import br.com.assismatheus.spring_boot_essentials.dto.request.ProdutoRequestDTO;
import br.com.assismatheus.spring_boot_essentials.dto.response.ProdutoResponseDTO;
import br.com.assismatheus.spring_boot_essentials.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        Produto produtoSalvo = repository.save(produto);

        return toResponseDTO(produtoSalvo);
    }

    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado com o id: " + id));

        return toResponseDTO(produto);
    }

    public ProdutoResponseDTO atualizarTotal(Long id, ProdutoRequestDTO dto) {

        Produto existente = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado com o id: " + id));

        existente.setPreco(dto.getPreco());
        existente.setNome(dto.getNome());
        existente.setQuantidade(dto.getQuantidade());

        Produto produtoAtualizado = repository.save(existente);
        return toResponseDTO(produtoAtualizado);
    }

    public ProdutoResponseDTO atualizarParcial(Long id, ProdutoRequestDTO dto) {
        Produto existente = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado com o id: " + id));

        if(dto.getNome() != null) {
            existente.setNome(dto.getNome());
        }

        if(dto.getPreco() != null) {
            existente.setPreco(dto.getPreco());
        }

        if(dto.getQuantidade() != null) {
            existente.setQuantidade(dto.getQuantidade());
        }

        Produto produtoAtualizado = repository.save(existente);
        return toResponseDTO(produtoAtualizado);
    }

    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com o id: " + id);
        }

        repository.deleteById(id);
    }

    private ProdutoResponseDTO toResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade()
        );
    }
}
