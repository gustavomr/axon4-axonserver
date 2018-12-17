package com.giftcard.query.listener;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@AllArgsConstructor
public class RedeemedEvt implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1421957026785621851L;
	private final String id;
    private final Integer amount;

}
