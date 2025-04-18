package spring.boot.desafio.nubank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.boot.desafio.nubank.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT DISTINCT obj FROM Cliente obj LEFT JOIN FETCH obj.contatos")
	List<Cliente> searchClienteEContatos();
}
