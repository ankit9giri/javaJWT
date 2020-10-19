 
package com.fivegdimension.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "dl_reference_cell_throughput")
public class DLReferenceCellThroughput {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ISD")
	private Integer isd;
	
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dl_ref_cell")
    private Set<DLReferenceOutdoor> dimDLReferenceOutdoor = new HashSet<>();
	
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dl_ref_cell")
    private Set<DLReferenceOutdoorBasic> dimDLReferenceOutdoorbasic = new HashSet<>();
	
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dl_ref_cell")
    private Set<DLReferenceOutdoorHighEnd> dimDLReferenceOutdoorhighend = new HashSet<>();
 
}
