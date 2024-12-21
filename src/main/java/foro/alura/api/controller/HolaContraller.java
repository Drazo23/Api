package foro.alura.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class HolaContraller {

    @GetMapping
    public String holaMundo(){
        return "Hola Mundo";
    }
}
