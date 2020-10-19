package com.fivegdimension.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

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

import com.fivegdimension.api.entity.LinkBudgetMcs;
import com.fivegdimension.api.exception.BadRequestException;
import com.fivegdimension.api.service.LinkBudgetMcsService;
import com.fivegdimension.api.util.HeaderUtil;

@RestController
@RequestMapping("/api")
public class LinkBudgetMcsController {


	private final Logger log = LoggerFactory.getLogger(LinkBudgetMcsController.class);

	private final LinkBudgetMcsService linkBudgetMcsService;
	private static final String ENTITY_NAME = "LinkBudgetMcs";
	
	public LinkBudgetMcsController(LinkBudgetMcsService linkBudgetMcsService) {
		this.linkBudgetMcsService = linkBudgetMcsService;
	}
	
	@PostMapping("/link-budget-mcs/save")
	public ResponseEntity<LinkBudgetMcs> saveLinkBudgetMcs(@RequestBody LinkBudgetMcs linkBudgetMcs)
			throws URISyntaxException {
		System.out.println("******************************* " + linkBudgetMcs);
		log.debug("REST request to save LinkBudgetMcs : {}", linkBudgetMcs);
		if (linkBudgetMcs.getId() != null) {
			throw new BadRequestException("A new LinkBudgetMcs cannot already have an ID");
		}
		LinkBudgetMcs result = linkBudgetMcsService.save(linkBudgetMcs);
		return ResponseEntity.created(new URI("/api/linkBudgetMcs/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@PutMapping("/link-budget-mcs/update")
	public ResponseEntity<LinkBudgetMcs> updateLinkBudgetMcs(@RequestBody LinkBudgetMcs linkbudgetMcs)
			throws URISyntaxException {
		log.debug("REST request to save link-budget-mcs/ : {}", linkbudgetMcs);
		if (linkbudgetMcs.getId() == null) {
			LinkBudgetMcs result = linkBudgetMcsService.save(linkbudgetMcs);
			return ResponseEntity.created(new URI("/api/linkBudgetMcs/" + result.getId()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
					.body(result);	
		}
		LinkBudgetMcs result = linkBudgetMcsService.save(linkbudgetMcs);
		return ResponseEntity.created(new URI("/api/link-budget-mcs/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@GetMapping("/link-budget-mcs/get") 
	public ResponseEntity<List<LinkBudgetMcs>> getAllLinkBudgetMcs() {
		log.debug("REST request to get LinkBudgetMcs : {}");
		List<LinkBudgetMcs> responseData = linkBudgetMcsService.findAll();
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@DeleteMapping("/link-budget-mcs/delete")
	public ResponseEntity<Void> delete(@RequestParam("id") Long id) {
		log.debug("REST request to save LinkBudgetMcs : {}", id);
		linkBudgetMcsService.deleteById(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
	
	@GetMapping("/link-budget-mcs/getMcsMap") 
	public ResponseEntity<Map<String, Object>> getAllLinkBudgetMcsMap() {
		log.debug("REST request to get LinkBudgetMcs : {}");
		Map<String, Object> list = linkBudgetMcsService.getAllLinkBudgetMcsMap();
		 
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
}
