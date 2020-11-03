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
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobPubliProcBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ResponseData;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGPPService;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping(value = "/actividadgpp")
public class ActividadGPPController {

    @Autowired
    private ActividadGPPService actividadGPPService;

    @PostMapping(value = "/crearActividadGPP", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearActividadGPP(@RequestBody ActividadGobPubliProcBean actividadGPPBean) throws Exception {

        ActividadGobPubliProcBean actividadGobPubliProcBeanNuevo = actividadGPPService.crearActividadGPP(actividadGPPBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());
        response.setResultado(actividadGobPubliProcBeanNuevo);
        
        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarActividadGPP", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarActividadGPP(@RequestBody ActividadGobPubliProcBean actividadGPPBean) throws Exception {

         ActividadGobPubliProcBean actividadGobPubliProcBeanEditado = actividadGPPService.editarActividadGPP(actividadGPPBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGobPubliProcBeanEditado);
        
        return ResponseEntity.ok(response);

    }

//    @GetMapping(value = "/obtenerActividadGPPPorId/{nidActividadGPP}")
//    public ResponseEntity<ResponseData<?>> obtenerActividadGPPPorId(@PathVariable("nidActividadGPP") BigDecimal nidActividadGPP) throws Exception {
//
//        String txtActividadGPP = actividadGPPService.obtenerActividadGPPPorId(nidActividadGPP);
//
//        ResponseData<Object> response = new ResponseData<>();
//        response.setCod(HttpStatus.OK.value());
//        response.setMsg(HttpStatus.OK.getReasonPhrase());
//        response.setResultado(txtActividadGPP);
//
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping(value = "/loadActividadGPPList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadActividadGPPList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<ActividadGobPubliProcBean> actividadGPPList = actividadGPPService.loadActividadGPPList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(actividadGPPList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = actividadGPPService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

}
