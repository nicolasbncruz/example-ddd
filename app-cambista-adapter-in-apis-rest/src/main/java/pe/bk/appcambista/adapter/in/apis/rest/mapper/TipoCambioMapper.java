package pe.bk.appcambista.adapter.in.apis.rest.mapper;

import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioActualizarRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioConsultaRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioConsultaResponse;
import pe.bk.appcambista.dominio.TipoCambio;
import pe.bk.appcambista.dominio.TipoCambioConsulta;

public interface TipoCambioMapper {
  TipoCambioConsulta returnTipoCambioConsulta(TipoCambioConsultaRequest tipoCambioConsultaRequest);
  TipoCambioConsultaResponse returnTipoCambioResponse(TipoCambioConsulta tipoCambioConsulta);
  TipoCambio returnTipoCambio(TipoCambioActualizarRequest tipoCambioActualizarRequest);
}
