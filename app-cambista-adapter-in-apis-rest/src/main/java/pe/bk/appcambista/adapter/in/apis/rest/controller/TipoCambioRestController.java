package pe.bk.appcambista.adapter.in.apis.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioActualizarRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioConsultaRequest;
import pe.bk.appcambista.adapter.in.apis.rest.model.TipoCambioConsultaResponse;

@RequestMapping("/api/v1/cambista")
public interface TipoCambioRestController {
  @PostMapping
  ResponseEntity<TipoCambioConsultaResponse>  consulta(@RequestBody TipoCambioConsultaRequest tipoCambioConsultaRequest);

  @PatchMapping
  ResponseEntity<Boolean> actualizar(@RequestBody TipoCambioActualizarRequest tipoCambioActualizarRequest);
}
