package com.fivegdimension.api.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fivegdimension.api.entity.MAPL;
import com.fivegdimension.api.repository.MAPLRepository;
import com.fivegdimension.api.service.MAPLService;


@Service
@Transactional
public class MAPLServiceImpl implements MAPLService {
	@Autowired
	MAPLRepository maplRepository;
	
	public List<MAPL> get() {
		return maplRepository.findAll();
	}

	public MAPL save(MAPL mapl) {
		return maplRepository.save(mapl);
	}

	@Override
	public List<MAPL> findAll() { 
		return maplRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		 maplRepository.deleteById(id);
	}
 
}
