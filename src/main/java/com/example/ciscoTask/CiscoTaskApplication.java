package com.example.ciscoTask;

import com.example.ciscoTask.model.CaseTicket;
import com.example.ciscoTask.repository.CaseTicketRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class CiscoTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CiscoTaskApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CaseTicketRepo caseTicketRepo) {
        return args -> {
            CaseTicket ticket = new CaseTicket("Problem", "bardzo trudny problem", "high", "new");
            caseTicketRepo.save(ticket);
            CaseTicket ticket2 = new CaseTicket("Problem2", "sredni problem", "medium", "in progress");
            caseTicketRepo.save(ticket2);
            CaseTicket ticket3 = new CaseTicket("Problem3", "latwy problem", "low", "in progress");
            caseTicketRepo.save(ticket3);
        };
    }

}
