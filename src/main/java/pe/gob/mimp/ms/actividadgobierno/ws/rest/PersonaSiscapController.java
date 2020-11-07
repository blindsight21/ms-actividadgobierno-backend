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
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.service.PersonaSiscapService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/personasiscap")
public class PersonaSiscapController {

    @Autowired
    private PersonaSiscapService personaSiscapService;

    @PostMapping(value = "/crearPersonaSiscap", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearPersonaSiscap(@RequestBody PersonaSiscapBean personaSiscapBean) throws Exception {

        PersonaSiscapBean personaSiscapBeanNuevo = personaSiscapService.crearPersonaSiscap(personaSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());
        response.setResultado(personaSiscapBeanNuevo);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarPersonaSiscap", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarPersonaSiscap(@RequestBody PersonaSiscapBean personaSiscapBean) throws Exception {

        PersonaSiscapBean personaSiscapBeanEditado = personaSiscapService.editarPersonaSiscap(personaSiscapBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(personaSiscapBeanEditado);

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerPersonaSiscapPorId/{nidPersonaSiscap}")
//    public ResponseEntity<ResponseData<?>> obtenerPersonaSiscapPorId(@PathVariable("nidPersonaSiscap") BigDecimal nidPersonaSiscap) throws Exception {
//
//        String txtPersonaSiscap = personaSiscapService.obtenerPersonaSiscapPorId(nidPersonaSiscap);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtPersonaSiscap);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/loadPersonaSiscapList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadPersonaSiscapList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<PersonaSiscapBean> personaSiscapList = personaSiscapService.loadPersonaSiscapList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(personaSiscapList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        PersonaSiscapBean personaSiscapBean = personaSiscapService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(personaSiscapBean);

        return ResponseEntity.ok(response);

    }
    
    @PostMapping(value = "/findAllByField", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> findAllByField(@RequestBody FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<PersonaSiscapBean> parametroSiscapList = personaSiscapService.findAllByField(findAllByFieldBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(parametroSiscapList);

        return ResponseEntity.ok(response);

    }
}
