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
import pe.gob.mimp.siscap.model.ArchivoActividad;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ArchivoActividadBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ArchivoActividadCast;
import pe.gob.mimp.ms.actividadgobierno.service.ArchivoActividadService;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.siscap.model.ActividadGob;
import pe.gob.mimp.siscap.repository.archivoactividad.ArchivoActividadRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ArchivoActividadServiceImpl implements ArchivoActividadService {

    @Autowired
    private ArchivoActividadRepository archivoActividadRepository;

    @Override
    public void crearArchivoActividad(ArchivoActividadBean archivoActividadBean) throws Exception {
        archivoActividadRepository.save(ArchivoActividadCast.castArchivoActividadBeanToArchivoActividad(archivoActividadBean));

    }

    @Override
    public void editarArchivoActividad(ArchivoActividadBean archivoActividadBean) {

        if (archivoActividadBean.getNidArchivoActividad() == null) {
            return;
        }

        archivoActividadRepository.save(ArchivoActividadCast.castArchivoActividadBeanToArchivoActividad(archivoActividadBean));

    }

    @Override
    public List<ArchivoActividadBean> loadArchivoActividadList(FindByParamBean findByParamBean) throws Exception {

        findByParamBean.getParameters().forEach((k, v) -> {
            if ("nidActividadGob".equals(k)) {
                String jsonString = new Gson().toJson(v);
                ActividadGob actividadGob = new Gson().fromJson(jsonString, ActividadGob.class);
                findByParamBean.getParameters().put(k, actividadGob);
            }
        });

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<ArchivoActividad> archivoActividadList = archivoActividadRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(archivoActividadList)) {

            return archivoActividadList.stream().map(archivoActividad -> {

                return ArchivoActividadCast.castArchivoActividadToArchivoActividadBean(archivoActividad);

            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        findByParamBean.getParameters().forEach((k, v) -> {
            if ("nidActividadGob".equals(k)) {
                String jsonString = new Gson().toJson(v);
                ActividadGob actividadGob = new Gson().fromJson(jsonString, ActividadGob.class);
                findByParamBean.getParameters().put(k, actividadGob);
            }
        });
        
        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = archivoActividadRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

}
