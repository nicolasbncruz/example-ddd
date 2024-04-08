package pe.bk.appcambista.aplicacion.ports.in.tipocambio;

import pe.bk.appcambista.dominio.TipoCambio;

@FunctionalInterface
public interface TipoCambioActualizarUseCase {
  boolean actualizar(TipoCambio tipoCambio);
}
