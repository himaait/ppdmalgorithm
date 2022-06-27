package com.ppdm.Rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ppdm.Exception.CustomExceptionTypeCopy;
import com.ppdm.dto.PpdmDTO;
import com.ppdm.repository.PpdmJpaRepository;

@RestController
@RequestMapping("/api/ppdmalgorithms")
public class PpdmAlgorithmsRestController {
	public static Logger logger = LoggerFactory.getLogger(PpdmAlgorithmsRestController.class);
	private PpdmJpaRepository ppdmJpaRepository;

	@Autowired
	public void setPpdmJpaRepository(PpdmJpaRepository ppdmJpaRepository) {
		this.ppdmJpaRepository = ppdmJpaRepository;
	}

	@GetMapping("/")
	public ResponseEntity<List<PpdmDTO>> listallAlgorithms() {
		List<PpdmDTO> ppdm = ppdmJpaRepository.findAll();
		if (ppdm.isEmpty()) {
			return new ResponseEntity<List<PpdmDTO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<PpdmDTO>>(ppdm, HttpStatus.OK);
	}

	// method to create new algorithm
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PpdmDTO> createAlgorithm(@Valid @RequestBody final PpdmDTO ppdm) {
		logger.info("Creating PPDM Algorithm : {}", ppdm);
		if (ppdmJpaRepository.findByppdmAlgorithmName(ppdm.getPpdmAlgorithmName()) != null) {
			logger.error("Unable to create as algorithm with name {} already exist",
					 ppdm.getPpdmAlgorithmName());
			return new ResponseEntity<PpdmDTO>(
					new CustomExceptionTypeCopy("Unable to create new algorithm. An algorithm with name "
							+ ppdm.getPpdmAlgorithmName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		ppdmJpaRepository.save(ppdm);
		return new ResponseEntity<PpdmDTO>(ppdm, HttpStatus.CREATED);
	}

	// method to fetch an algorithm by its id
	@GetMapping("/{algorithmId}")
	public ResponseEntity<PpdmDTO> getAlgorithmByName(@PathVariable("algorithmId") final Long id) {
		Optional<PpdmDTO> ppdm = ppdmJpaRepository.findById(id);
		if (ppdm.isEmpty()) {
			return new ResponseEntity<PpdmDTO>(new CustomExceptionTypeCopy("Algorithm with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PpdmDTO>(ppdm.get(), HttpStatus.OK);
	}

	@PutMapping(value = "/{algorithmId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PpdmDTO> updateAlgorithm(@PathVariable("algorithmId") final Long id,
			@RequestBody PpdmDTO ppdm) {
		// fetch the algorithm based on id and set it to currentAlgorithm object of
		// type PpdmDTO
		Optional<PpdmDTO> currentAlgorithm = ppdmJpaRepository.findById(id);
		if (currentAlgorithm.isEmpty()) {
			return new ResponseEntity<PpdmDTO>(
					new CustomExceptionTypeCopy("Unable to update. Algorithm with name  " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		// update currentAlgorithm object data with ppdm object data
		PpdmDTO _currentAlgorithm = currentAlgorithm.get();
		_currentAlgorithm.setPpdmAlgorithmName(ppdm.getPpdmAlgorithmName());
		_currentAlgorithm.setPpdmTechniqueName(ppdm.getPpdmTechniqueName());
		_currentAlgorithm.setHidingFailure(ppdm.getHidingFailure());
		_currentAlgorithm.setMissingCost(ppdm.getMissingCost());
		_currentAlgorithm.setArtificialCost(ppdm.getArtificialCost());
		_currentAlgorithm.setDataDissimilarity(ppdm.getDataDissimilarity());
		_currentAlgorithm.setOtherSideEffects(ppdm.getOtherSideEffects());
		_currentAlgorithm.setEmail(ppdm.getEmail());
		// save currentAlgorithm object
		ppdmJpaRepository.saveAndFlush(_currentAlgorithm);
		// return ResponseEntity object
		return new ResponseEntity<PpdmDTO>(_currentAlgorithm, HttpStatus.OK);
	}

	@DeleteMapping("/{algorithmId}")
	public ResponseEntity<PpdmDTO> deleteAlgorithm(@PathVariable("algorithmId") final Long id) {

		Optional<PpdmDTO> ppdm = ppdmJpaRepository.findById(id);
		if (ppdm == null) {
			return new ResponseEntity<PpdmDTO>(new CustomExceptionTypeCopy("Algorithm with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		ppdmJpaRepository.deleteById(id);
		return new ResponseEntity<PpdmDTO>(HttpStatus.NO_CONTENT);
	}

}
