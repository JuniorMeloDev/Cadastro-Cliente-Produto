package br.com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.api.produtos.modelo.ClienteModelo;

public interface ClienteRepositorio extends CrudRepository<ClienteModelo, Long> {

    
}