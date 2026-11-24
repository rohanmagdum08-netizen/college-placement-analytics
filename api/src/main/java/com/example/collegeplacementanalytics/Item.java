package com.example.collegeplacementanalytics;
import java.time.LocalDate;import jakarta.persistence.*;
@Entity public class Item{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String title,owner,status;private LocalDate dueDate;private String category;
 @Column(length=2000) private String description;
 protected Item(){}
 public Item(String t,String o,String s,LocalDate d,String c,String x){title=t;owner=o;status=s;dueDate=d;category=c;description=x;}
 public Long getId(){return id;}public void setId(Long v){id=v;}
 public String getTitle(){return title;}public void setTitle(String v){title=v;}
 public String getOwner(){return owner;}public void setOwner(String v){owner=v;}
 public String getStatus(){return status;}public void setStatus(String v){status=v;}
 public LocalDate getDueDate(){return dueDate;}public void setDueDate(LocalDate v){dueDate=v;}
 public String getCategory(){return category;}public void setCategory(String v){category=v;}
 public String getDescription(){return description;}public void setDescription(String v){description=v;}
}
