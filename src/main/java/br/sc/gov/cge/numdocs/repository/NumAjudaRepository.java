package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.Ajuda;

public interface NumAjudaRepository extends JpaRepository<Ajuda, Long> {
	
	List<Ajuda> findByResponsavel(String user);

}
