package com.application.administration.core.shared.infrastructure.web3;

import com.application.administration.core.shared.infrastructure.config.Parameter;
import com.application.administration.core.shared.infrastructure.config.ParameterNotExist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class Web3Configuration {

    private final Parameter config;

    public Web3Configuration(Parameter config) {
        this.config = config;
    }

    @Bean
    Web3j web3j() throws ParameterNotExist {
        return Web3j.build(new HttpService(config.get("NODE_URL")));
    }
}
