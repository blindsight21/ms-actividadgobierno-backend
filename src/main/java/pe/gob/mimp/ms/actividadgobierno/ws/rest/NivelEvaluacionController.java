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
import pe.gob.mimp.ms.actividadgobierno.bean.NivelEvaluacionBean;
import pe.gob.mimp.ms.actividadgobierno.service.NivelEvaluacionService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/nivelevaluacion")
public class NivelEvaluacionController {

    @Autowired
    private NivelEvaluacionService nivelEvaluacionService;

    @PostMapping(value = "/loadNivelEvaluacionList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadNivelEvaluacionList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<NivelEvaluacionBean> nivelEvaluacionList = nivelEvaluacionService.loadNivelEvaluacionList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(nivelEvaluacionList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        NivelEvaluacionBean nivelEvaluacionBean = nivelEvaluacionService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(nivelEvaluacionBean);

        return ResponseEntity.ok(response);

    }
    
//    @PostMapping(value = "/findAllByField", consumes = APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResponseData<?>> findAllByField(@RequestBody FindAllByFieldBean findAllByFieldBean) throws Exception {
//
//        List<NivelEvaluacionBean> parametroSiscapList = nivelEvaluacionService.findAllByField(findAllByFieldBean);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(parametroSiscapList);
//
//        return ResponseEntity.ok(response);
//
//    }
}
