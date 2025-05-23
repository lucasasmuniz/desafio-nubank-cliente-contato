package spring.boot.desafio.nubank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.boot.desafio.nubank.entities.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	List<Contato> findByClienteId(Long id);
}
