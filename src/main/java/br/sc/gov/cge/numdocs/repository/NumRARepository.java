package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.RelatorioAuditoria;

public interface NumRARepository extends JpaRepository<RelatorioAuditoria, Long> {
	
	List<RelatorioAuditoria> findByResponsavel(String user);

}
