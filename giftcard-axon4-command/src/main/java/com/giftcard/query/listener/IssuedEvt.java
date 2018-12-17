package com.giftcard.query.listener;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class IssuedEvt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -435719124148593579L;
	private final String id;
    private final Integer amount;

}
