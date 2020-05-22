package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.RCA;

public interface NumRCARepository extends JpaRepository<RCA, Long> {
	
	List<RCA> findByResponsavel(String user);

}
