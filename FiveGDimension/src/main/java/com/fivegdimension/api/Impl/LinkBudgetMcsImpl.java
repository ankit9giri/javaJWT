package com.fivegdimension.api.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fivegdimension.api.entity.LinkBudgetDirection;
import com.fivegdimension.api.entity.LinkBudgetMcs;
import com.fivegdimension.api.entity.LinkBudgetMcs;
import com.fivegdimension.api.repository.LinkBudgetMcsRepository;
import com.fivegdimension.api.service.LinkBudgetMcsService;


@Service
@Transactional
public class LinkBudgetMcsImpl implements LinkBudgetMcsService {
	@Autowired
	LinkBudgetMcsRepository linkBudgetMcsRepository;

	public List<LinkBudgetMcs> get() {
		return linkBudgetMcsRepository.findAll();
	}

	public LinkBudgetMcs save(LinkBudgetMcs LinkBudgetMcs) {
		return linkBudgetMcsRepository.save(LinkBudgetMcs);
	}

	@Override
	public List<LinkBudgetMcs> findAll() { 
		return linkBudgetMcsRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		 linkBudgetMcsRepository.deleteById(id);
	}
	
	@Override
	public Map<String, Object> getAllLinkBudgetMcsMap() {
		List<LinkBudgetMcs> list = linkBudgetMcsRepository.findAll();

		Map<String, Object> map = new HashMap<String, Object>();
		for (LinkBudgetMcs mcsObj : list) {
			Map<String, Object> inMap = new HashMap<String, Object>();
			 
			inMap.put("value0", mcsObj.getValue0());
			inMap.put("value1", mcsObj.getValue1());
			inMap.put("value2", mcsObj.getValue2());
			inMap.put("value3", mcsObj.getValue3());
			inMap.put("value4", mcsObj.getValue4());
			inMap.put("value5", mcsObj.getValue5());
			inMap.put("value6", mcsObj.getValue6());
			inMap.put("value7", mcsObj.getValue7());
			inMap.put("value8", mcsObj.getValue8());
			inMap.put("value9", mcsObj.getValue9());
			inMap.put("value10", mcsObj.getValue10());
			inMap.put("value11", mcsObj.getValue11());
			inMap.put("value12", mcsObj.getValue12());
			inMap.put("value13", mcsObj.getValue13());
			inMap.put("value14", mcsObj.getValue14());
			inMap.put("value15", mcsObj.getValue15());
			inMap.put("value16", mcsObj.getValue16());
			inMap.put("value17", mcsObj.getValue17());
			inMap.put("value18", mcsObj.getValue18());
			inMap.put("value19", mcsObj.getValue19());
			inMap.put("value20", mcsObj.getValue20());
			inMap.put("value21", mcsObj.getValue21());
			inMap.put("value22", mcsObj.getValue22());
			inMap.put("value23", mcsObj.getValue23());
			inMap.put("value24", mcsObj.getValue24());
			inMap.put("value25", mcsObj.getValue25());
			inMap.put("value26", mcsObj.getValue26());
			inMap.put("value27", mcsObj.getValue27());
			inMap.put("value28", mcsObj.getValue28());
			map.put(mcsObj.getParameter().trim(), inMap);
		}
		return map;
	}
	
 
}


