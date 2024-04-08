package pe.bk.appcambista.adapter.in.apis.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.bk.appcambista.adapter.in.apis.rest.mapper.TipoCambioMapper;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioActualizarRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioConsultaRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioConsultaResponse;
import pe.bk.appcambista.aplicacion.ports.services.TipoCambioService;
import pe.bk.appcambista.dominio.TipoCambioConsulta;

@RestController
@RequiredArgsConstructor
public class TipoCambioRestControllerImpl implements TipoCambioRestController {

  private final TipoCambioService tipoCambioService;
  private final TipoCambioMapper tipoCambioMapper;

  @Override
  public ResponseEntity<TipoCambioConsultaResponse> consulta(TipoCambioConsultaRequest tipoCambioConsultaRequest) {
    TipoCambioConsulta tipoCambioConsulta = tipoCambioService
        .consulta(tipoCambioMapper.returnTipoCambioConsulta(tipoCambioConsultaRequest));
    return ResponseEntity.ok(tipoCambioMapper.returnTipoCambioResponse(tipoCambioConsulta));
  }

  @Override
  public ResponseEntity<Boolean> actualizar(TipoCambioActualizarRequest tipoCambioActualizarRequest) {
    return ResponseEntity.ok(tipoCambioService
        .actualizar(tipoCambioMapper.returnTipoCambio(tipoCambioActualizarRequest)));
  }
}
