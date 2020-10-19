package com.fivegdimension.api.repository;

import com.fivegdimension.api.entity.MAPL;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

 @Repository
public interface MAPLRepository  extends JpaRepository<MAPL, Integer>, JpaSpecificationExecutor<MAPL> {

	void deleteById(Long id);

}
