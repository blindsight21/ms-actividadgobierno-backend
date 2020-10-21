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
import pe.gob.mimp.ms.actividadgobierno.bean.FindAllByFieldBean;

import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.bean.ParametroSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.service.ParametroSiscapService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/parametrosiscap")
public class ParametroSiscapController {

    @Autowired
    private ParametroSiscapService paramSiscapService;

    @PostMapping(value = "/crearParametroSiscap", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearParametroSiscap(@RequestBody ParametroSiscapBean parametroSiscapBean) throws Exception {

        paramSiscapService.crearParametroSiscap(parametroSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarParametroSiscap", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarParametroSiscap(@RequestBody ParametroSiscapBean parametroSiscapBean) throws Exception {

        paramSiscapService.editarParametroSiscap(parametroSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }
    
    @PostMapping(value = "/findAllByField", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> findAllByField(@RequestBody FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<ParametroSiscapBean> parametroSiscapList = paramSiscapService.findAllByField(findAllByFieldBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(parametroSiscapList);

        return ResponseEntity.ok(response);

    }
    
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        ParametroSiscapBean personaSiscapBean = paramSiscapService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(personaSiscapBean);

        return ResponseEntity.ok(response);

    }

}
