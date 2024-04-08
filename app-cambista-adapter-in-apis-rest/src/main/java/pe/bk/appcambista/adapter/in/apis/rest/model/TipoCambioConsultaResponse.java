package pe.bk.appcambista.adapter.in.apis.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TipoCambioConsultaResponse {
  private double monto;
  private String monedaOrigen;
  private String monedaDestino;
  private double montoConTipoCambio;
  private double tipoCambio;
}
