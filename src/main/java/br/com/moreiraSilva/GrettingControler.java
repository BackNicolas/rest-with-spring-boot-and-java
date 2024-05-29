package br.com.moreiraSilva;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GrettingControler {
	private static final String template = "Hello, %s!";
	private AtomicLong counter = new AtomicLong();
	
	@GetMapping("/gretting")
	public Gretting gretting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Gretting(counter.incrementAndGet(), String.format(template, name));
	}
}
