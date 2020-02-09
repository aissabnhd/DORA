package fr.ajaate.dora.service;

public interface SecurityService {
    String findLoggedInUsername();

    String autoLogin(String username, String password);
}
