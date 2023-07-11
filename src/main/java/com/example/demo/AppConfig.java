package com.example.demo;

import org.springframework.context.annotation.*;
import org.springframework.vault.authentication.*;
import org.springframework.vault.client.*;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
class AppConfig extends AbstractVaultConfiguration {

    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.create("sample-cluster-public-vault-0cb20178.85318a53.z1.hashicorp.cloud", 8200);
    }

    @Override
    public ClientAuthentication clientAuthentication() {

        AppRoleAuthenticationOptions options = AppRoleAuthenticationOptions.builder()
                .appRole("admin")
                .roleId(AppRoleAuthenticationOptions.RoleId.provided("b0954318-92de-851c-c1b2-11d7ad23ca57"))
                .secretId(AppRoleAuthenticationOptions.SecretId.provided("5d70cc38-84de-4486-161d-2fa1273dec52"))
                //.secretId(AppRoleAuthenticationOptions.SecretId.wrapped(VaultToken.of("5d70cc38-84de-4486-161d" +
                // "-2fa1273dec52")))
                //.secretId(AppRoleAuthenticationOptions.SecretId.pull("5d70cc38-84de-4486-161d-2fa1273dec52"))
                .build();
        return new AppRoleAuthentication(options, restOperations());


//        return new TokenAuthentication("hvs.CAESIJztDFG9GOgcQidsJKmhILGifCwR4BvTeDUugM4SJofbGicKImh2cy5ENjFNSDBuSkJyMHB4R3JnMW03NHZsd0kuZjBUbjUQzxs");
    }

    //    public RestOperations restOperations() {
//        RestTemplate restTemplate = VaultClients.createRestTemplate(vaultEndpointProvider(),
//                clientHttpRequestFactoryWrapper().getClientHttpRequestFactory());
//
//        restTemplate.getInterceptors().add((request, body, execution) -> {
//            request.getHeaders().add("X-Vault-Namespace", "admin");
//            return execution.execute(request, body);
//        });
//        return restTemplate;
//    }
//Found this solution here: https://github.com/spring-projects/spring-vault/issues/316
    @Bean
    public RestTemplateCustomizer forwardNamespaces() {
        return (restTemplate) -> {
            restTemplate.getInterceptors().add(VaultClients.createNamespaceInterceptor("admin"));
        };
    }


}
