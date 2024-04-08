package pe.bk.appcambista.aplicacion.ports.in.tipocambio;

import pe.bk.appcambista.dominio.TipoCambio;
import pe.bk.appcambista.dominio.TipoCambioConsulta;

@FunctionalInterface
public interface TipoCambioConsultaUseCase {
  TipoCambioConsulta consulta(TipoCambioConsulta consulta);
}
