package pe.bk.appcambista.dominio;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
  private Long id;
  private String email;
  private String password;
  private List<Rol> rols;
}
