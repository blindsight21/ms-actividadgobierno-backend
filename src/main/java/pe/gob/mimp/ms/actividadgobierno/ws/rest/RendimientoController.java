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
import pe.gob.mimp.ms.actividadgobierno.bean.RendimientoBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.service.RendimientoService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/rendimiento")
public class RendimientoController {

    @Autowired
    private RendimientoService rendimientoService;

    @PostMapping(value = "/crearRendimiento", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearRendimiento(@RequestBody RendimientoBean rendimientoBean) throws Exception {

        rendimientoService.crearRendimiento(rendimientoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }
    
    @PostMapping(value = "/editarRendimiento", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarRendimiento(@RequestBody RendimientoBean rendimientoBean) throws Exception {

        rendimientoService.editarRendimiento(rendimientoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadRendimientoList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadRendimientoList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<RendimientoBean> rendimientoList = rendimientoService.loadRendimientoList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(rendimientoList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        RendimientoBean rendimientoBean = rendimientoService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(rendimientoBean);

        return ResponseEntity.ok(response);

    }

}
