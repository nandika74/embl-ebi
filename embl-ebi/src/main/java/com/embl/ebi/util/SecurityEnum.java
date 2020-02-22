/**
 * 
 */
package com.embl.ebi.util;

/**
 * Enum for security parameters (user type, username and password)
 * 
 * @author A1855
 *
 */
public enum SecurityEnum {
	USER("USER", "user", "user123"), ADMIN("ADMIN", "admin", "admin123");	
	
	private String userType;
	
	private String userName;
	
	private String password;
	
	SecurityEnum(String userType, String userName, String password) {
		this.userType = userType;
		this.userName = userName;
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
