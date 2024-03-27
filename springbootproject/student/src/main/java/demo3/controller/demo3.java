package demo3.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/demo3")
public class demo3 {
 @GetMapping("/hello")
 public String demo() {
	 return "rajkumar";
 }
}