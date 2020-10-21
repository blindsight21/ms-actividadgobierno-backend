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

import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.bean.CorreoPersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.service.CorreoPersonaSiscapService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/correopersonasiscap")
public class CorreoPersonaSiscapController {

    @Autowired
    private CorreoPersonaSiscapService correoPersonaSiscapService;

    @PostMapping(value = "/crearCorreoPersonaSiscap", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearCorreoPersonaSiscap(@RequestBody CorreoPersonaSiscapBean correoPersonaSiscapBean) throws Exception {

        correoPersonaSiscapService.crearCorreoPersonaSiscap(correoPersonaSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarCorreoPersonaSiscap", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarCorreoPersonaSiscap(@RequestBody CorreoPersonaSiscapBean correoPersonaSiscapBean) throws Exception {

        correoPersonaSiscapService.editarCorreoPersonaSiscap(correoPersonaSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerCorreoPersonaSiscapPorId/{nidCorreoPersonaSiscap}")
//    public ResponseEntity<ResponseData<?>> obtenerCorreoPersonaSiscapPorId(@PathVariable("nidCorreoPersonaSiscap") BigDecimal nidCorreoPersonaSiscap) throws Exception {
//
//        String txtCorreoPersonaSiscap = correoPersonaSiscapService.obtenerCorreoPersonaSiscapPorId(nidCorreoPersonaSiscap);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtCorreoPersonaSiscap);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/obtenerCorreos", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerCorreos(@RequestBody PersonaSiscapBean correoPersonaSiscapBean) throws Exception {

        List<CorreoPersonaSiscapBean> correoPersonaSiscapList = correoPersonaSiscapService.obtenerCorreos(correoPersonaSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(correoPersonaSiscapList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        CorreoPersonaSiscapBean correoPersonaSiscapBean = correoPersonaSiscapService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(correoPersonaSiscapBean);

        return ResponseEntity.ok(response);

    }
}
