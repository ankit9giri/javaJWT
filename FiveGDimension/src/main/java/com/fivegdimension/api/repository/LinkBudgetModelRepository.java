package com.fivegdimension.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fivegdimension.api.entity.LinkBudgetModel;

@Repository
public interface LinkBudgetModelRepository  extends JpaRepository<LinkBudgetModel, Integer>, JpaSpecificationExecutor<LinkBudgetModel> {

	void deleteById(Long id);
}
