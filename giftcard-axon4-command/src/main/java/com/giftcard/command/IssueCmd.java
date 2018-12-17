package com.giftcard.command;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter  
@ToString
@AllArgsConstructor
public class IssueCmd {

	@TargetAggregateIdentifier
	private  String id;
	private  Integer amount;
	
}
