package br.com.projeto.api.repositorio;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import br.com.projeto.api.modelo.Pessoa;
@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {

}
