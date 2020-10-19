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

import com.fivegdimension.api.entity.LinkBudgetDirection;
import com.fivegdimension.api.exception.BadRequestException;
import com.fivegdimension.api.service.LinkBudgetDirectionService;
import com.fivegdimension.api.util.HeaderUtil;

@RestController
@RequestMapping("/api")
public class LinkBudgetDirectionController {

	private final Logger log = LoggerFactory.getLogger(LinkBudgetDirectionController.class);

	private final LinkBudgetDirectionService linkBudgetDirectionService;
	private static final String ENTITY_NAME = "LinkBudgetDirection";
	
	public LinkBudgetDirectionController(LinkBudgetDirectionService linkBudgetDirectionService) {
		this.linkBudgetDirectionService = linkBudgetDirectionService;
	}
	
	@PostMapping("/link-budget-direction/save")
	public ResponseEntity<LinkBudgetDirection> saveLinkBudgetDirection(@RequestBody LinkBudgetDirection linkBudgetDirection)
			throws URISyntaxException {
		System.out.println("******************************* " + linkBudgetDirection);
		log.debug("REST request to save LinkBudgetDirection : {}", linkBudgetDirection);
		if (linkBudgetDirection.getId() != null) {
			throw new BadRequestException("A new LinkBudgetDirection cannot already have an ID");
		}
		LinkBudgetDirection result = linkBudgetDirectionService.save(linkBudgetDirection);
		return ResponseEntity.created(new URI("/api/linkBudgetDirection/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@PutMapping("/link-budget-direction/update")
	public ResponseEntity<LinkBudgetDirection> updateLinkBudgetDirection(@RequestBody LinkBudgetDirection linkbudgetDirection)
			throws URISyntaxException {
		log.debug("REST request to save link-budget-direction/ : {}", linkbudgetDirection);
		if (linkbudgetDirection.getId() == null) {
			LinkBudgetDirection result = linkBudgetDirectionService.save(linkbudgetDirection);
			return ResponseEntity.created(new URI("/api/linkBudgetDirection/" + result.getId()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
					.body(result);	
		}
		LinkBudgetDirection result = linkBudgetDirectionService.save(linkbudgetDirection);
		return ResponseEntity.created(new URI("/api/link-budget-direction/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@GetMapping("/link-budget-direction/get") 
	public ResponseEntity<List<LinkBudgetDirection>> getAllLinkBudgetDirection() {
		log.debug("REST request to get LinkBudgetDirection : {}");
		List<LinkBudgetDirection> responseData = linkBudgetDirectionService.findAll();
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@DeleteMapping("/link-budget-direction/delete")
	public ResponseEntity<Void> delete(@RequestParam("id") Long id) {
		log.debug("REST request to save LinkBudgetDirection : {}", id);
		linkBudgetDirectionService.deleteById(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
	
	@GetMapping("/link-budget-direction/getDirectionMap") 
	public ResponseEntity<Map<String, Object>> getAllLinkBudgetDirectionMap() {
		log.debug("REST request to get LinkBudgetDirection : {}");
		Map<String, Object> list = linkBudgetDirectionService.getAllLinkBudgetDirectionMap();
		 
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
