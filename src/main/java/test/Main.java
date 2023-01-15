package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.endpoint.EventDrivenConsumer;
import org.springframework.integration.router.RecipientListRouter;
import org.springframework.messaging.*;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Map;

@SpringBootApplication
public class Main {

	private static MessagingTemplate messagingTemplate;

	public static void addRecipient(String channel) {
			messagingTemplate.convertAndSend("controlBus", "@'customRouter.handler'.addRecipient('"+channel+"')");
	}

	public static void main(String[] args) throws ReflectionException, MalformedObjectNameException, AttributeNotFoundException, InstanceNotFoundException, MBeanException {

		// ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		//ApplicationContext = new ClassPathXmlApplicationContext("serviceActivator.xml");

		//ApplicationContext ctx = new ClassPathXmlApplicationContext("routing.xml");

		//ApplicationContext ctx = new ClassPathXmlApplicationContext("Transformation64.xml");
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("routing.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Police.xml");
		//addRecipient("channel2");

		/*
		ApplicationContext ctx = new ClassPathXmlApplicationContext("javaScriptService.xml");

		MyGateway myGateway= (MyGateway)ctx.getBean("gateWayService");
		myGateway.method("Salut !");
		*/


		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("webServiceCalling.xml");

		MyGateway myGateway= (MyGateway)ctx.getBean("gateWayService");
		myGateway.method("Salut !");*/



		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("database.xml");

		PersonService personService = ctx.getBean(PersonService.class);
		
		Person person = new Person();
		person.setName("Tintin");
		person = personService.createPerson(person);

		System.out.println(person);*/

		SubscribableChannel channel = ctx.getBean("outChannel", SubscribableChannel.class);
		channel.subscribe(message -> System.out.println("Police ! QUI EST TU ? JE SUIS " + message.getPayload()));

		//.subscribe(new MessageHandler());
	}
}
 