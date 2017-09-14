package com.ibs.pg.token.server.umf;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YQ.Huang
 */
@Api
@RequestMapping("/umf")
@RestController
public class UmfTokenController {

    private final UmfTokenService umfTokenService;

    @Autowired
    public UmfTokenController(UmfTokenService umfTokenService) {
        this.umfTokenService = umfTokenService;
    }

    @GetMapping("/tokens")
    public String getUmfToken() {
        return umfTokenService.get();
    }


}
