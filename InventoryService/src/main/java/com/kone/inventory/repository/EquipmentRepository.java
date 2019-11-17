/**
 * 
 */
package com.kone.inventory.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kone.inventory.entity.Equipment;

/**
 * Repository class for the Equipment entity
 * @author Kabilan.selvaraj
 */
@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{

	@Query("select equip from Equipment equip")
	List<Equipment> getEquipments(Pageable pageable);
	
}
