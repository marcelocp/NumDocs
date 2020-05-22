package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.OficioCircular;

public interface NumOCRepository extends JpaRepository<OficioCircular, Long> {
	
	List<OficioCircular> findByResponsavel(String user);

}
