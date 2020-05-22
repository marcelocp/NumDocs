package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.InstrucaoNormativa;

public interface NumINRepository extends JpaRepository<InstrucaoNormativa, Long> {
	
	List<InstrucaoNormativa> findByResponsavel(String user);

}
