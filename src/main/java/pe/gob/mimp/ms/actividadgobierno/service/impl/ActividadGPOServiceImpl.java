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
import pe.gob.mimp.siscap.model.ActividadGobPubliObje;
import pe.gob.mimp.siscap.repository.actividadgobpubliobje.ActiGobPubliObjeRepository;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobPubliObjeBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobCast;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobPubliObjeCast;
import pe.gob.mimp.ms.actividadgobierno.converter.PublicoObjetivoCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGPOService;
import pe.gob.mimp.siscap.model.ActividadGob;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ActividadGPOServiceImpl implements ActividadGPOService {

    @Autowired
    private ActiGobPubliObjeRepository actiGobPubliObjeRepository;

    @Override
    public ActividadGobPubliObjeBean crearActividadGPO(ActividadGobPubliObjeBean actividadGobPubliObjeBean) throws Exception {

        ActividadGobPubliObje actividadGobPubliObje = ActividadGobPubliObjeCast.castActividadGobPubliObjeBeanToActividadGobPubliObje(actividadGobPubliObjeBean);
        actiGobPubliObjeRepository.save(actividadGobPubliObje);

        return ActividadGobPubliObjeCast.castActividadGobPubliObjeToActividadGobPubliObjeBean(actividadGobPubliObje);
    }

    @Override
    public ActividadGobPubliObjeBean editarActividadGPO(ActividadGobPubliObjeBean actividadGobPubliObjeBean) throws Exception {

        if (actividadGobPubliObjeBean.getNidActividadGobPubliObje() == null) {
            return null;
        }

        ActividadGobPubliObje actividadGobPubliObje = ActividadGobPubliObjeCast.castActividadGobPubliObjeBeanToActividadGobPubliObje(actividadGobPubliObjeBean);
        actiGobPubliObjeRepository.save(actividadGobPubliObje);

        return ActividadGobPubliObjeCast.castActividadGobPubliObjeToActividadGobPubliObjeBean(actividadGobPubliObje);
    }

    @Override
    public List<ActividadGobPubliObjeBean> loadActividadGPOList(FindByParamBean findByParamBean) throws Exception {

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

        List<ActividadGobPubliObje> actividadGobPubliObjeList = actiGobPubliObjeRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(actividadGobPubliObjeList)) {

            return actividadGobPubliObjeList.stream().map(actividadGobPubliObje -> {
                ActividadGobPubliObjeBean actividadGobPubliObjeBean = ActividadGobPubliObjeCast.castActividadGobPubliObjeToActividadGobPubliObjeBean(actividadGobPubliObje);
                return actividadGobPubliObjeBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = actiGobPubliObjeRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

}
