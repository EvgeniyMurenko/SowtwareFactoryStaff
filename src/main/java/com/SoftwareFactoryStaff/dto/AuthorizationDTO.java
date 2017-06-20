package com.SoftwareFactoryStaff.dto;



public class AuthorizationDTO {

    public AuthorizationDTO(){}

    public AuthorizationDTO(String ssoId, String password, String googleCloudKey) {
        this.ssoId = ssoId;
        this.password = password;
        this.googleCloudKey = googleCloudKey;
    }

    private String ssoId;

    private String password;

    private String googleCloudKey;

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGoogleCloudKey() {
        return googleCloudKey;
    }

    public void setGoogleCloudKey(String googleCloudKey) {
        googleCloudKey = googleCloudKey;
    }
}
