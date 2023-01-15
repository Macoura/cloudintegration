package test;
import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;


public class AccountService {
	@Autowired
	private MessagingTemplate messagingTemplate;

	public MyAccount myService(MyAccount myAccount){

		System.out.println(myAccount);
		MyAccount ma = new MyAccount();
		ma.setAmount(myAccount.getAmount() + 200);
		ma.setName(myAccount.getName());
		ma.setNumber(myAccount.getNumber());

		return ma;
		//myAccount.setAmount(myAccount.getAmount() + 200);
		//return myAccount;
	}



	public void addRecipient() {
		System.out.println("sdopfiuqgjhkldfmjhgqdbfhkjlkmoqiugyfjghklkmouiyofjhgklomiufydthgjcv");

		messagingTemplate.convertAndSend("controlBus", "@'customRouter.handler'.addRecipient('channel2')");

return;
	}

	public String log(String content) {
		System.out.println("sdopfiuqgjhkldfmjhgqdbfhkjlkmoqiugyfjghklkmouiyofjhgklomiufydthgjcv");
		return content;
	}

	@Override
	public String toString() {
		return "Chaine crée";
	}
}
