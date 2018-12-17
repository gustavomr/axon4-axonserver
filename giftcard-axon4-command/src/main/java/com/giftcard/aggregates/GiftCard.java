package com.giftcard.aggregates;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.giftcard.command.IssueCmd;
import com.giftcard.command.RedeemCmd;
import com.giftcard.query.listener.IssuedEvt;
import com.giftcard.query.listener.RedeemedEvt;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Aggregate
@NoArgsConstructor
public class GiftCard {

    @AggregateIdentifier
    private String id;
    private int remainingValue;
    
    private final static Logger LOGGER = LoggerFactory.getLogger(GiftCard.class);

    @CommandHandler
    public GiftCard(IssueCmd cmd) {        
        if(cmd.getAmount() <= 0) throw new IllegalArgumentException("amount <= 0");
        apply(new IssuedEvt(cmd.getId(), cmd.getAmount())); 
        LOGGER.info("Done handling {} command: {}", cmd.getClass().getSimpleName(), cmd);
    }
    
    @EventSourcingHandler
    public void on(IssuedEvt evt) {
        id = evt.getId();
        this.remainingValue = evt.getAmount();
        LOGGER.info("Done handling {} event: {}", evt.getClass().getSimpleName(), evt);
    }
    
    @CommandHandler
    public void handle(RedeemCmd cmd) {
        if(cmd.getAmount() <= 0) throw new IllegalArgumentException("amount <= 0");
        if(cmd.getAmount() > remainingValue) throw new IllegalStateException("amount > remaining value");
        AggregateLifecycle.apply(new RedeemedEvt(id, cmd.getAmount()));
    }

    @EventSourcingHandler
    public void on(RedeemedEvt evt) {
        remainingValue -= evt.getAmount();
    }

   
}