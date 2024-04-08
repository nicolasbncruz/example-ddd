package pe.bk.appcambista.adapter.in.apis.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pe.bk.appcambista.adapter.in.apis.rest.model.AuthenticateRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.AuthenticationResponse;
import pe.bk.appcambista.adapter.in.apis.rest.security.JwtService;
import pe.bk.appcambista.adapter.in.apis.rest.security.service.UserDetailsImpl;

@RestController
@RequiredArgsConstructor
public class LoginRestControllerImpl implements LoginRestController {
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  @Override
  public ResponseEntity<AuthenticationResponse> authenticate(AuthenticateRequest request) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    //var user = repository.findByEmail(request.getEmail()).orElseThrow();

    var jwtToken = jwtService.generateToken(userDetails);
    return ResponseEntity.ok(AuthenticationResponse.builder()
        .token(jwtToken)
        .build());
  }
}
