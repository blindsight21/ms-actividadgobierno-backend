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
import pe.gob.mimp.siscap.model.ActividadGobEActGob;
import pe.gob.mimp.siscap.repository.actividadgobeactgob.ActiGobEActGobRepository;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobEActGobBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobEActGobCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGEService;
import pe.gob.mimp.siscap.model.ActividadGob;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ActividadGEServiceImpl implements ActividadGEService {

    @Autowired
    private ActiGobEActGobRepository actiGobEActGobRepository;

    @Override
    public ActividadGobEActGobBean crearActividadGE(ActividadGobEActGobBean actividadGobEActGobBean) throws Exception {

        ActividadGobEActGob actividadGobEActGob = ActividadGobEActGobCast.castActividadGobEActGobBeanToActividadGobEActGob(actividadGobEActGobBean);
        actiGobEActGobRepository.save(actividadGobEActGob);

        return ActividadGobEActGobCast.castActividadGobEActGobToActividadGobEActGobBean(actividadGobEActGob);

    }

    @Override
    public ActividadGobEActGobBean editarActividadGE(ActividadGobEActGobBean actividadGobEActGobBean) throws Exception {

        if (actividadGobEActGobBean.getNidActividadGobEActGob() == null) {
            return null;
        }

        ActividadGobEActGob actividadGobEActGob = ActividadGobEActGobCast.castActividadGobEActGobBeanToActividadGobEActGob(actividadGobEActGobBean);
        actiGobEActGobRepository.save(actividadGobEActGob);

        return ActividadGobEActGobCast.castActividadGobEActGobToActividadGobEActGobBean(actividadGobEActGob);
    }

    @Override
    public List<ActividadGobEActGobBean> loadActividadGEList(FindByParamBean findByParamBean) throws Exception {

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

        List<ActividadGobEActGob> actividadGobEActGobList = actiGobEActGobRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(actividadGobEActGobList)) {

            return actividadGobEActGobList.stream().map(actividadGobEActGob -> {
                ActividadGobEActGobBean actividadGobEActGobBean = ActividadGobEActGobCast.castActividadGobEActGobToActividadGobEActGobBean(actividadGobEActGob);
                return actividadGobEActGobBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = actiGobEActGobRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

}
