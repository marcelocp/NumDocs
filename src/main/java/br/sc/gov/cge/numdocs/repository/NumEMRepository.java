package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.EM;

public interface NumEMRepository extends JpaRepository<EM, Long> {
	
	List<EM> findByResponsavel(String user);

}
