package br.com.api.produtos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.produtos.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Long> {

    
}