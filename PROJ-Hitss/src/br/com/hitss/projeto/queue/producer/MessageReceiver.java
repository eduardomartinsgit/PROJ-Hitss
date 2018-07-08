package br.com.hitss.projeto.queue.producer;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.hitss.projeto.dao.ProdutoDAO;
import br.com.hitss.projeto.model.CompraVO;
 
@Component
public class MessageReceiver {
    static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);
 
    @Autowired
    private ProdutoDAO produtoDAO;
    
    private static final String QUEUE_COMPRAR_PRODUTO = "FL.HITSS.COMPRAR.PRODUTO";
    
    @JmsListener(destination = QUEUE_COMPRAR_PRODUTO)
    public void receberMensagemCompra(final CompraVO compra) throws JMSException {
    	produtoDAO.comprarProduto(compra);
    }    
}
