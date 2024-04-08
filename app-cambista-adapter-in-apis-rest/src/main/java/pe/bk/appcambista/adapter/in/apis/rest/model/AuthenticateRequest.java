package pe.bk.appcambista.adapter.in.apis.rest.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateRequest {

    private String email;
    private String password;
}
