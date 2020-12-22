package com.example.mail_server.Controller;

import com.example.mail_server.Model.Account.Account;
import com.example.mail_server.Model.Mail;
import com.example.mail_server.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.LinkedList;

@Configuration
@Deprecated
class MyConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedHeaders("*");
            }
        };
    }

}
@RestController
@CrossOrigin
public class controller {
    private User user;


    public controller(){
        user = User.getInstance();
    }
    @CrossOrigin
    @PostMapping("/compose")
    public boolean compose(@RequestBody Mail mail) throws IOException {
        System.out.println(mail.getBody());
        return user.Compose(mail);
    }

    @CrossOrigin
    @RequestMapping("/createAccount")
    @ResponseBody
    public boolean createAccount(@RequestParam (value = "name") String name, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) throws IOException {
        return user.signUp(name, email, password);
    }
    @CrossOrigin
    @RequestMapping("/signIn")
    @ResponseBody
    public boolean signIn( @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) throws IOException {
        return user.signIn(email, password);
    }

    @CrossOrigin
    @RequestMapping("/getMails")
    @ResponseBody
    public LinkedList<Mail> getListMails(@RequestParam(value = "folderName") String folderName,@RequestParam(value = "sort")String sort) throws IOException {
        Account acc = user.getCurrentUser();
        //n7awwel l array ?
        return acc.loadFolder(folderName,sort);
    }

    @CrossOrigin
    @RequestMapping("/filter")
    @ResponseBody
    public LinkedList<Mail> getFilteredMails(@RequestParam(value = "sender") String senderField,@RequestParam(value = "subject") String subjectField) {
      LinkedList<Mail> mails= user.filter(senderField,subjectField);

        return mails;
    }
}
