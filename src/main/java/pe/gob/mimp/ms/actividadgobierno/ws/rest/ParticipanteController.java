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
import pe.gob.mimp.ms.actividadgobierno.bean.ParticipanteBean;
import pe.gob.mimp.ms.actividadgobierno.service.ParticipanteService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/participante")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @PostMapping(value = "/crearParticipante", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearParticipante(@RequestBody ParticipanteBean participanteBean) throws Exception {

        participanteService.crearParticipante(participanteBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarParticipante", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarParticipante(@RequestBody ParticipanteBean participanteBean) throws Exception {

        participanteService.editarParticipante(participanteBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerParticipantePorId/{nidParticipante}")
//    public ResponseEntity<ResponseData<?>> obtenerParticipantePorId(@PathVariable("nidParticipante") BigDecimal nidParticipante) throws Exception {
//
//        String txtParticipante = participanteService.obtenerParticipantePorId(nidParticipante);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtParticipante);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/loadParticipanteList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadParticipanteList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<ParticipanteBean> participanteList = participanteService.loadParticipanteList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(participanteList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = participanteService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

}
