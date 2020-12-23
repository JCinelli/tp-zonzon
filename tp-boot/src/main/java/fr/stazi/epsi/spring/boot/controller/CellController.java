package fr.stazi.epsi.spring.boot.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.stazi.epsi.spring.boot.entity.Cell;
import fr.stazi.epsi.spring.boot.repository.CellRepository;

@RestController
@RequestMapping("/api/cells")
public class CellController {

	private CellRepository cellRepository;

	public CellController(CellRepository cellRepository) {
		this.cellRepository = cellRepository;
	}
	
	@GetMapping
	public List<Cell> getAll() {
		return cellRepository.findAll();
	}
	
	
	@PreAuthorize("@securityMethods.canManage(#id, principal)")
	@PutMapping("/{id}")
	public Cell update(@PathVariable Long id, @RequestBody Cell entity) {
			return cellRepository.save(entity);
	}

}
