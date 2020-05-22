package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.CI;

public interface NumCIRepository extends JpaRepository<CI, Long> {
	
	List<CI> findByResponsavel(String user);

}
