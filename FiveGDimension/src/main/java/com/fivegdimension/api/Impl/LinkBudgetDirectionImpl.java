package com.fivegdimension.api.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fivegdimension.api.entity.LinkBudgetDirection;
import com.fivegdimension.api.entity.LinkBudgetRange;
import com.fivegdimension.api.repository.LinkBudgetDirectionRepository;
import com.fivegdimension.api.service.LinkBudgetDirectionService;


@Service
@Transactional
public class LinkBudgetDirectionImpl implements LinkBudgetDirectionService {
	@Autowired
	LinkBudgetDirectionRepository linkBudgetDirectionRepository;

	public List<LinkBudgetDirection> get() {
		return linkBudgetDirectionRepository.findAll();
	}

	public LinkBudgetDirection save(LinkBudgetDirection LinkBudgetDirection) {
		return linkBudgetDirectionRepository.save(LinkBudgetDirection);
	}

	@Override
	public List<LinkBudgetDirection> findAll() { 
		return linkBudgetDirectionRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		 linkBudgetDirectionRepository.deleteById(id);
	}

	@Override
	public Map<String, Object> getAllLinkBudgetDirectionMap() {
		List<LinkBudgetDirection> list = linkBudgetDirectionRepository.findAll();

		Map<String, Object> map = new HashMap<String, Object>();
		for (LinkBudgetDirection dirObj : list) {
			Map<String, Object> inMap = new HashMap<String, Object>();
			
			inMap.put("ue", dirObj.getUe());
			inMap.put("enb", dirObj.getEnb());
			map.put(dirObj.getParameter().trim(), inMap);
		}
		return map;
	}
	
 
}
