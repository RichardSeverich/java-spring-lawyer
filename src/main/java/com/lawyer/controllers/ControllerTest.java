package com.lawyer.controllers;

import com.lawyer.models.User;
import com.lawyer.responses.Response;
import com.lawyer.responses.ResponseBody;
import com.lawyer.support.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * RestController.
 */
@RestController
public class ControllerTest {


    /**
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.GET, value = "persona")
    public ResponseEntity<ArrayList> saludo() {
        Persona persona = new Persona();
        persona.setNombre("charly");
        persona.setEdad("20");
        Persona persona1 = new Persona();
        persona1.setNombre("charly");
        persona1.setEdad("20");
        Persona persona2 = new Persona();
        persona2.setNombre("charly");
        persona2.setEdad("20");
        Persona persona3 = new Persona();
        persona3.setNombre("charly");
        persona3.setEdad("20");
        Persona persona4 = new Persona();
        persona4.setNombre("charly");
        persona4.setEdad("20");
        Persona persona5 = new Persona();
        persona5.setNombre("charly");
        persona5.setEdad("20");
        ArrayList<Persona> arrayPersonas = new ArrayList<>();
        arrayPersonas.add(persona);
        arrayPersonas.add(persona1);
        arrayPersonas.add(persona2);
        arrayPersonas.add(persona3);
        arrayPersonas.add(persona4);
        arrayPersonas.add(persona5);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(arrayPersonas);
    }
}
