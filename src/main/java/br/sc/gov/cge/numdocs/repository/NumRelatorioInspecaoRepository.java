package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.RelatorioInspecao;

public interface NumRelatorioInspecaoRepository extends JpaRepository<RelatorioInspecao, Long> {
	
	List<RelatorioInspecao> findByResponsavel(String user);

}
