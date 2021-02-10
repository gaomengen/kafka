package kafkaTest;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class kafkaTestClass {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
	      Properties config = new Properties();
	      config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-43n10.us-central1.gcp.confluent.cloud:9092");
	      config.put("security.protocol", "SASL_SSL");
	      config.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule   required username='4QJTMSOKOLAWDV23'   password='pj0yj1KaSpeJ4wPOeVME/Ne1NgTdFExn5kyWk7x+2rjuh0rX4GrA/F/Jy/DhvRqu';");
	      config.put("sasl.mechanism", "PLAIN");
	      config.put("client.dns.lookup", "use_all_dns_ips");
	      config.put("acks", "all");
	      System.out.println(config);
	      AdminClient admin = AdminClient.create(config);
	      //creating new topic
	      System.out.println("-- creating --");
	      NewTopic newTopic = new NewTopic("test-my-new-topic-1", 6, (short) 3);
	      System.out.println(newTopic);
	      CreateTopicsResult result = admin.createTopics(Collections.singleton(newTopic));
	      System.out.println(result.all().get());

	      //listing
	      System.out.println("-- listing --");
	      admin.listTopics().names().get().forEach(System.out::println);
	  }
}
