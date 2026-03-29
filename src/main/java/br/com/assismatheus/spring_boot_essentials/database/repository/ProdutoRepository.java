package br.com.assismatheus.spring_boot_essentials.database.repository;

import br.com.assismatheus.spring_boot_essentials.database.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
