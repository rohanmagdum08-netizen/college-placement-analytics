package com.example.collegeplacementanalytics;
import java.time.LocalDate;import java.util.*;import org.springframework.data.domain.Sort;import org.springframework.http.HttpStatus;import org.springframework.security.access.prepost.PreAuthorize;import org.springframework.web.bind.annotation.*;import org.springframework.web.server.ResponseStatusException;
@RestController @RequestMapping("/api") public class ItemController{
 private final ItemRepository r;public ItemController(ItemRepository r){this.r=r;}
 @GetMapping("/items") public List<Item> all(){return r.findAll(Sort.by(Sort.Direction.DESC,"id"));}
 @PostMapping("/items") @PreAuthorize("hasRole('ADMIN')") public Item add(@RequestBody Item x){x.setId(null);return r.save(x);}
 @PutMapping("/items/{id}") @PreAuthorize("hasRole('ADMIN')") public Item edit(@PathVariable Long id,@RequestBody Item x){Item i=r.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));i.setTitle(x.getTitle());i.setOwner(x.getOwner());i.setStatus(x.getStatus());i.setDueDate(x.getDueDate());i.setCategory(x.getCategory());i.setDescription(x.getDescription());return r.save(i);}
 @DeleteMapping("/items/{id}") @PreAuthorize("hasRole('ADMIN')") public void delete(@PathVariable Long id){if(!r.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND);r.deleteById(id);}
 @GetMapping("/dashboard") public Map<String,Object> dash(){List<Item>a=r.findAll();long open=a.stream().filter(i->!"Done".equalsIgnoreCase(i.getStatus())).count();long late=a.stream().filter(i->i.getDueDate()!=null&&i.getDueDate().isBefore(LocalDate.now())&&!"Done".equalsIgnoreCase(i.getStatus())).count();Map<String,Object>m=new LinkedHashMap<>();m.put("total",a.size());m.put("open",open);m.put("done",a.size()-open);m.put("overdue",late);return m;}
 @GetMapping("/notifications") public List<Item> notices(){LocalDate d=LocalDate.now().plusDays(7);return r.findAll().stream().filter(i->!"Done".equalsIgnoreCase(i.getStatus())).filter(i->i.getDueDate()!=null&&!i.getDueDate().isAfter(d)).toList();}
 @GetMapping("/reports") public Map<String,Long> report(){Map<String,Long>m=new LinkedHashMap<>();for(String s:List.of("Open","In Progress","Done"))m.put(s,r.countByStatus(s));return m;}
}
