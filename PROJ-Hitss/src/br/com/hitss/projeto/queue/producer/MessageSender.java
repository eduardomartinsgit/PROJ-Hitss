package br.com.hitss.projeto.queue.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import br.com.hitss.projeto.model.ProdutoVO;
 
 
@Component
public class MessageSender {
 
    @Autowired
    JmsTemplate jmsTemplate;
 
    public void sendMessage(final ProdutoVO produto) {
 
        jmsTemplate.send(new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage(produto);
                    return objectMessage;
                }
            });
    }
 
}