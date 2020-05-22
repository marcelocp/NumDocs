package br.sc.gov.cge.numdocs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table (name = "parecer_rci")
@Entity
public class ParecerRCI extends NumDocGenerics {
	
	private String tipo;
	
	private String auditores;

}
