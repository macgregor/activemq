package org.apache.activemq.broker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProducerBrokerExchangeTest {

    @Test
    public void testGetPercentageBlockedHandlesDivideByZero(){
        ProducerBrokerExchange producerBrokerExchange = new ProducerBrokerExchange();
        producerBrokerExchange.incrementSend();
        producerBrokerExchange.getPercentageBlocked();
    }

    @Test
    public void testGetPercentageBlockedNonZero(){
        ProducerBrokerExchange producerBrokerExchange = new ProducerBrokerExchange();
        producerBrokerExchange.blockingOnFlowControl(true);
        producerBrokerExchange.incrementSend();
        assertEquals(100.0, producerBrokerExchange.getPercentageBlocked(), 0);
    }
}
