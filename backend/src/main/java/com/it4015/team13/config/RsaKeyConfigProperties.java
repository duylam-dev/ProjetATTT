package com.it4015.team13.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
@Getter
@Setter
public class RsaKeyConfigProperties {
    @Value("${rsa.publicKey}")
    private RSAPublicKey publicKey;
    @Value("${rsa.privateKey}")
    private RSAPrivateKey privateKey;
}