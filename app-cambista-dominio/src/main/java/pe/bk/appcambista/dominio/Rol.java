package pe.bk.appcambista.dominio;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
  private Integer id;
  private String name;
}
