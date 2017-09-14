package com.ibs.pg.token.server.config;

import cn.payingcloud.umf.UmfProfile;
import com.ibs.pg.token.server.umf.UmfTokenService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author YQ.Huang
 */
@Configuration
@EnableConfigurationProperties(UmfConfig.UmfProperties.class)
public class UmfConfig {
    private final UmfProperties umf;

    public UmfConfig(UmfProperties umf) {
        this.umf = umf;
    }

    @Bean
    UmfTokenService umfTokenService() {
        return new UmfTokenService(umf.getProfile(), umf.getClientId(), umf.getClientSecret());
    }

    @Validated
    @ConfigurationProperties(prefix = "umf")
    public static class UmfProperties {
        @NotNull
        private UmfProfile profile;
        @NotBlank
        private String clientId;
        @NotBlank
        private String clientSecret;

        public UmfProfile getProfile() {
            return profile;
        }

        public void setProfile(UmfProfile profile) {
            this.profile = profile;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }

    }
}
