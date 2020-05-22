package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.Parecer;

public interface NumParecerRepository extends JpaRepository<Parecer, Long> {
	
	List<Parecer> findByResponsavel(String user);

}
