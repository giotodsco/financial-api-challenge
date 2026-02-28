package financial.dev.financial_api_challenge;

import financial.dev.financial_api_challenge.dtos.EstatisticaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EstatisticaProperties.class)
public class FinancialApiChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialApiChallengeApplication.class, args);
	}

}
