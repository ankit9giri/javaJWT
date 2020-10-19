 
package com.fivegdimension.api.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fivegdimension.api.entity.GeneralParameters;
import com.fivegdimension.api.repository.GeneralParametersRepository;
import com.fivegdimension.api.service.GeneralParametersService;

@Service
@Transactional
public class GeneralParametersImpl implements GeneralParametersService {
	@Autowired
	GeneralParametersRepository dimGeneralParametersRepository;

	public List<GeneralParameters> get() {
		return dimGeneralParametersRepository.findAll();
	}

	public GeneralParameters save(GeneralParameters generalParameters) {
		return dimGeneralParametersRepository.save(generalParameters);
	}

	@Override
	public List<GeneralParameters> findAll() {
		return dimGeneralParametersRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		dimGeneralParametersRepository.deleteById(id);
	}

	@SuppressWarnings("null")
	@Override
	public List<GeneralParameters> getAllGeneralParametersMap() {
		List<GeneralParameters> list = dimGeneralParametersRepository.findAll();

		List<Map<String, Object>> finalList = new ArrayList<Map<String,Object>>();
		Map<String, Object> fMap = new HashMap<String, Object>();

//		for (GeneralParameters dimObj : list) {
//			fMap.put(dimObj.getParameter().trim(),  );
//			finalList.add(fMap);
//		}

//		return fMap;
		
		return list;
	}

}
