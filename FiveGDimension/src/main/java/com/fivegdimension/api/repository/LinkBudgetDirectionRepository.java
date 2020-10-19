package com.fivegdimension.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fivegdimension.api.entity.LinkBudgetDirection;

@Repository
public interface LinkBudgetDirectionRepository  extends JpaRepository<LinkBudgetDirection, Integer>, JpaSpecificationExecutor<LinkBudgetDirection> {

	void deleteById(Long id);
	
}
