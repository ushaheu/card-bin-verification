package com.digital.bank.verification;

import com.digital.bank.verification.kafka.Producer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ushaheu
 * @date 8/27/20 1:32 AM
 * @project card-bin-verification
 */
@Configuration
@EnableBinding(Producer.class)
public class CardBinVerificationConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("BIN Verification API Specification")
                        .version("1.0")
                        .description("Card Bin Verification")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
