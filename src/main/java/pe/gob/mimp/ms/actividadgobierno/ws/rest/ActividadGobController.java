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
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobBean;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGobService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/actividadgob")
public class ActividadGobController {

    @Autowired
    private ActividadGobService actividadGobService;

    @PostMapping(value = "/crearActividadGob", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearActividadGob(@RequestBody ActividadGobBean actividadGobBean) throws Exception {

        ActividadGobBean actividadGobBeanNuevo = actividadGobService.crearActividadGob(actividadGobBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());
        response.setResultado(actividadGobBeanNuevo);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarActividadGob", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarActividadGob(@RequestBody ActividadGobBean actividadGobBean) throws Exception {

        ActividadGobBean actividadGobBeanEditado = actividadGobService.editarActividadGob(actividadGobBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGobBeanEditado);

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerActividadGobPorId/{nidActividadGob}")
//    public ResponseEntity<ResponseData<?>> obtenerActividadGobPorId(@PathVariable("nidActividadGob") BigDecimal nidActividadGob) throws Exception {
//
//        String txtActividadGob = actividadGobService.obtenerActividadGobPorId(nidActividadGob);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtActividadGob);
//
//        return ResponseEntity.ok(response);
//
//    }

    @PostMapping(value = "/loadActividadGobList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadActividadGobList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<ActividadGobBean> actividadGobList = actividadGobService.loadActividadGobList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGobList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = actividadGobService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        ActividadGobBean actividadGobBean = actividadGobService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGobBean);

        return ResponseEntity.ok(response);

    }

}
