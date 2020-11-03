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
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobResultadoBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGRService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/actividadgr")
public class ActividadGRController {

    @Autowired
    private ActividadGRService actividadGRAService;

    @PostMapping(value = "/crearActividadGR", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearActividadGR(@RequestBody ActividadGobResultadoBean actividadGRABean) throws Exception {

        ActividadGobResultadoBean actividadGobResultadoBeanNuevo = actividadGRAService.crearActividadGR(actividadGRABean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());
        response.setResultado(actividadGobResultadoBeanNuevo);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarActividadGR", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarActividadGR(@RequestBody ActividadGobResultadoBean actividadGRABean) throws Exception {

        ActividadGobResultadoBean actividadGobResultadoBeanEditado = actividadGRAService.editarActividadGR(actividadGRABean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGobResultadoBeanEditado);

        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerActividadGRAPorId/{nidActividadGRA}")
//    public ResponseEntity<ResponseData<?>> obtenerActividadGRAPorId(@PathVariable("nidActividadGRA") BigDecimal nidActividadGRA) throws Exception {
//
//        String txtActividadGRA = actividadGRAService.obtenerActividadGRAPorId(nidActividadGRA);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtActividadGRA);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/loadActividadGRList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadActividadGRList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<ActividadGobResultadoBean> actividadGRAList = actividadGRAService.loadActividadGRList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGRAList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = actividadGRAService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

}
