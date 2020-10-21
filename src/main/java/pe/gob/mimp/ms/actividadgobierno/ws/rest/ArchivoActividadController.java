/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.ws.rest;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.bean.ArchivoActividadBean;
import pe.gob.mimp.ms.actividadgobierno.service.ArchivoActividadService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/archivoactividad")
public class ArchivoActividadController {

    @Autowired
    private ArchivoActividadService archivoActividadService;

    @PostMapping(value = "/crearArchivoActividad", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearArchivoActividad(@RequestBody ArchivoActividadBean archivoActividadBean) throws Exception {

        archivoActividadService.crearArchivoActividad(archivoActividadBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarArchivoActividad", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarArchivoActividad(@RequestBody ArchivoActividadBean archivoActividadBean) throws Exception {

        archivoActividadService.editarArchivoActividad(archivoActividadBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerArchivoActividadPorId/{nidArchivoActividad}")
//    public ResponseEntity<ResponseData<?>> obtenerArchivoActividadPorId(@PathVariable("nidArchivoActividad") BigDecimal nidArchivoActividad) throws Exception {
//
//        String txtArchivoActividad = archivoActividadService.obtenerArchivoActividadPorId(nidArchivoActividad);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtArchivoActividad);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/loadArchivoActividadList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadArchivoActividadList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<ArchivoActividadBean> archivoActividadList = archivoActividadService.loadArchivoActividadList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(archivoActividadList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = archivoActividadService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

}
