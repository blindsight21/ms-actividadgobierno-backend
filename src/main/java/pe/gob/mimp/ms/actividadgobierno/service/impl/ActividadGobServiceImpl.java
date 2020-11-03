/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service.impl;

import com.google.gson.Gson;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.ActividadGob;
import pe.gob.mimp.siscap.repository.actividadGob.ActiGobRepository;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGobService;
import pe.gob.mimp.ms.actividadgobierno.util.FormatoFechaConstante;
import pe.gob.mimp.siscap.model.Gobierno;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ActividadGobServiceImpl implements ActividadGobService {

    @Autowired
    private ActiGobRepository actividadGobiernoRepository;

    @Override
    public ActividadGobBean crearActividadGob(ActividadGobBean actividadGobiernoBean) throws Exception {

        ActividadGob actividadGobierno = ActividadGobCast.castActividadGobBeanToActividadGob(actividadGobiernoBean);
        actividadGobiernoRepository.save(actividadGobierno);

        return ActividadGobCast.castActividadGobToActividadGobBean(actividadGobierno);
    }

    @Override
    public ActividadGobBean editarActividadGob(ActividadGobBean actividadGobiernoBean) {

        if (actividadGobiernoBean.getNidActividadGob() == null) {
            return null;
        }

        ActividadGob actividadGobierno = ActividadGobCast.castActividadGobBeanToActividadGob(actividadGobiernoBean);
        actividadGobiernoRepository.save(actividadGobierno);

        return ActividadGobCast.castActividadGobToActividadGobBean(actividadGobierno);
    }

    @Override
    public List<ActividadGobBean> loadActividadGobList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        findByParamBean.getParameters().forEach((k, v) -> {
            if ("nidGobierno".equals(k)) {
                String jsonString = new Gson().toJson(v);
                Gobierno gobierno = new Gson().fromJson(jsonString, Gobierno.class);
                findByParamBean.getParameters().put(k, gobierno);
            }

            if ("fecInicio".equals(k)) {
                SimpleDateFormat formato = new SimpleDateFormat(FormatoFechaConstante.yyyyMMddTHHmmssSSSXXX);

                Date fecInicioCasteadoToDate = null;
                try {
                    fecInicioCasteadoToDate = formato.parse((String) v);
                } catch (Exception e) {

                }
                findByParamBean.getParameters().put(k, fecInicioCasteadoToDate);
            }
        });

        List<ActividadGob> actividadGobiernoList = actividadGobiernoRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(actividadGobiernoList)) {

            return actividadGobiernoList.stream().map(actividadGobierno -> {
                ActividadGobBean actividadGobiernoBean = ActividadGobCast.castActividadGobToActividadGobBean(actividadGobierno);
                return actividadGobiernoBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = actividadGobiernoRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public ActividadGobBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<ActividadGob> actividadGob = actividadGobiernoRepository.findById(id);

        if (!actividadGob.isPresent()) {
            return null;
        }

        return ActividadGobCast.castActividadGobToActividadGobBean(actividadGob.get());

    }

}
