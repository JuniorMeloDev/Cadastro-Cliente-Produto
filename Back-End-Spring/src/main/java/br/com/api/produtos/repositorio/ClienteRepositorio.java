package br.com.api.produtos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.produtos.modelo.ClienteModelo;

public interface ClienteRepositorio extends JpaRepository<ClienteModelo, Long>{

}