package com.example.demo;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.vault.authentication.*;
import org.springframework.vault.client.*;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.web.client.RestTemplate;

public class NamespaceScopedVaultTemplate extends VaultTemplate {

    private final String namespace;

    public NamespaceScopedVaultTemplate(VaultEndpoint vaultEndpoint,
                                        ClientAuthentication clientAuthentication, String namespace) {
        super(vaultEndpoint, clientAuthentication);
        this.namespace = namespace;
    }

    public NamespaceScopedVaultTemplate(VaultEndpoint vaultEndpoint,
                                        ClientHttpRequestFactory clientHttpRequestFactory,
                                        SessionManager sessionManager, String namespace) {
        super(vaultEndpoint, clientHttpRequestFactory, sessionManager);
        this.namespace = namespace;
    }

    public NamespaceScopedVaultTemplate(VaultEndpointProvider endpointProvider,
                                        ClientHttpRequestFactory requestFactory, SessionManager sessionManager,
                                        String namespace) {
        super(endpointProvider, requestFactory, sessionManager);
        this.namespace = namespace;
    }

    /**
     * Associate namespace interceptor that adds the namespace header to each Vault
     * request.
     *
     * @param endpointProvider must not be {@literal null}.
     * @param requestFactory must not be {@literal null}.
     * @return
     */
    @Override
    protected RestTemplate doCreateRestTemplate(VaultEndpointProvider endpointProvider,
                                                ClientHttpRequestFactory requestFactory) {

        RestTemplate restTemplate = super.doCreateRestTemplate(endpointProvider,
                requestFactory);

        restTemplate.getInterceptors().add((request, body, execution) -> {

            request.getHeaders().add("X-Vault-Namespace", namespace);

            return execution.execute(request, body);
        });

        return restTemplate;
    }
}