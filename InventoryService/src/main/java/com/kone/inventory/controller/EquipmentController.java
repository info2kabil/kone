package com.kone.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kone.inventory.constant.ExceptionConstants;
import com.kone.inventory.entity.Equipment;
import com.kone.inventory.service.EquipmentService;

/**
 * Controller class to perform inventory service related operation
 * @author Kabilan.Selvaraj
 */
@RestController
@RequestMapping("equipment/")
public class EquipmentController {

	private static Logger logger = LoggerFactory.getLogger(EquipmentController.class);
	
	@Autowired
	EquipmentService equipmentService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("search")
	public ResponseEntity<List<Equipment>> getEquipments(@RequestParam("limit") int limit) throws Exception {
		
		logger.info("Getting the first " + limit + " equipments");
		if (limit <= 0) {
			return new ResponseEntity(ExceptionConstants.EXCEPTION_VALID_LIMIT, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(equipmentService.getEquipments(limit), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("{equipmentNumber}")
	public ResponseEntity<Equipment> getEquipmentByNo(@PathVariable("equipmentNumber") Long equipmentNo) throws Exception {
		
		logger.info("Getting the equipments details for equipment no - " + equipmentNo);
		if (equipmentNo <= 0) {
			return new ResponseEntity(ExceptionConstants.EXCEPTION_VALID_EQUIP_NO, HttpStatus.BAD_REQUEST);
		}
		Optional<Equipment> equipment = equipmentService.getEquipment(equipmentNo);
		return new ResponseEntity(equipment.isPresent() ?
				equipment.get() : ExceptionConstants.EXCEPTION_EQUIPMENT_NON_FOUND, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping()
	public ResponseEntity<Equipment> saveEquipment(@RequestBody Equipment equipment) throws Exception {
		
		logger.info("Storing the equipments details for equipment no - " + equipment.getEquipmentNumber());
		if (equipmentService.getEquipment(equipment.getEquipmentNumber()).isPresent()) {
			return new ResponseEntity(ExceptionConstants.EXCEPTION_EQUIPMENT_EXISTS, HttpStatus.BAD_REQUEST);
		} else {
			equipmentService.createEquipment(equipment);
			return new ResponseEntity("Equipment details saved successfully", HttpStatus.OK);
		}
	}
}
