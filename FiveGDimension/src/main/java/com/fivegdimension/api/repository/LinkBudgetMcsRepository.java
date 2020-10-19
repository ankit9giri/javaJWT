package com.fivegdimension.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fivegdimension.api.entity.LinkBudgetMcs;

@Repository
public interface LinkBudgetMcsRepository  extends JpaRepository<LinkBudgetMcs, Integer>, JpaSpecificationExecutor<LinkBudgetMcs> {

	void deleteById(Long id);
}

