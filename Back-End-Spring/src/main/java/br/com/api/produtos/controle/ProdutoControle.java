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

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.ProdutoServico;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;

    @DeleteMapping("/produto/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo) {
        return ps.remover(codigo);
    }

    @PutMapping("/produto/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm) {
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @PostMapping("/produto/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm) {
        return ps.cadastrarAlterar(pm, "cadastrar");
    }
    
    @GetMapping("/produto/listar")
    public Iterable<ProdutoModelo> listar() {
        return ps.listar();
    }

    @GetMapping("/produto/listar/{codigo}")
    public ProdutoModelo listarUnico(@PathVariable Long codigo){
        return ps.listarUm(codigo);
    }
}
