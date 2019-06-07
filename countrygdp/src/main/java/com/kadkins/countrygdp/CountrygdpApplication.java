package com.kadkins.countrygdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CountrygdpApplication
{
    public static gdpList ourGdpList;

    public static void main(String[] args)
    {
        ourGdpList = new gdpList();
        SpringApplication.run(CountrygdpApplication.class, args);
    }

}
