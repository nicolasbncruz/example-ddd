package pe.bk.appcambista.aplicacion.ports.services;

import lombok.RequiredArgsConstructor;
import pe.bk.appcambista.aplicacion.ports.in.tipocambio.UsuarioObtenerByEmailUseCase;
import pe.bk.appcambista.aplicacion.ports.out.UsuarioObtenerByEmailPort;
import pe.bk.appcambista.dominio.Usuario;

import java.util.Optional;

@RequiredArgsConstructor
public class UsuarioService implements UsuarioObtenerByEmailUseCase {
  private final UsuarioObtenerByEmailPort usuarioObtenerByEmailPort;
  @Override
  public Optional<Usuario> findByEmail(String email) {
    return  usuarioObtenerByEmailPort.findByEmail(email);
  }
}
