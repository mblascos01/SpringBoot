package com.restService.restService.Controladores;

import java.util.concurrent.atomic.AtomicLong;

import com.restService.restService.Modelos.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorGreeting {

    private static final String template = "¡Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "Mundo") String nombre) {
        return new Greeting(counter.incrementAndGet(), template.formatted(nombre));
    }
}