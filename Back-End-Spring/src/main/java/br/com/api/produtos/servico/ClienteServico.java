package br.com.api.produtos.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.DTO.ClienteDTO;
import br.com.api.produtos.modelo.ClienteModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio cr;

    @Autowired
    private RespostaModelo rm;

    //Metodo para listar todos os clientes
    public List<ClienteDTO> listar() {
        List<ClienteModelo> cliente = cr.findAll();
        return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }
    
    //Metodo para listar um cliente especifico
    public ClienteDTO listarUm(long id){
        ClienteModelo cliente = cr.findById(id).get();
        ClienteDTO dto = new ClienteDTO(cliente);
        return dto;
    }

    //Metodo para cadastrar clientes
    public ResponseEntity<?> cadastrarAlterar(ClienteModelo cm, String acao) {

        if(cm.getNome().equals("")) {
            rm.setMensagem("Nome obrigatório!!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else if(cm.getEmail().equals("")) {
            rm.setMensagem("Email obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else if(cm.getPassword().equals("")) {
            rm.setMensagem("Digite uma senha!!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }
        else {
           if(acao.equals("cadastrar")) {
            return new ResponseEntity<ClienteModelo>(cr.save(cm), HttpStatus.CREATED);
           }
           else {
            return new ResponseEntity<ClienteModelo>(cr.save(cm), HttpStatus.OK);
           }
        }
    }

    //Metodo para remover clientes
    public ResponseEntity<RespostaModelo> remover(long id) {

        cr.deleteById(id);

        rm.setMensagem("O cliente foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }

}