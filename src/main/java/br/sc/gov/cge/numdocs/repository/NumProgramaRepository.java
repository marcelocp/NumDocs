package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.Programa;

public interface NumProgramaRepository extends JpaRepository<Programa, Long> {
	
	List<Programa> findByResponsavel(String user);

}
