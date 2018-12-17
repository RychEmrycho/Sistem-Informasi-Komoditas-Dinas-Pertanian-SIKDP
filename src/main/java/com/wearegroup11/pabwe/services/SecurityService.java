package com.wearegroup11.pabwe.services;

public interface SecurityService {
	
	String findLoggedInUsername();
	
	void autologin(String username, String password);

}
