package fr.ajaate.dora.services;

import java.util.List;

public interface SecurityService {


    List<String> Login(String email, String password);
}
