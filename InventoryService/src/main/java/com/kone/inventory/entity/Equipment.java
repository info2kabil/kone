/**
 * 
 */
package com.kone.inventory.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Equipment entity to have the equipment related information
 * @author Kabilan.selvaraj
 */
@Entity
@Table(name="EQUIPMENT")
@JsonSerialize
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipment {
	
	@Id
    @Column(name="equipment_number")
	@JsonProperty("equipmentNumber")
    private Long equipmentNumber;
     
    @Column(name="address")
    @JsonProperty("address")
    private String address;
     
    @Column(name="status")
    @JsonProperty("status")
    private String status;

    @Column(name="contract_start_date")
    @Temporal(TemporalType.DATE)
    @JsonProperty("contractStartDate")
    private Date contractStartDate;
    
    @Column(name="contract_end_date")
    @Temporal(TemporalType.DATE)
    @JsonProperty("contractEndDate")
    private Date contractEndDate;

	public Long getEquipmentNumber() {
		return equipmentNumber;
	}

	public void setEquipmentNumber(Long equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentNumber=" + equipmentNumber + ", address=" + address + ", status=" + status
				+ ", contractStartDate=" + contractStartDate + ", contractEndDate=" + contractEndDate + "]";
	}

}
