package pe.bk.appcambista.dominio;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio {
  private Long id;
  private double monto;
  private String monedaOrigen;
  private String monedaDestino;
  private int factor;
}
