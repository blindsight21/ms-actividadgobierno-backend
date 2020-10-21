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
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;

import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.bean.TelefonoPersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.service.TelefonoPersonaSiscapService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/telefonopersonasiscap")
public class TelefonoPersonaSiscapController {

    @Autowired
    private TelefonoPersonaSiscapService telefonoPersonaSiscapService;

    @PostMapping(value = "/crearTelefonoPersonaSiscap", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearTelefonoPersonaSiscap(@RequestBody TelefonoPersonaSiscapBean telefonoPersonaSiscapBean) throws Exception {

        telefonoPersonaSiscapService.crearTelefonoPersonaSiscap(telefonoPersonaSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarTelefonoPersonaSiscap", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarTelefonoPersonaSiscap(@RequestBody TelefonoPersonaSiscapBean telefonoPersonaSiscapBean) throws Exception {

        telefonoPersonaSiscapService.editarTelefonoPersonaSiscap(telefonoPersonaSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerTelefonoPersonaSiscapPorId/{nidTelefonoPersonaSiscap}")
//    public ResponseEntity<ResponseData<?>> obtenerTelefonoPersonaSiscapPorId(@PathVariable("nidTelefonoPersonaSiscap") BigDecimal nidTelefonoPersonaSiscap) throws Exception {
//
//        String txtTelefonoPersonaSiscap = telefonoPersonaSiscapService.obtenerTelefonoPersonaSiscapPorId(nidTelefonoPersonaSiscap);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtTelefonoPersonaSiscap);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/obtenerTelefonos", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerTelefonos(@RequestBody PersonaSiscapBean personaSiscapBean) throws Exception {

        List<TelefonoPersonaSiscapBean> telefonoPersonaSiscapList = telefonoPersonaSiscapService.obtenerTelefonos(personaSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(telefonoPersonaSiscapList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        TelefonoPersonaSiscapBean telefonoPersonaSiscapBean = telefonoPersonaSiscapService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(telefonoPersonaSiscapBean);

        return ResponseEntity.ok(response);

    }
}
