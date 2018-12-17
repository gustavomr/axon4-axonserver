package com.giftcard.command;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter  
@ToString
@AllArgsConstructor
public class RedeemCmd {
	
	@TargetAggregateIdentifier
	@NonNull
    private final String id;
	@NonNull
    private final Integer amount;

}
