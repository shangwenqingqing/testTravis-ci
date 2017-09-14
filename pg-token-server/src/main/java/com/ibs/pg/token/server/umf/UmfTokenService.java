package com.ibs.pg.token.server.umf;

import cn.payingcloud.umf.UmfClient;
import cn.payingcloud.umf.UmfProfile;
import cn.payingcloud.umf.model.AccessToken;
import org.slf4j.Logger;

import java.time.Instant;
import java.util.Date;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author YQ.Huang
 */
public class UmfTokenService {
    private static final Logger LOGGER = getLogger(UmfTokenService.class);
    private final UmfProfile profile;
    private final String clientId;
    private final String clientSecret;
    private AccessToken token;
    private Date expireTime;

    public UmfTokenService(UmfProfile profile, String clientId, String clientSecret) {
        this.profile = profile;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public synchronized String get() {
        try {
            if (expired()) {
                LOGGER.info("Getting umf token");
                token = UmfClient.getAccessToken(profile, clientId, clientSecret);
                expireTime = Date.from(Instant.now().plusSeconds(token.getExpiresIn()));
                LOGGER.info("Umf token has been got");
            }
        } catch (Exception e) {
            LOGGER.error("Failed to get umf token", e);
        }
        return token.getAccessToken();
    }

    private boolean expired() {
        LOGGER.info("Checking if umf token has expired");
        boolean expired = token == null || expireTime.before(new Date());
        LOGGER.info("Umf token has expired? " + (expired ? "YES" : "NO"));
        return expired;
    }
}