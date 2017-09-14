package cn.payingcloud.clientdemo.util;

import cn.payingcloud.umf.TokenProvider;
import cn.payingcloud.umf.UmfClient;
import cn.payingcloud.umf.UmfProfile;
import cn.payingcloud.umf.model.AccessToken;

public class TokenProv implements TokenProvider {
    private UmfProfile profile;
    private String clientId;
    private String clientSecret;

    @Override
    public  String getToken(){
        AccessToken accessToken = UmfClient.getAccessToken(profile, clientId, clientSecret);
        return accessToken.getAccessToken();
    }

    public TokenProv(UmfProfile profile, String clientId, String clientSecret) {
        this.profile = profile;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
}
