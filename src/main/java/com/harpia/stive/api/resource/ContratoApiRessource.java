package com.harpia.stive.api.resource;

import com.harpia.stive.api.contrato.ContratoApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"govbr"})
public class ContratoApiRessource {

    @GetMapping({"/contrato"})
    public ResponseEntity<ContratoApiRessource> contratoAPI() {
        ContratoApi contrato = new ContratoApi();
        return new ResponseEntity(contrato.contratoApi(), HttpStatus.OK);
    }
}
