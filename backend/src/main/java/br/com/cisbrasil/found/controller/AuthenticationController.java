package br.com.cisbrasil.found.controller;

import br.com.cisbrasil.found.data.request.LoginRequest;
import br.com.cisbrasil.found.data.response.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest request){
        return new ResponseEntity<>(
                new WebResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Successfully signed in!"), HttpStatus.OK
        );
    }
}
