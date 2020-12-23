package com.example.mail_server.Model.Sort.SortText;

import com.example.mail_server.Model.Mail;

public class SortWithSubject extends SortText {
    @Override
    String getStringAttribute(Mail mail) {
        return mail.getSubject();
    }
}