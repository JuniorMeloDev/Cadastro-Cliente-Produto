package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ClienteModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.ClienteServico;

@RestController
@CrossOrigin(origins = "*")
public class ClienteControle {

    @Autowired
    private ClienteServico cs;

    @DeleteMapping("/cliente/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id) {
        return cs.remover(id);
    }

    @PutMapping("/cliente/alterar")
    public ResponseEntity<?> alterar(@RequestBody ClienteModelo cm) {
        return cs.cadastrarAlterar(cm, "alterar");
    }

    @PostMapping("/cliente/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteModelo cm) {
        return cs.cadastrarAlterar(cm, "cadastrar");
    }
    
    @GetMapping("/cliente/listar")
    public Iterable<ClienteModelo> listar() {
        return cs.listar();
    }

    @GetMapping("/")
    public String rota() {
        return "API de produtos Funcionando!";
    }
        
}
