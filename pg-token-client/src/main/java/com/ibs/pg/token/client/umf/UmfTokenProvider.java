package com.ibs.pg.token.client.umf;

import cn.payingcloud.umf.TokenProvider;
import org.springframework.web.client.RestTemplate;

public class UmfTokenProvider implements TokenProvider {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private final String baseUrl;

    public UmfTokenProvider(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getToken() {
        return REST_TEMPLATE.getForObject(baseUrl + "/umf/tokens", String.class);
    }
}
