package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String template2 = "Hi, %s!";

    private final AtomicLong counter = new AtomicLong();

    private final AtomicLong counter2 = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        if(name.equals("masabun")){
        	return new Greeting(counter2.incrementAndGet(),
                    String.format(template2, name));
        } else {
        	return new Greeting(counter.incrementAndGet(),
        			String.format(template, name));
        }
    }
}