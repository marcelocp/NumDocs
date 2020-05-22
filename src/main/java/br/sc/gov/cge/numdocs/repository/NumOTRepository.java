package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.OT;

public interface NumOTRepository extends JpaRepository<OT, Long> {
	
	List<OT> findByResponsavel(String user);

}
