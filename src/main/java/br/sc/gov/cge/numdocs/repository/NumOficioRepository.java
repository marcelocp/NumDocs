package br.sc.gov.cge.numdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.gov.cge.numdocs.model.Oficio;

public interface NumOficioRepository extends JpaRepository<Oficio, Long> {
	
	List<Oficio> findByResponsavel(String user);

}
