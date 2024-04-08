package pe.bk.appcambista.dominio;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambioConsulta {
  private double monto;
  private String monedaOrigen;
  private String monedaDestino;
  private double montoConvertido;
  private double tipoCambio;
}
