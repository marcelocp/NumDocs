package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.Informacao;

public interface NumInfoRepository extends JpaRepository<Informacao, Long> {

	List<Informacao> findByResponsavel(String user);
}
