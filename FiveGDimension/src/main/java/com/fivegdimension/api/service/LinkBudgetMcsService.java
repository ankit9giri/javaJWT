package com.fivegdimension.api.service;

import java.util.List;
import java.util.Map;

import com.fivegdimension.api.entity.LinkBudgetMcs;

public interface LinkBudgetMcsService {

	LinkBudgetMcs save(LinkBudgetMcs lbmcs);
	 
	List<LinkBudgetMcs> findAll();
	 
	void deleteById(Long id);

	Map<String, Object> getAllLinkBudgetMcsMap();
}

