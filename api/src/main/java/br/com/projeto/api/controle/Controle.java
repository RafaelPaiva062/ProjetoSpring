package br.com.projeto.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@RestController
public class Controle {
   @Autowired
   private Repositorio acao;
   @GetMapping("")
   public String mensagen(){
    return "Hello World!";
   }
   @GetMapping("/boasVindas")
   public String boasVindas(){
      return "Seja Bem-Vindo(a)";
   }
   @GetMapping("/boasVindas/{nome}")
   public String boasVindas(@PathVariable String nome){
      return "Seja Bem-Vindo(a)" + nome;
   }
   @PostMapping("/pessoa")
  public Pessoa pessoa(@RequestBody Pessoa p){
    return p;
  }
}
