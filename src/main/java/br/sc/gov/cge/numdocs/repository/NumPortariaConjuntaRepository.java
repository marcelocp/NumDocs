package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.PortariaConjunta;

public interface NumPortariaConjuntaRepository extends JpaRepository<PortariaConjunta, Long> {
	
	List<PortariaConjunta> findByResponsavel(String user);

}
