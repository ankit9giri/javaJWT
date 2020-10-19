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
@Table(name = "link_budget_mcs")
public class LinkBudgetMcs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="parameter")
	private String parameter;
	
	@Column(name="value_0")
	private Double value0;
	
	@Column(name="value_1")
	private Double value1;
	
	@Column(name="value_2")
	private Double value2;
	
	@Column(name="value_3")
	private Double value3;
	
	@Column(name="value_4")
	private Double value4;
	
	@Column(name="value_5")
	private Double value5;
	
	@Column(name="value_6")
	private Double value6;
	
	@Column(name="value_7")
	private Double value7;
	
	@Column(name="value_8")
	private Double value8;
	
	@Column(name="value_9")
	private Double value9;
	
	@Column(name="value_10")
	private Double value10;
	
	@Column(name="value_11")
	private Double value11;
	
	@Column(name="value_12")
	private Double value12;
	
	@Column(name="value_13")
	private Double value13;
	
	@Column(name="value_14")
	private Double value14;
	
	@Column(name="value_15")
	private Double value15;
	
	@Column(name="value_16")
	private Double value16;
	
	@Column(name="value_17")
	private Double value17;
	
	@Column(name="value_18")
	private Double value18;
	
	@Column(name="value_19")
	private Double value19;
	
	@Column(name="value_20")
	private Double value20;
	
	@Column(name="value_21")
	private Double value21;
	
	@Column(name="value_22")
	private Double value22;
	
	@Column(name="value_23")
	private Double value23;
	
	@Column(name="value_24")
	private Double value24;
	
	@Column(name="value_25")
	private Double value25;
	
	@Column(name="value_26")
	private Double value26;
	
	@Column(name="value_27")
	private Double value27;
	
	@Column(name="value_28")
	private Double value28;
	
	@Column(name = "unit")
	private String unit;
}
