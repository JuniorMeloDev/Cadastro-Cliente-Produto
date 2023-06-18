package br.com.api.produtos.DTO;

import br.com.api.produtos.modelo.ClienteModelo;
import lombok.Getter;
import lombok.Setter;

//implementando classe de retorno(dto) do cliente.
@Getter
@Setter
public class ClienteDTO {

    private String nome;
    private String email;

    public ClienteDTO(ClienteModelo cliente){
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();

    }
    
}
