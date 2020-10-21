/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service.impl;

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
import pe.gob.mimp.ms.actividadgobierno.converter.PublicoObjetivoCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGPOService;

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
    public void crearActividadGPO(ActividadGobPubliObjeBean actividadGobPubliObjeBean) throws Exception {

        ActividadGobPubliObje actividadGobPubliObje = new ActividadGobPubliObje();

        actividadGobPubliObje.setNidActividadGobPubliObje(actividadGobPubliObjeBean.getNidActividadGobPubliObje());
        actividadGobPubliObje.setNumContadorMarculino(actividadGobPubliObjeBean.getNumContadorMarculino());
        actividadGobPubliObje.setNumContadorFemenino(actividadGobPubliObjeBean.getNumContadorFemenino());
        actividadGobPubliObje.setNumContadorTotal(actividadGobPubliObjeBean.getNumContadorTotal());

        actividadGobPubliObje.setFlgActivo(actividadGobPubliObjeBean.getFlgActivo());
        actividadGobPubliObje.setNidUsuario(actividadGobPubliObjeBean.getNidUsuario());
        actividadGobPubliObje.setTxtPc(actividadGobPubliObjeBean.getTxtPc());
        actividadGobPubliObje.setTxtIp(actividadGobPubliObjeBean.getTxtIp());
        actividadGobPubliObje.setFecEdicion(actividadGobPubliObjeBean.getFecEdicion());
        
        actividadGobPubliObje.setNidPublicoObjetivo(PublicoObjetivoCast.castPublicoObjetivoBeanToPublicoObjetivo(actividadGobPubliObjeBean.getPublicoObjetivoBean()));
        actividadGobPubliObje.setNidActividadGob(ActividadGobCast.castActividadGobBeanToActividadGob(actividadGobPubliObjeBean.getActividadGobBean()));

        actiGobPubliObjeRepository.save(actividadGobPubliObje);

    }

    @Override
    public void editarActividadGPO(ActividadGobPubliObjeBean actividadGobPubliObjeBean) throws Exception {

        if (actividadGobPubliObjeBean.getNidActividadGobPubliObje() == null) {
            return;
        }

        ActividadGobPubliObje actividadGobPubliObje = new ActividadGobPubliObje();

        actividadGobPubliObje.setNidActividadGobPubliObje(actividadGobPubliObjeBean.getNidActividadGobPubliObje());
        actividadGobPubliObje.setNumContadorMarculino(actividadGobPubliObjeBean.getNumContadorMarculino());
        actividadGobPubliObje.setNumContadorFemenino(actividadGobPubliObjeBean.getNumContadorFemenino());
        actividadGobPubliObje.setNumContadorTotal(actividadGobPubliObjeBean.getNumContadorTotal());

        actividadGobPubliObje.setFlgActivo(actividadGobPubliObjeBean.getFlgActivo());
        actividadGobPubliObje.setNidUsuario(actividadGobPubliObjeBean.getNidUsuario());
        actividadGobPubliObje.setTxtPc(actividadGobPubliObjeBean.getTxtPc());
        actividadGobPubliObje.setTxtIp(actividadGobPubliObjeBean.getTxtIp());
        actividadGobPubliObje.setFecEdicion(actividadGobPubliObjeBean.getFecEdicion());
        actividadGobPubliObje.setNidPublicoObjetivo(PublicoObjetivoCast.castPublicoObjetivoBeanToPublicoObjetivo(actividadGobPubliObjeBean.getPublicoObjetivoBean()));
        actividadGobPubliObje.setNidActividadGob(ActividadGobCast.castActividadGobBeanToActividadGob(actividadGobPubliObjeBean.getActividadGobBean()));

        actiGobPubliObjeRepository.save(actividadGobPubliObje);

    }

    @Override
    public List<ActividadGobPubliObjeBean> loadActividadGPOList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<ActividadGobPubliObje> actividadGobPubliObjeList = actiGobPubliObjeRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(actividadGobPubliObjeList)) {

            return actividadGobPubliObjeList.stream().map(actividadGobPubliObje -> {
                ActividadGobPubliObjeBean actividadGobPubliObjeBean = new ActividadGobPubliObjeBean();

                actividadGobPubliObjeBean.setNidActividadGobPubliObje(actividadGobPubliObje.getNidActividadGobPubliObje());
                actividadGobPubliObjeBean.setNumContadorMarculino(actividadGobPubliObje.getNumContadorMarculino());
                actividadGobPubliObjeBean.setNumContadorFemenino(actividadGobPubliObje.getNumContadorFemenino());
                actividadGobPubliObjeBean.setNumContadorTotal(actividadGobPubliObje.getNumContadorTotal());

                actividadGobPubliObjeBean.setFlgActivo(actividadGobPubliObje.getFlgActivo());
                actividadGobPubliObjeBean.setNidUsuario(actividadGobPubliObje.getNidUsuario());
                actividadGobPubliObjeBean.setTxtPc(actividadGobPubliObje.getTxtPc());
                actividadGobPubliObjeBean.setTxtIp(actividadGobPubliObje.getTxtIp());
                actividadGobPubliObjeBean.setFecEdicion(actividadGobPubliObje.getFecEdicion());

                actividadGobPubliObjeBean.setPublicoObjetivoBean(PublicoObjetivoCast.castPublicoObjetivoToPublicoObjetivoBean(actividadGobPubliObje.getNidPublicoObjetivo()));
                actividadGobPubliObjeBean.setActividadGobBean(ActividadGobCast.castActividadGobToActividadGobBean(actividadGobPubliObje.getNidActividadGob()));

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
