 
package com.fivegdimension.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fivegdimension.api.entity.GeneralParameters;
 
@Repository
public interface GeneralParametersRepository  extends JpaRepository<GeneralParameters, Integer>, JpaSpecificationExecutor<GeneralParameters> {

	void deleteById(Long id);
}
