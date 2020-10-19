package com.fivegdimension.api.service;

import java.util.List;
import java.util.Map;

import com.fivegdimension.api.entity.LinkBudgetModel;

public interface LinkBudgetModelService {

	LinkBudgetModel save(LinkBudgetModel lbm);
	 
	List<LinkBudgetModel> findAll();
	 
	void deleteById(Long id);

	List<Map<String, Object>> getAllLinkBudgetModelMap();
}
