package com.solace.samples.spring.boot;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import org.springframework.jndi.JndiTemplate;

import com.solacesystems.jms.SolConnectionFactory;
import com.solacesystems.jms.SolJmsUtility;

@Configuration
public class BeanConfig {
	
	//org.springframework.jndi.JndiTemplate
	/*
	 * @Bean public JndiTemplate jndiTemplate() throws Exception {
	 * 
	 * JndiTemplate obj = new JndiTemplate(); obj.setEnvironment(new hashMap());
	 * 
	 * return null; }
	 * 
	 * solace.jms.host=tcp://mr-q3v1t7qzczs.messaging.solace.cloud:55555
solace.jms.msgVpn=solacemadhur
solace.jms.clientUsername=solace-cloud-client
solace.jms.clientPassword=5tadvvi79uusj9aq6un640765r
	 */
	@Autowired
	SolConnectionFactory solConnectionFactory;
	
	@Autowired
	ConnectionFactory connectionFactory;
	
	@Bean
    public SolConnectionFactory solConnectionFactory() throws Exception {
        SolConnectionFactory connectionFactory = SolJmsUtility.createConnectionFactory();
        
        
		
		//JmsConnectionFactory connectionFactory = SolJmsUtility.createConnectionFactory();
        //JmsListenerContainerFactory obj = new JmsListenerContainerFactory();
		/*
		 * SimpleJmsListenerContainerFactory factory1 = new
		 * SimpleJmsListenerContainerFactory();
		 * factory1.setConnectionFactory(connectionFactory);
		 * factory1.setPubSubDomain(Boolean.TRUE); JmsListenerContainerFactory obj =
		 * factory1;
		 */ 
        
        
        connectionFactory.setHost("tcp://mr-q3v1t7qzczs.messaging.solace.cloud:55555");
        connectionFactory.setVPN("solacemadhur");
        connectionFactory.setUsername("solace-cloud-client");
        connectionFactory.setPassword("5tadvvi79uusj9aq6un640765r");
        connectionFactory.setClientID("Test");
        connectionFactory.setDirectTransport(false);
        
        //DefaultMessageListenerContainer ob = new DefaultMessageListenerContainer();
        //ob.setDestination(dynamicDestinationResolver());
        return connectionFactory;
    }
	
	//org.springframework.jms.support.destination.DynamicDestinationResolver
	/*
	 * @Bean public DynamicDestinationResolver dynamicDestinationResolver() {
	 * DynamicDestinationResolver ob = new DynamicDestinationResolver(); return ob;
	 * }
	 * 
	 * @Bean public JmsListenerContainerFactory jmsListenerContainerFactory() {
	 * SimpleJmsListenerContainerFactory factory1 = new
	 * SimpleJmsListenerContainerFactory(); JmsListenerContainerFactory ob = new
	 * JmsListenerContainerFactory();
	 * factory1.setConnectionFactory(solConnectionFactory);
	 * factory1.setPubSubDomain(false); // JmsListenerContainerFactory obj =
	 * factory1;
	 * 
	 * return factory1; }
	 */
	
	/*
	 * @Bean public JmsListenerContainerFactory<?>
	 * myFactory(DefaultJmsListenerContainerFactoryConfigurer configurer) throws
	 * Exception { DefaultJmsListenerContainerFactory factory = new
	 * DefaultJmsListenerContainerFactory();
	 * 
	 * // setSSLProperties();
	 * 
	 * configurer.configure(factory,solConnectionFactory());
	 * 
	 * return factory; }
	 */


}
