/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.ms.actividadgobierno.bean.DisponibilidadBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.service.DisponibilidadService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/disponibilidad")
public class DisponibilidadController {

    @Autowired
    private DisponibilidadService disponibilidadService;

    @PostMapping(value = "/crearDisponibilidad", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearDisponibilidad(@RequestBody DisponibilidadBean disponibilidadBean) throws Exception {

        disponibilidadService.crearDisponibilidad(disponibilidadBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }
    
    @PostMapping(value = "/editarDisponibilidad", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarDisponibilidad(@RequestBody DisponibilidadBean disponibilidadBean) throws Exception {

        disponibilidadService.editarDisponibilidad(disponibilidadBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadDisponibilidadList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadDisponibilidadList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<DisponibilidadBean> disponibilidadList = disponibilidadService.loadDisponibilidadList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(disponibilidadList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        DisponibilidadBean disponibilidadBean = disponibilidadService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(disponibilidadBean);

        return ResponseEntity.ok(response);

    }

}
