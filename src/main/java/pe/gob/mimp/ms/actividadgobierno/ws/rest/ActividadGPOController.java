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
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobPubliObjeBean;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGPOService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/actividadgpo")
public class ActividadGPOController {

    @Autowired
    private ActividadGPOService actividadGPOService;

    @PostMapping(value = "/crearActividadGPO", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearActividadGPO(@RequestBody ActividadGobPubliObjeBean actividadGPOBean) throws Exception {

        ActividadGobPubliObjeBean actividadGobPubliObjeBeanNuevo = actividadGPOService.crearActividadGPO(actividadGPOBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());
        response.setResultado(actividadGobPubliObjeBeanNuevo);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarActividadGPO", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarActividadGPO(@RequestBody ActividadGobPubliObjeBean actividadGPOBean) throws Exception {

        ActividadGobPubliObjeBean actividadGobPubliObjeBeanEditado = actividadGPOService.editarActividadGPO(actividadGPOBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGobPubliObjeBeanEditado);

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerActividadGPOPorId/{nidActividadGPO}")
//    public ResponseEntity<ResponseData<?>> obtenerActividadGPOPorId(@PathVariable("nidActividadGPO") BigDecimal nidActividadGPO) throws Exception {
//
//        String txtActividadGPO = actividadGPOService.obtenerActividadGPOPorId(nidActividadGPO);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtActividadGPO);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/loadActividadGPOList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadActividadGPOList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<ActividadGobPubliObjeBean> actividadGPOList = actividadGPOService.loadActividadGPOList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGPOList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = actividadGPOService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

}
