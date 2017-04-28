package ru.itis.sw.hospital.models;

/**
 * Created by katemrrr on 26.04.17.
 */
public class TokenObject {

    private String token;

    private int status;

    public TokenObject(String token, int status) {
        this.token = token;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
