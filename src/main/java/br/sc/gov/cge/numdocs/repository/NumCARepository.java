package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.CA;

public interface NumCARepository extends JpaRepository<CA, Long> {
	
	List<CA> findByResponsavel(String user);

}
