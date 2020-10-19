 
package com.fivegdimension.api.service;

import java.util.List;
 
import com.fivegdimension.api.entity.GeneralParameters;

public interface GeneralParametersService {

	GeneralParameters save(GeneralParameters linkBudgetRange);
	 
	List<GeneralParameters> findAll();
	 
	void deleteById(Long id);

	List<GeneralParameters> getAllGeneralParametersMap();
}
