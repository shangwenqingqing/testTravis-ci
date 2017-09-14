package cn.payingcloud.clientdemo.controller;


import cn.payingcloud.clientdemo.util.TokenProv;
import cn.payingcloud.umf.TokenProvider;
import cn.payingcloud.umf.UmfClient;
import cn.payingcloud.umf.UmfProfile;
import cn.payingcloud.umf.util.CertUtils;
import cn.payingcloud.umf.util.StreamUtils;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class Constant {
    static final UmfProfile PROFILE = UmfProfile.ASIA_TEST;
    static final String CLIENT_ID = "383e1d786cad37cbe4c5fd926aef09b546479f62";
    ;
    static final String CLIENT_SECRET = "58f3f567fe7d973c08417a1edc6dbe238cd71246";
    static final TokenProvider TOKEN_PROVIDER = new TokenProv(PROFILE, CLIENT_ID, CLIENT_SECRET);
    static final PrivateKey PRIVATE_KEY = CertUtils.loadRsaPrivateKey(StreamUtils.loadResource("/6260_.key.p8"));
    static final X509Certificate CERTIFICATE = CertUtils.loadX509Certificate(StreamUtils.loadResource("/umpay.cert.crt"));
    static final UmfClient UMF_CLIENT = new UmfClient(PROFILE, PRIVATE_KEY, CERTIFICATE, TOKEN_PROVIDER);
}
