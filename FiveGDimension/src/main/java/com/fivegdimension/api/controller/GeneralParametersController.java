package com.fivegdimension.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fivegdimension.api.entity.GeneralParameters;
import com.fivegdimension.api.exception.BadRequestException;
import com.fivegdimension.api.service.GeneralParametersService;
import com.fivegdimension.api.util.HeaderUtil;

@RestController
@RequestMapping("/api")
public class GeneralParametersController {
	private final Logger log = LoggerFactory.getLogger(GeneralParametersController.class);

	private final GeneralParametersService generalParametersService;
	private static final String ENTITY_NAME = "GeneralParameters";
	
	public GeneralParametersController(GeneralParametersService generalParametersService) {
		this.generalParametersService = generalParametersService;
	}
	
//	@PostMapping("general-parameter/save")
//	public ResponseEntity<GeneralParameters> saveGeneralParameters(@RequestBody GeneralParameters dimGeneralParameters)
//			throws URISyntaxException {
//		log.debug("REST request to save GeneralParameters : {}", dimGeneralParameters);
//		if (dimGeneralParameters.getId() != null) {
//			throw new BadRequestException("A new GeneralParameters cannot already have an ID");
//		}
//		GeneralParameters result = generalParametersService.save(dimGeneralParameters);
//		return ResponseEntity.created(new URI("/api/dimGeneralParameters/" + result.getId()))
//				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
//				.body(result);		
//	}
	
//	@PutMapping("general-parameter/update")
//	public ResponseEntity<GeneralParameters> updateGeneralParameters(@RequestBody GeneralParameters linkbudgetRange)
//			throws URISyntaxException {
//		log.debug("REST request to save dim-general-parameter/ : {}", linkbudgetRange);
//		if (linkbudgetRange.getId() == null) {
//			GeneralParameters result = generalParametersService.save(linkbudgetRange);
//			return ResponseEntity.created(new URI("/api/dimGeneralParameters/" + result.getId()))
//					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
//					.body(result);	
//		}
//		GeneralParameters result = generalParametersService.save(linkbudgetRange);
//		return ResponseEntity.created(new URI("/apigeneral-parameter/" + result.getId()))
//				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
//				.body(result);		
//	}
	
	@PutMapping("general-parameter/update")
	public ResponseEntity<GeneralParameters> updateGeneralParameters(@RequestBody List<GeneralParameters> dimGeneralParametersList)
			throws URISyntaxException {
		log.debug("REST request to save dim-general-parameter/ : {}", dimGeneralParametersList);
		GeneralParameters result = null;
		for(GeneralParameters dimGeneralParameters : dimGeneralParametersList) {
//			if (dimGeneralParameters.getId() == null) {
//				result = generalParametersService.save(dimGeneralParameters);
//				return ResponseEntity.created(new URI("/api/dimGeneralParameters/" + result.getId()))
//						.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
//						.body(result);	
//			}
			  result = generalParametersService.save(dimGeneralParameters);
		}		
		return ResponseEntity.created(new URI("/apigeneral-parameter/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@GetMapping("general-parameter/get") 
	public ResponseEntity<List<GeneralParameters>> getAllGeneralParameters() {
		log.debug("REST request to get GeneralParameters : {}");
		List<GeneralParameters> responseData = generalParametersService.findAll();
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@DeleteMapping("general-parameter/delete")
	public ResponseEntity<Void> delete(@RequestParam("id") Long id) {
		log.debug("REST request to save GeneralParameters : {}", id);
		generalParametersService.deleteById(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
	
	@GetMapping("general-parameter/getRangeMap") 
	public ResponseEntity<List<GeneralParameters>> getAllGeneralParametersMap() {
		log.debug("REST request to get GeneralParameters : {}");
		List<GeneralParameters> list = generalParametersService.getAllGeneralParametersMap();
		 
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
}

