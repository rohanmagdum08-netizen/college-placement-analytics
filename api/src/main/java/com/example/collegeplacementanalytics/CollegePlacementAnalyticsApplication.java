package com.example.collegeplacementanalytics;
import java.time.LocalDate;import org.springframework.boot.*;import org.springframework.boot.autoconfigure.*;import org.springframework.context.annotation.*;
@SpringBootApplication public class CollegePlacementAnalyticsApplication{
 public static void main(String[] args){SpringApplication.run(CollegePlacementAnalyticsApplication.class,args);}
 @Bean CommandLineRunner seed(ItemRepository r){return a->{if(r.count()==0){r.save(new Item("Complete Java assessment","Ishaan Kulkarni","In Progress",LocalDate.parse("2026-11-04"),"Backend","Working through collections and API sections."));r.save(new Item("Schedule mock interview","Neha Joshi","Open",LocalDate.parse("2026-11-03"),"Interview","Assign an interviewer and record feedback."));r.save(new Item("Resume review","Kabir Singh","Done",LocalDate.parse("2026-10-25"),"Career prep","Resume review completed by placement cell."));}};}
}
