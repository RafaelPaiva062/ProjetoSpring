package br.com.projeto.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.modelo.Mensagem;
import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@Service
public class Servico {
    

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    // Métudo para cadastra pessoas 
    public ResponseEntity<?> cadastrar(Pessoa obj){
        
        if(obj.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getIdade() < 0){
           return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
           
            return new ResponseEntity<>( acao.save(obj),HttpStatus.CREATED);

        }
            
    }

    // Método de selecionar pessoas 
    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
        
    }

    // Métudo para selecionar pesssoas através do código

    public ResponseEntity<?> selecionarPeloCodigo(int codigo){
    if(acao.countByCodigo(codigo)==0){
        mensagem.setMensagem("Não foi entrada nenhuma pessoa.");
        return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }else{
        return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
    }
    }


    // Método para editiar dados 
    public ResponseEntity<?>editar(Pessoa obj){
        if (acao.countByCodigo(obj.getCodigo())== 0) {
            mensagem.setMensagem("O código  informado não existe.");
            return new ResponseEntity<>(mensagem,HttpStatus.NOT_FOUND);
        }else if(obj.getNome().equals("")){
            mensagem.setMensagem("É necessário  informar um nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(obj.getIdade() < 0){
            mensagem.setMensagem("Informe sua idade valída");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }

    }
}
