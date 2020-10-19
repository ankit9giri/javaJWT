package com.fivegdimension.api.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fivegdimension.api.entity.LinkBudgetModel;
import com.fivegdimension.api.entity.LinkBudgetModel;
import com.fivegdimension.api.repository.LinkBudgetModelRepository;
import com.fivegdimension.api.service.LinkBudgetModelService;


@Service
@Transactional
public class LinkBudgetModelImpl implements LinkBudgetModelService {
	@Autowired
	LinkBudgetModelRepository linkBudgetModelRepository;

	public List<LinkBudgetModel> get() {
		return linkBudgetModelRepository.findAll();
	}

	public LinkBudgetModel save(LinkBudgetModel LinkBudgetModel) {
		return linkBudgetModelRepository.save(LinkBudgetModel);
	}

	@Override
	public List<LinkBudgetModel> findAll() { 
		return linkBudgetModelRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		 linkBudgetModelRepository.deleteById(id);
	}

	@Override
	public List<Map<String, Object>> getAllLinkBudgetModelMap() {
		List<LinkBudgetModel> list = linkBudgetModelRepository.findAll();

		List<Map<String, Object>> finalList = new ArrayList<Map<String,Object>>();

		for (LinkBudgetModel rangeObj : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("parameter", rangeObj.getParameter());
			map.put("urban", rangeObj.getUrban());
			map.put("suburban", rangeObj.getSuburban());
			map.put("rural", rangeObj.getRural());
			finalList.add(map);
		}

		return finalList;	}
	
 
}
