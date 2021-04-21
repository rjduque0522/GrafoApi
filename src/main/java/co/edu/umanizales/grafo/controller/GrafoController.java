package co.edu.umanizales.grafo.controller;

import co.edu.umanizales.grafo.domain.model.Empleado;
import co.edu.umanizales.grafo.domain.model.RespuestaDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "grafo")
@Validated

public class GrafoController {

    List<Empleado> listado = new ArrayList<>();

    public GrafoController() {
       listado.add(new Empleado("ricado duque", 12312423));
        listado.add(new Empleado("daniel duque", 46476575));
        listado.add(new Empleado("pedro duque", 54354534));
        listado.add(new Empleado("laura renteria", 20000000));
        listado.add(new Empleado("camilo renteria", 20000000));
    }

    @GetMapping("/{param1}/{param2}")
    public RespuestaDTO getPruebaApi(@PathVariable("param1") String param1,
                                     @PathVariable("param2") String param2) {

        return new RespuestaDTO(200,"Exitoso", param1 +" "+ param2);
    }

    @PostMapping
    public Empleado CalcularSalario(@RequestBody Empleado empleado) {

        empleado.CalcularSalario(5, 13000);
        return empleado;
    }

    @GetMapping
    public RespuestaDTO obtenerEmpleados()
    {
        if (listado.size()==0){
            return new RespuestaDTO(400,"No hay empleados",null);
        }
        RespuestaDTO resp = new RespuestaDTO(200,"Exitoso", listado);
        return resp;
    }

    @GetMapping("/{salario1}/{salario2}")
    public RespuestaDTO getEmpleadosRangoSalarial(@PathVariable("salaraio1") double salario1,
                                     @PathVariable("salario2") double salario2) {
    if (salario1>= salario2){
        return  new RespuestaDTO(500,"el salario 1 debe ser inferior" + "al salario 2", null);
    }
        return new RespuestaDTO(200,"Exitoso", listado);
    }

}
