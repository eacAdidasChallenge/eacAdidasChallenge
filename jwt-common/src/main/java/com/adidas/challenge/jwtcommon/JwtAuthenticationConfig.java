package com.adidas.challenge.jwtcommon;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@ToString
public class JwtAuthenticationConfig {

    @Value("${adidas.security.jwt.url:/login}")
    private String url;

    @Value("${adidas.security.jwt.header:Authorization}")
    private String header;

    @Value("${adidas.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${adidas.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${adidas.security.jwt.secret}")
    private String secret;
}
