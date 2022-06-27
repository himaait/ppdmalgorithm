/**
 * 
 */
package com.ppdm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;;


/**
 * @author hb
 * 
 *
 */
@Entity
@Table(name = "PpdmAlgorithms")
public class PpdmDTO {

	@Id
	@GeneratedValue
	@Column(name = "ALGORITHM_ID")
	private Long algorithmId;
	
	@NotEmpty(message = "error.ppdmalgorithmname.empty")
	@Length(max = 50, message = "error.ppdmalgorithmname.length")
	@Column(name = "PPDM_ALGORITHM_NAME")
	private String ppdmAlgorithmName;
	
	
	@Column(name = "PPDM_TECHNIQUE_NAME")
	@Length(max = 150, message = "error.ppdtechniquename.length")
	private String ppdmTechniqueName;
	
	
	@Column(name = "HIDING_FAILURE")
	@Length(max = 100, message = "error.hidingfailure.length")
	private String hidingFailure;
	
	@Column(name = "MISSING_COST")
	@Length(max = 100, message = "error.missingcost.length")
	private String missingCost;
	
	@Length(max = 100, message = "error.artificialcost.length")
	@Column(name = "ARTIFICIAL_COST")
	private String artificialCost;
	
	@Length(max = 100, message = "error.datadissimilarity.length")
	@Column(name = "DATA_DISSIMILARITY")
	private String dataDissimilarity;
	
	@Length(max = 300, message = "error.othersideeffects.length")
	@Column(name = "OTHER_SIDE_EFFECTS")
	private String otherSideEffects;
	
	@NotEmpty(message = "error.email.empty")
	@Email(message = "error.email.email")
	@Length(max = 80 )
	@Column(name = "EMAIl")
	private String email;

	// getters and setters
	
	public Long getAlgorithmId() {
		return algorithmId;
	}

	public void setAlgorithmId(Long algorithmId) {
		this.algorithmId = algorithmId;
	}

	public String getPpdmAlgorithmName() {
		return ppdmAlgorithmName;
	}

	public void setPpdmAlgorithmName(String ppdmAlgorithmName) {
		this.ppdmAlgorithmName = ppdmAlgorithmName;
	}

	public String getPpdmTechniqueName() {
		return ppdmTechniqueName;
	}

	public void setPpdmTechniqueName(String ppdmTechniqueName) {
		this.ppdmTechniqueName = ppdmTechniqueName;
	}

	public String getHidingFailure() {
		return hidingFailure;
	}

	public void setHidingFailure(String hidingFailure) {
		this.hidingFailure = hidingFailure;
	}

	public String getMissingCost() {
		return missingCost;
	}

	public void setMissingCost(String missingCost) {
		this.missingCost = missingCost;
	}

	public String getArtificialCost() {
		return artificialCost;
	}

	public void setArtificialCost(String artificialCost) {
		this.artificialCost = artificialCost;
	}

	public String getDataDissimilarity() {
		return dataDissimilarity;
	}

	public void setDataDissimilarity(String dataDissimilarity) {
		this.dataDissimilarity = dataDissimilarity;
	}

	public String getOtherSideEffects() {
		return otherSideEffects;
	}

	public void setOtherSideEffects(String otherSideEffects) {
		this.otherSideEffects = otherSideEffects;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
