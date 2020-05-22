package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.ParecerRCI;

public interface NumParecerRCIRepository extends JpaRepository<ParecerRCI, Long> {
	
	List<ParecerRCI> findByResponsavel(String user);

}
