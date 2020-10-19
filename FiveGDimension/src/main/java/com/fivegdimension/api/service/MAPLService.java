package com.fivegdimension.api.service;

import java.util.List;

import com.fivegdimension.api.entity.MAPL;

public interface MAPLService {

	 MAPL save(MAPL mapl);
	 
	 List<MAPL> findAll();
	 
	 void deleteById(Long id);
}
