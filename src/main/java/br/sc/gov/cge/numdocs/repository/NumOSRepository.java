package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.OS;

public interface NumOSRepository extends JpaRepository<OS, Long> {
	
	List<OS> findByResponsavel(String responsavel);

}
