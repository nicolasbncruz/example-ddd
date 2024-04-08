package pe.bk.appcambista.aplicacion.ports.in.tipocambio;

import pe.bk.appcambista.dominio.Usuario;

import java.util.Optional;

@FunctionalInterface
public interface UsuarioObtenerByEmailUseCase {
  Optional<Usuario> findByEmail(String email);
}
