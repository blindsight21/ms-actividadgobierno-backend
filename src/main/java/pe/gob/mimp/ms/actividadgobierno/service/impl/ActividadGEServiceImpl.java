/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service.impl;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.ActividadGobEActGob;
import pe.gob.mimp.siscap.repository.actividadgobeactgob.ActiGobEActGobRepository;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobEActGobBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobCast;
import pe.gob.mimp.ms.actividadgobierno.converter.EstadoActividadGobCast;
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
    public void crearActividadGE(ActividadGobEActGobBean actividadGobEActGobBean) throws Exception {

        ActividadGobEActGob actividadGobEActGob = new ActividadGobEActGob();

        actividadGobEActGob.setNidActividadGobEActGob(actividadGobEActGobBean.getNidActividadGobEActGob());
        actividadGobEActGob.setFecCreacion(actividadGobEActGobBean.getFecCreacion());
        actividadGobEActGob.setFlgActivo(actividadGobEActGobBean.getFlgActivo());
        actividadGobEActGob.setNidUsuario(actividadGobEActGobBean.getNidUsuario());
        actividadGobEActGob.setTxtPc(actividadGobEActGobBean.getTxtPc());
        actividadGobEActGob.setTxtIp(actividadGobEActGobBean.getTxtIp());
        actividadGobEActGob.setFecEdicion(actividadGobEActGobBean.getFecEdicion());
        actividadGobEActGob.setNidEstadoActividadGob(EstadoActividadGobCast.castEstadoActividadGobBeanToEstadoActividadGob(actividadGobEActGobBean.getEstadoActividadGobBean()));
        actividadGobEActGob.setNidActividadGob(ActividadGobCast.castActividadGobBeanToActividadGob(actividadGobEActGobBean.getActividadGobBean()));

        actiGobEActGobRepository.save(actividadGobEActGob);

    }

    @Override
    public void editarActividadGE(ActividadGobEActGobBean actividadGobEActGobBean) throws Exception {

        if (actividadGobEActGobBean.getNidActividadGobEActGob() == null) {
            return;
        }

        ActividadGobEActGob actividadGobEActGob = new ActividadGobEActGob();

        actividadGobEActGob.setNidActividadGobEActGob(actividadGobEActGobBean.getNidActividadGobEActGob());
        actividadGobEActGob.setFecCreacion(actividadGobEActGobBean.getFecCreacion());
        actividadGobEActGob.setFlgActivo(actividadGobEActGobBean.getFlgActivo());
        actividadGobEActGob.setNidUsuario(actividadGobEActGobBean.getNidUsuario());
        actividadGobEActGob.setTxtPc(actividadGobEActGobBean.getTxtPc());
        actividadGobEActGob.setTxtIp(actividadGobEActGobBean.getTxtIp());
        actividadGobEActGob.setFecEdicion(actividadGobEActGobBean.getFecEdicion());
        actividadGobEActGob.setNidEstadoActividadGob(EstadoActividadGobCast.castEstadoActividadGobBeanToEstadoActividadGob(actividadGobEActGobBean.getEstadoActividadGobBean()));
        actividadGobEActGob.setNidActividadGob(ActividadGobCast.castActividadGobBeanToActividadGob(actividadGobEActGobBean.getActividadGobBean()));

        actiGobEActGobRepository.save(actividadGobEActGob);

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
                ActividadGobEActGobBean actividadGobEActGobBean = new ActividadGobEActGobBean();

                actividadGobEActGobBean.setNidActividadGobEActGob(actividadGobEActGob.getNidActividadGobEActGob());
                actividadGobEActGobBean.setFecCreacion(actividadGobEActGob.getFecCreacion());
                actividadGobEActGobBean.setFlgActivo(actividadGobEActGob.getFlgActivo());
                actividadGobEActGobBean.setNidUsuario(actividadGobEActGob.getNidUsuario());
                actividadGobEActGobBean.setTxtPc(actividadGobEActGob.getTxtPc());
                actividadGobEActGobBean.setTxtIp(actividadGobEActGob.getTxtIp());
                actividadGobEActGobBean.setFecEdicion(actividadGobEActGob.getFecEdicion());
                actividadGobEActGobBean.setEstadoActividadGobBean(EstadoActividadGobCast.castEstadoActividadGobToEstadoActividadGobBean(actividadGobEActGob.getNidEstadoActividadGob()));
                actividadGobEActGobBean.setActividadGobBean(ActividadGobCast.castActividadGobToActividadGobBean(actividadGobEActGob.getNidActividadGob()));

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
