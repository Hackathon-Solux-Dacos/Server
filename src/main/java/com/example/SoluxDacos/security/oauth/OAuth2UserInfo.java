package com.example.SoluxDacos.security.oauth;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getName();
}