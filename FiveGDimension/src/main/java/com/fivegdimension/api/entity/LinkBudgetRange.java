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
@Table(name = "link_budget_range")
public class LinkBudgetRange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="parameter")
	private String parameter;
	
	@Column(name = "value")
	private double value;
	
	@Column(name = "unit")
	private String unit;
	
//	@Column(name="frequency_band")
//	private Double frequencyBand;
//	
//	@Column(name = "BST_antenna_height")
//	private Double bstantennaHeight;
//	
//	@Column(name = "SS_antenna_height")
//	private Double ssantennaHeight;
	

}
