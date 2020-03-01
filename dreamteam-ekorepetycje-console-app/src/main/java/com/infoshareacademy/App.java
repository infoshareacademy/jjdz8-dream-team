package com.infoshareacademy;

import com.infoshareacademy.hasing.PasswordCoding;
import com.infoshareacademy.menu.MenuService;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.MessageDigest;

public class App {
    public static void main(String[] args) {
        MenuService service = new MenuService();
        service.appStart();

    }



}
