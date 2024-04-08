package pe.bk.appcambista.adapter.in.apis.rest.mapper;

import org.springframework.stereotype.Component;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioActualizarRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioConsultaRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioConsultaResponse;
import pe.bk.appcambista.dominio.TipoCambio;
import pe.bk.appcambista.dominio.TipoCambioConsulta;

@Component
public class TipoCambioMapperImpl implements TipoCambioMapper{
  @Override
  public TipoCambioConsulta returnTipoCambioConsulta(TipoCambioConsultaRequest tipoCambioConsultaRequest) {
    return TipoCambioConsulta
      .builder()
      .monto(tipoCambioConsultaRequest.getMonto())
      .monedaOrigen(tipoCambioConsultaRequest.getMonedaOrigen())
      .monedaDestino(tipoCambioConsultaRequest.getMonedaDestino())
      .build();
  }

  @Override
  public TipoCambioConsultaResponse returnTipoCambioResponse(TipoCambioConsulta tipoCambioConsulta) {
    return TipoCambioConsultaResponse
      .builder()
      .tipoCambio(tipoCambioConsulta.getTipoCambio())
      .monedaDestino(tipoCambioConsulta.getMonedaDestino())
      .monedaOrigen(tipoCambioConsulta.getMonedaOrigen())
      .monto(tipoCambioConsulta.getMonto())
      .montoConTipoCambio(tipoCambioConsulta.getMontoConvertido())
      .build();
  }

  @Override
  public TipoCambio returnTipoCambio(TipoCambioActualizarRequest tipoCambioActualizarRequest) {
    return TipoCambio.builder()
      .id(tipoCambioActualizarRequest.getId())
      .monto(tipoCambioActualizarRequest.getMonto())
      .build();
  }
}
