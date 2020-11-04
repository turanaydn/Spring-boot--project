package com.subscreasy.security;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.SpringSecurityMessageSource;

public class UnauthorizedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -82837955669416097L;
	protected static MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();
	
	public UnauthorizedException() {
		super(message.getMessage("AbstractAcessDecisionManager.accessDenied", "Access is denied"));
	}
	
	public UnauthorizedException(String message) {
		super(message);
	}

}
