package com.fivegdimension.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fivegdimension.api.entity.LinkBudgetRange;

@Repository
public interface LinkBudgetRangeRepository  extends JpaRepository<LinkBudgetRange, Integer>, JpaSpecificationExecutor<LinkBudgetRange> {

	void deleteById(Long id);
}
