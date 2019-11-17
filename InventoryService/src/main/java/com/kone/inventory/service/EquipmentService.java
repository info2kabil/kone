/**
 * 
 */
package com.kone.inventory.service;

import java.util.List;
import java.util.Optional;

import com.kone.inventory.entity.Equipment;

/**
 * Interface to perform the equipment service related operation
 * @author Kabilan.selvaraj
 */
public interface EquipmentService {
	
	/**
	 * To get the first N number of elements
	 * @param limit
	 * @return
	 */
	List<Equipment> getEquipments(int limit);
	
	/**
	 * To get the particular equipment details
	 * @param equipmentNo
	 * @return
	 */
	Optional<Equipment> getEquipment(Long equipmentNo);
	
	/**
	 * To create the new equipment details
	 * @param equipment
	 */
	void createEquipment(Equipment equipment);
	
}
