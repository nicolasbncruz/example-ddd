package pe.bk.appcambista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pe.bk.appcambista.adapter.in.apis.rest.controller.TipoCambioRestController;
import pe.bk.appcambista.adapter.in.apis.rest.controller.TipoCambioRestControllerImpl;
import pe.bk.appcambista.adapter.in.apis.rest.mapper.TipoCambioMapper;
import pe.bk.appcambista.adapter.out.dbs.sql.h2.springdata.adapter.TipoCambioAdapter;
import pe.bk.appcambista.adapter.out.dbs.sql.h2.springdata.adapter.UsuarioAdapter;
import pe.bk.appcambista.adapter.out.dbs.sql.h2.springdata.mapper.TipoCambioH2Mapper;
import pe.bk.appcambista.adapter.out.dbs.sql.h2.springdata.repository.TipoCambioRepository;
import pe.bk.appcambista.adapter.out.dbs.sql.h2.springdata.repository.UsuarioRepository;
import pe.bk.appcambista.aplicacion.ports.out.TipoCambioActualizarPort;
import pe.bk.appcambista.aplicacion.ports.out.TipoCambioObtenerByMonedaPort;
import pe.bk.appcambista.aplicacion.ports.out.UsuarioObtenerByEmailPort;
import pe.bk.appcambista.aplicacion.ports.services.TipoCambioService;
import org.springframework.context.annotation.Configuration;
import pe.bk.appcambista.aplicacion.ports.services.UsuarioService;

@Configuration
public class GlobalConfiguration {
  @Bean
  TipoCambioService tipoCambioService(TipoCambioActualizarPort tipoCambioActualizarPort,
                                      TipoCambioObtenerByMonedaPort tipoCambioObtenerPort) {
    return new TipoCambioService(tipoCambioActualizarPort, tipoCambioObtenerPort);
  }

  @Bean
  TipoCambioAdapter tipoCambioAdapter(TipoCambioRepository tipoCambioRepository,
                                      TipoCambioH2Mapper tipoCambioMapper){
    return new TipoCambioAdapter(tipoCambioRepository, tipoCambioMapper);
  }


  @Bean
  UsuarioService usuarioService(UsuarioObtenerByEmailPort usuarioObtenerByEmailPort){
    return new UsuarioService(usuarioObtenerByEmailPort);
  }

  @Bean
  UsuarioAdapter usuarioAdapter(UsuarioRepository usuarioRepository) {
    return new UsuarioAdapter(usuarioRepository);
  }


}
