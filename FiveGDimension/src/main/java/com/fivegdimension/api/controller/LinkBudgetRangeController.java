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

import com.fivegdimension.api.entity.LinkBudgetRange;
import com.fivegdimension.api.exception.BadRequestException;
import com.fivegdimension.api.service.LinkBudgetRangeService;
import com.fivegdimension.api.util.HeaderUtil;

@RestController
@RequestMapping("/api")
public class LinkBudgetRangeController {
	private final Logger log = LoggerFactory.getLogger(LinkBudgetRangeController.class);

	private final LinkBudgetRangeService linkBudgetRangeService;
	private static final String ENTITY_NAME = "LinkBudgetRange";
	
	public LinkBudgetRangeController(LinkBudgetRangeService linkBudgetRangeService) {
		this.linkBudgetRangeService = linkBudgetRangeService;
	}
	
	@PostMapping("/link-budget-range/save")
	public ResponseEntity<LinkBudgetRange> saveLinkBudgetRange(@RequestBody LinkBudgetRange linkBudgetRange)
			throws URISyntaxException {
		log.debug("REST request to save LinkBudgetRange : {}", linkBudgetRange);
		if (linkBudgetRange.getId() != null) {
			throw new BadRequestException("A new LinkBudgetRange cannot already have an ID");
		}
		LinkBudgetRange result = linkBudgetRangeService.save(linkBudgetRange);
		return ResponseEntity.created(new URI("/api/linkBudgetRange/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@PutMapping("/link-budget-range/update")
	public ResponseEntity<LinkBudgetRange> updateLinkBudgetRange(@RequestBody LinkBudgetRange linkbudgetRange)
			throws URISyntaxException {
		log.debug("REST request to save link-budget-range/ : {}", linkbudgetRange);
		if (linkbudgetRange.getId() == null) {
			LinkBudgetRange result = linkBudgetRangeService.save(linkbudgetRange);
			return ResponseEntity.created(new URI("/api/linkBudgetRange/" + result.getId()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
					.body(result);	
		}
		LinkBudgetRange result = linkBudgetRangeService.save(linkbudgetRange);
		return ResponseEntity.created(new URI("/api/link-budget-range/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@GetMapping("/link-budget-range/get") 
	public ResponseEntity<List<LinkBudgetRange>> getAllLinkBudgetRange() {
		log.debug("REST request to get LinkBudgetRange : {}");
		List<LinkBudgetRange> responseData = linkBudgetRangeService.findAll();
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@DeleteMapping("/link-budget-range/delete")
	public ResponseEntity<Void> delete(@RequestParam("id") Long id) {
		log.debug("REST request to save LinkBudgetRange : {}", id);
		linkBudgetRangeService.deleteById(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
	
	@GetMapping("/link-budget-range/getRangeMap") 
	public ResponseEntity<Map<String, Object>> getAllLinkBudgetRangeMap() {
		log.debug("REST request to get LinkBudgetRange : {}");
		Map<String, Object> list = linkBudgetRangeService.getAllLinkBudgetRangeMap();
		 
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
}
