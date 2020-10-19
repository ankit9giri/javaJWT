package com.fivegdimension.api.controller;

import java.net.URISyntaxException;
import java.util.List;

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

import com.fivegdimension.api.entity.MAPL;
import com.fivegdimension.api.exception.BadRequestException;
import com.fivegdimension.api.service.MAPLService;
import com.fivegdimension.api.util.HeaderUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/api")
public class MAPLController {
	private final Logger log = LoggerFactory.getLogger(MAPLController.class);
 
	private final MAPLService maplService;
	private static final String ENTITY_NAME = "equipmentContract";
	
	public MAPLController(MAPLService maplService) {
		this.maplService = maplService;
	}
	
	@PostMapping("/saveMapl")
	public ResponseEntity<MAPL> saveMapl(@RequestBody MAPL mapl)
			throws URISyntaxException {
		System.out.println("******************************* " + mapl);
		log.debug("REST request to save MAPL : {}", mapl);
		if (mapl.getId() != null) {
			throw new BadRequestException("A new MAPL cannot already have an ID");
		}
		MAPL result = maplService.save(mapl);
		return ResponseEntity.created(new URI("/api/mapl/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@PutMapping("/updateMapl")
	public ResponseEntity<MAPL> updateMapl(@RequestBody MAPL mapl)
			throws URISyntaxException {
		log.debug("REST request to save MAPL : {}", mapl);
		if (mapl.getId() == null) {
			throw new BadRequestException("A new MAPL cannot already have an ID");
		}
		MAPL result = maplService.save(mapl);
		return ResponseEntity.created(new URI("/api/mapl/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@GetMapping("/getMapl") 
	public ResponseEntity<List<MAPL>> getAllMAPL() {
		log.debug("REST request to get MAPL : {}");
		List<MAPL> responseData = maplService.findAll();
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMapl")
	public ResponseEntity<Void> delete(@RequestParam("id") Long id) {
		log.debug("REST request to save MAPL : {}", id);
		maplService.deleteById(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

}
