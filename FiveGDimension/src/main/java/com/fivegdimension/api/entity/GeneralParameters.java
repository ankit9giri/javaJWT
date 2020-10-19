package com.fivegdimension.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "general_parameters")
public class GeneralParameters {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="parameter")
	private String parameter;
	
	@Column(name="dense_urban")
	private Double denseUrban;
	
	@Column(name="urban")
	private Double urban;
	
	@Column(name = "sub_urban")
	private Double subUrban;

	@Column(name = "rural")
	private Double rural;
	
	@Column(name = "dl")
	private String dl;
	
	@Column(name = "ul")
	private String ul;
	
}
