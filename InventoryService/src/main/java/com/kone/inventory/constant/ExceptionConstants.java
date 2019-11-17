/**
 * 
 */
package com.kone.inventory.constant;

/**
 * To have the exception constant values
 * @author Kabilan.selvaraj
 */
public class ExceptionConstants {
	
	private ExceptionConstants() {
		// To avoid object creation from outside
	}
	
	public static final String EXCEPTION_VALID_LIMIT = "Please select a valid limit, it should be greater than 0";
	public static final String EXCEPTION_VALID_EQUIP_NO = "Please select a valid equipment number, it should be greater than 0";
    public static final String EXCEPTION_EQUIPMENT_NON_FOUND = "Requested equipment number not avilable in the inventory";
    public static final String EXCEPTION_EQUIPMENT_EXISTS = "Requested equipment number already avilable in the inventory";
    
}
