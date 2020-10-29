/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.actividadgobierno.bean.DisponibilidadBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.converter.DisponibilidadCast;
import pe.gob.mimp.ms.actividadgobierno.service.DisponibilidadService;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.siscap.model.Disponibilidad;
import pe.gob.mimp.siscap.repository.disponibilidad.DisponibilidadRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    @Override
    public void crearDisponibilidad(DisponibilidadBean disponibilidadBean) throws Exception {

        Disponibilidad disponibilidad = DisponibilidadCast.castDisponibilidadBeanToDisponibilidad(disponibilidadBean);
        disponibilidadRepository.save(disponibilidad);

    }

    @Override
    public void editarDisponibilidad(DisponibilidadBean disponibilidadBean) throws Exception {

        if (disponibilidadBean.getNidDisponibilidad() == null) {
            return;
        }

        Disponibilidad disponibilidad = DisponibilidadCast.castDisponibilidadBeanToDisponibilidad(disponibilidadBean);
        
        disponibilidadRepository.save(disponibilidad);

    }

    @Override
    public List<DisponibilidadBean> loadDisponibilidadList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<Disponibilidad> disponibilidadList = disponibilidadRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(disponibilidadList)) {

            return disponibilidadList.stream().map(disponibilidad -> {
                return DisponibilidadCast.castDisponibilidadToDisponibilidadBean(disponibilidad);
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public DisponibilidadBean find(BigDecimal id) {

        Optional<Disponibilidad> gobierno = disponibilidadRepository.findById(id);

        if (!gobierno.isPresent()) {
            return null;
        }

        return DisponibilidadCast.castDisponibilidadToDisponibilidadBean(gobierno.get());

    }

}
