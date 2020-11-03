/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service.impl;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.repository.actividadgobpubliproc.ActiGobPubliProcRepository;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobPubliProcBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobPubliProcCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGPPService;
import pe.gob.mimp.siscap.model.ActividadGob;
import pe.gob.mimp.siscap.model.ActividadGobPubliProc;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ActividadGPPServiceImpl implements ActividadGPPService {

    @Autowired
    private ActiGobPubliProcRepository actiGobPubliProcRepository;

    @Override
    public ActividadGobPubliProcBean crearActividadGPP(ActividadGobPubliProcBean actividadGPPBean) throws Exception {

        ActividadGobPubliProc actividadGobPubliProc = ActividadGobPubliProcCast.castActividadGobPubliProcBeanToActividadGobPubliProc(actividadGPPBean);

        actiGobPubliProcRepository.save(actividadGobPubliProc);

        return ActividadGobPubliProcCast.castActividadGobPubliProcToActividadGobPubliProcBean(actividadGobPubliProc);
    }

    @Override
    public ActividadGobPubliProcBean editarActividadGPP(ActividadGobPubliProcBean actividadGPPBean) throws Exception {

        if (actividadGPPBean.getNidActividadGobProcGob() == null) {
            return null;
        }

        ActividadGobPubliProc actividadGobPubliProc = ActividadGobPubliProcCast.castActividadGobPubliProcBeanToActividadGobPubliProc(actividadGPPBean);

        actiGobPubliProcRepository.save(actividadGobPubliProc);

        return ActividadGobPubliProcCast.castActividadGobPubliProcToActividadGobPubliProcBean(actividadGobPubliProc);
    }

    @Override
    public List<ActividadGobPubliProcBean> loadActividadGPPList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        findByParamBean.getParameters().forEach((k, v) -> {
            if ("nidActividadGob".equals(k)) {
                String jsonString = new Gson().toJson(v);
                ActividadGob actividadGob = new Gson().fromJson(jsonString, ActividadGob.class);
                findByParamBean.getParameters().put(k, actividadGob);
            }
        });

        List<ActividadGobPubliProc> actividadGobPubliProcList = actiGobPubliProcRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(actividadGobPubliProcList)) {

            return actividadGobPubliProcList.stream().map(actividadGobPubliProc -> {
                return ActividadGobPubliProcCast.castActividadGobPubliProcToActividadGobPubliProcBean(actividadGobPubliProc);
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = actiGobPubliProcRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

}
