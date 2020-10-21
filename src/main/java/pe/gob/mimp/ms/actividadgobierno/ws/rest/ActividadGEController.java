/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.ws.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobEActGobBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGEService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/actividadge")
public class ActividadGEController {

    @Autowired
    private ActividadGEService actividadGEService;

    @PostMapping(value = "/crearActividadGE", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearActividadGE(@RequestBody ActividadGobEActGobBean actividadGEABean) throws Exception {

        actividadGEService.crearActividadGE(actividadGEABean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarActividadGE", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarActividadGE(@RequestBody ActividadGobEActGobBean actividadGEABean) throws Exception {

        actividadGEService.editarActividadGE(actividadGEABean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerActividadGEAPorId/{nidActividadGEA}")
//    public ResponseEntity<ResponseData<?>> obtenerActividadGEAPorId(@PathVariable("nidActividadGEA") BigDecimal nidActividadGEA) throws Exception {
//
//        String txtActividadGEA = actividadGEAService.obtenerActividadGEAPorId(nidActividadGEA);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtActividadGEA);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/loadActividadGEList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadActividadGEList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<ActividadGobEActGobBean> actividadGEList = actividadGEService.loadActividadGEList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGEList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = actividadGEService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

}
