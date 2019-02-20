package nl.rabobank.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

	private final Counter counter;

	public Endpoint(MeterRegistry registry) {

		counter = registry.counter("pep-hit");
	}

	@GetMapping("/hello")
	public String hell() {
		if (Math.random() < 0.5) {
			counter.increment();
		}

		return "Hello world";
	}
}
