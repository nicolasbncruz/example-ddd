package pe.bk.appcambista.aplicacion.ports.services;

import lombok.RequiredArgsConstructor;
import pe.bk.appcambista.aplicacion.ports.in.tipocambio.TipoCambioActualizarUseCase;
import pe.bk.appcambista.aplicacion.ports.in.tipocambio.TipoCambioConsultaUseCase;
import pe.bk.appcambista.aplicacion.ports.out.TipoCambioActualizarPort;
import pe.bk.appcambista.aplicacion.ports.out.TipoCambioObtenerByMonedaPort;
import pe.bk.appcambista.dominio.TipoCambio;
import pe.bk.appcambista.dominio.TipoCambioConsulta;

@RequiredArgsConstructor
public class TipoCambioService implements TipoCambioActualizarUseCase,
  TipoCambioConsultaUseCase {

  private final TipoCambioActualizarPort tipoCambioActualizarPort;
  private final TipoCambioObtenerByMonedaPort tipoCambioObtenerPort;

  @Override
  public boolean actualizar(TipoCambio tipoCambio) {
    return tipoCambioActualizarPort.actualizar(tipoCambio);
  }

  @Override
  public TipoCambioConsulta consulta(TipoCambioConsulta consulta) {
    TipoCambio tipoCambio = tipoCambioObtenerPort.obtenerByMoneda(consulta.getMonedaOrigen(),
      consulta.getMonedaDestino());
    double montoConvertido = tipoCambio.getFactor() == 1 ? (consulta.getMonto() * tipoCambio.getMonto())
      : (consulta.getMonto() / tipoCambio.getMonto());
    return TipoCambioConsulta.builder()
      .tipoCambio(tipoCambio.getMonto())
      .monto(consulta.getMonto())
      .monedaDestino(consulta.getMonedaDestino())
      .monedaOrigen(consulta.getMonedaOrigen())
      .montoConvertido(montoConvertido)
      .build();
  }
}
