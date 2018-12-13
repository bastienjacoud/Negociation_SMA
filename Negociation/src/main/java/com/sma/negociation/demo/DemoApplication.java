package com.sma.negociation.demo;

import com.sma.negociation.demo.regles.Concession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        Concession c = new Concession();
        System.out.println(c.getSomme());
    }
}
