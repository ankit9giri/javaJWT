package com.fivegdimension.api.service;

import java.util.List;
import java.util.Map;

import com.fivegdimension.api.entity.LinkBudgetDirection;

public interface LinkBudgetDirectionService {

	LinkBudgetDirection save(LinkBudgetDirection lbdir);
	 
	List<LinkBudgetDirection> findAll();
	 
	void deleteById(Long id);

	Map<String, Object> getAllLinkBudgetDirectionMap();
}
