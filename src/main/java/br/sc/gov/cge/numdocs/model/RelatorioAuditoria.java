package br.sc.gov.cge.numdocs.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class RelatorioAuditoria extends NumDocGenerics {
	
	private String paa;
	
	private String especie;
	
	private String materialidade;
	
	private String auditores;

}
