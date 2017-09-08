package ru.quizful;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by lav on 27.02.2017.
 */
class MyAuthenticator extends Authenticator
{
    private String user;
    private String password;

    MyAuthenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        String user = this.user;
        String password = this.password;
        return new PasswordAuthentication(user, password);
    }
}