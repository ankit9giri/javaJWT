package com.fivegdimension.api.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fivegdimension.api.entity.LinkBudgetRange;
import com.fivegdimension.api.repository.LinkBudgetRangeRepository;
import com.fivegdimension.api.service.LinkBudgetRangeService;

@Service
@Transactional
public class LinkBudgetRangeImpl implements LinkBudgetRangeService {
	@Autowired
	LinkBudgetRangeRepository linkBudgetRangeRepository;

	public List<LinkBudgetRange> get() {
		return linkBudgetRangeRepository.findAll();
	}

	public LinkBudgetRange save(LinkBudgetRange LinkBudgetRange) {
		return linkBudgetRangeRepository.save(LinkBudgetRange);
	}

	@Override
	public List<LinkBudgetRange> findAll() {
		return linkBudgetRangeRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		linkBudgetRangeRepository.deleteById(id);
	}

	@SuppressWarnings("null")
	@Override
	public Map<String, Object> getAllLinkBudgetRangeMap() {
		List<LinkBudgetRange> list = linkBudgetRangeRepository.findAll();

		List<Map<String, Object>> finalList = new ArrayList<Map<String,Object>>();
		Map<String, Object> fMap = new HashMap<String, Object>();

		for (LinkBudgetRange rangeObj : list) {
			fMap.put(rangeObj.getParameter().trim(),rangeObj.getValue() );
			finalList.add(fMap);
		}

		return fMap;
	}

}
