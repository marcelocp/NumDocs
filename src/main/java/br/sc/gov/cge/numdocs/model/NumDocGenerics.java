package br.sc.gov.cge.numdocs.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class NumDocGenerics {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long num;
	
	private String numSGPE;
	
	private String numProcessoBase;
	
	private String descricao;
	
	private String responsavel;
	
	private String setorRemetente;
	
	private String inclusao;
	
	private String destino;
	
	private String status;
	
	private String observacao;
}
