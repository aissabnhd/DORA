package fr.ajaate.dora.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}