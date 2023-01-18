package br.com.lfmelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

public class ListenerApplication {

    @Autowired
    private JmsTemplate jmsTemplate;

    private void sendMessageToQueue (String message){
        try{
            jmsTemplate.convertAndSend("queue-name", message);
        }catch (Exception e){
            throw e;
        }
    }

    @JmsListener(destination = "queue-name")
    public void listener(String message) throws Exception{
        try {
            System.out.println();
        }catch (Exception e){
            throw e;
        }
    }
}
