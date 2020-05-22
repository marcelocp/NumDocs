package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.RelatorioInvestigacao;

public interface NumRelatorioInvestigacaoRepository extends JpaRepository<RelatorioInvestigacao, Long> {
	
	List<RelatorioInvestigacao> findByResponsavel(String user);

}
