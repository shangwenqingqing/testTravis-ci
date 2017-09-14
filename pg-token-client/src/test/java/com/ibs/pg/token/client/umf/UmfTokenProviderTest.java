package com.ibs.pg.token.client.umf;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UmfTokenProviderTest {
    @Ignore
    @Test
    public void getToken() throws Exception {
        UmfTokenProvider provider = new UmfTokenProvider("http://localhost:9090");
        String token = provider.getToken();
        System.out.println("token = " + token);
        assertNotNull(token);
    }

}