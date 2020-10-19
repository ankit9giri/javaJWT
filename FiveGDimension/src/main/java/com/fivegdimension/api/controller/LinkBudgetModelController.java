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

import com.fivegdimension.api.entity.LinkBudgetModel;
import com.fivegdimension.api.exception.BadRequestException;
import com.fivegdimension.api.service.LinkBudgetModelService;
import com.fivegdimension.api.util.HeaderUtil;

@RestController
@RequestMapping("/api")
public class LinkBudgetModelController {
	private final Logger log = LoggerFactory.getLogger(LinkBudgetModelController.class);

	private final LinkBudgetModelService linkBudgetModelService;
	private static final String ENTITY_NAME = "LinkBudgetModel";
	
	public LinkBudgetModelController(LinkBudgetModelService linkBudgetModelService) {
		this.linkBudgetModelService = linkBudgetModelService;
	}
	
	@PostMapping("/link-budget-model/save")
	public ResponseEntity<LinkBudgetModel> saveLinkBudgetModel(@RequestBody LinkBudgetModel linkBudgetModel)
			throws URISyntaxException {
		System.out.println("******************************* " + linkBudgetModel);
		log.debug("REST request to save LinkBudgetModel : {}", linkBudgetModel);
		if (linkBudgetModel.getId() != null) {
			throw new BadRequestException("A new LinkBudgetModel cannot already have an ID");
		}
		LinkBudgetModel result = linkBudgetModelService.save(linkBudgetModel);
		return ResponseEntity.created(new URI("/api/linkBudgetModel/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@PutMapping("/link-budget-model/update")
	public ResponseEntity<LinkBudgetModel> updateLinkBudgetModel(@RequestBody LinkBudgetModel linkbudgetModel)
			throws URISyntaxException {
		log.debug("REST request to save link-budget-model/ : {}", linkbudgetModel);
		if (linkbudgetModel.getId() == null) {
			LinkBudgetModel result = linkBudgetModelService.save(linkbudgetModel);
			return ResponseEntity.created(new URI("/api/linkBudgetModel/" + result.getId()))
					.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
					.body(result);	
		}
		LinkBudgetModel result = linkBudgetModelService.save(linkbudgetModel);
		return ResponseEntity.created(new URI("/api/link-budget-model/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
				.body(result);		
	}
	
	@GetMapping("/link-budget-model/get") 
	public ResponseEntity<List<LinkBudgetModel>> getAllLinkBudgetModel() {
		log.debug("REST request to get LinkBudgetModel : {}");
		List<LinkBudgetModel> responseData = linkBudgetModelService.findAll();
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@DeleteMapping("/link-budget-model/delete")
	public ResponseEntity<Void> delete(@RequestParam("id") Long id) {
		log.debug("REST request to save LinkBudgetModel : {}", id);
		linkBudgetModelService.deleteById(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
	
	@GetMapping("/link-budget-model/getModelMap") 
	public ResponseEntity<List<Map<String, Object>>> getAllLinkBudgetModelMap() {
		log.debug("REST request to get LinkBudgetModel : {}");
		List<Map<String, Object>> list = linkBudgetModelService.getAllLinkBudgetModelMap();
		 
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
}
