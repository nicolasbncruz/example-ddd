package pe.bk.appcambista.adapter.in.apis.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.bk.appcambista.adapter.in.apis.rest.model.AuthenticateRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.AuthenticationResponse;

@RequestMapping("/api/v1/auth")
public interface LoginRestController {
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticateRequest request) ;
}
