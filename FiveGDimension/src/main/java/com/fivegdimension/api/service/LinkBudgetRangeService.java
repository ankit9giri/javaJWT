package com.fivegdimension.api.service;

import java.util.List;
import java.util.Map;

import com.fivegdimension.api.entity.LinkBudgetRange;

public interface LinkBudgetRangeService {

	LinkBudgetRange save(LinkBudgetRange linkBudgetRange);
	 
	List<LinkBudgetRange> findAll();
	 
	void deleteById(Long id);

	Map<String, Object> getAllLinkBudgetRangeMap();
}
