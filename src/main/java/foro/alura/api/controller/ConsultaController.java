package foro.alura.api.controller;

import foro.alura.api.consulta.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    public ResponseEntity<DatosRespuetaConsulta> registrarConsulta(@RequestBody @Valid DatosRegistroConsulta datosRegistroConsulta,
                                            UriComponentsBuilder uriComponentsBuilder){
        Consulta  consulta = consultaRepository.save(new Consulta(datosRegistroConsulta));
        DatosRespuetaConsulta datosRespuetaConsulta = new DatosRespuetaConsulta(consulta.getId(), consulta.getMensaje(),
                consulta.getCurso(), consulta.getCurso());
        URI url = uriComponentsBuilder.path("/consultas/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuetaConsulta);
    }
    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsultas(){
        return ResponseEntity.ok(consultaRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity <DatosRespuetaConsulta> retornarDatosConsulta (@PathVariable Long id) {
        Consulta consulta = consultaRepository.getReferenceById(id);
        var datosConsulta = new DatosRespuetaConsulta(consulta.getId(), consulta.getMensaje(),
                consulta.getCurso(), consulta.getCurso());
        return ResponseEntity.ok(datosConsulta);

    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizarConsulta(@RequestBody @Valid DatosActualizarConsulta datosActualizarConsulta){
        Consulta consulta = consultaRepository.getReferenceById(datosActualizarConsulta.id());
        consulta.actualizarConsulta(datosActualizarConsulta);
        return ResponseEntity.ok(new DatosRespuetaConsulta(consulta.getId(), consulta.getMensaje(),
                consulta.getCurso(), consulta.getTitulo()));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarConsulta(@PathVariable Long id){
        Consulta consulta = consultaRepository.getReferenceById(id);
        consultaRepository.delete(consulta);
        return ResponseEntity.noContent().build();

    }

}
