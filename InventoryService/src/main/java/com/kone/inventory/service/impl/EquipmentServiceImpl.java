/**
 * 
 */
package com.kone.inventory.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kone.inventory.entity.Equipment;
import com.kone.inventory.repository.EquipmentRepository;
import com.kone.inventory.service.EquipmentService;

/**
 * Service class to perform the equipment related operation
 * @author Kabilan.selvaraj
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	EquipmentRepository equipmentRepository;
	
	@Override
	public List<Equipment> getEquipments(int limit) {
		return equipmentRepository.getEquipments(PageRequest.of(0, limit, Sort.unsorted()));
	}

	@Override
	public Optional<Equipment> getEquipment(Long equipmentNo) {
		return equipmentRepository.findById(equipmentNo);
	}

	@Override
	public void createEquipment(Equipment equipment) {
		equipmentRepository.save(equipment);
	}

}
