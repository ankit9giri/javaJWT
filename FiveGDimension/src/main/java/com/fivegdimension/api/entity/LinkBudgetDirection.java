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
@Table(name = "link_budget_direction")
public class LinkBudgetDirection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="parameter")
	private String parameter;
	
	@Column(name="enb")
	private Double enb;
	
	@Column(name="ue")
	private Double ue;
	
	@Column(name = "unit")
	private String unit;

	
//	@Column(name = "eNB_feeder_loss")
//	private Double enbFeederLoss;
//	
//	@Column(name = "inter_cell_interference_margin_DL_UL")
//	private Double interCellInterferenceMarginDLUL;
	
}
