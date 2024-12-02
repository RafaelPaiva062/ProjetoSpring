package br.com.projeto.api.modelo;

import org.springframework.stereotype.Component;

@Component
public class Mensagem {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensegem) {
        this.mensagem = mensegem;
    }

    
}
