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
import pe.gob.mimp.ms.actividadgobierno.bean.RendimientoBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.converter.RendimientoCast;
import pe.gob.mimp.ms.actividadgobierno.service.RendimientoService;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.siscap.model.Rendimiento;
import pe.gob.mimp.siscap.repository.rendimiento.RendimientoRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class RendimientoServiceImpl implements RendimientoService {

    @Autowired
    private RendimientoRepository rendimientoRepository;

    @Override
    public void crearRendimiento(RendimientoBean rendimientoBean) throws Exception {

        Rendimiento rendimiento = RendimientoCast.castRendimientoBeanToRendimiento(rendimientoBean);
        rendimientoRepository.save(rendimiento);

    }

    @Override
    public void editarRendimiento(RendimientoBean rendimientoBean) throws Exception {

        if (rendimientoBean.getNidRendimiento() == null) {
            return;
        }

        Rendimiento rendimiento = RendimientoCast.castRendimientoBeanToRendimiento(rendimientoBean);
        rendimientoRepository.save(rendimiento);

    }

    @Override
    public List<RendimientoBean> loadRendimientoList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<Rendimiento> rendimientoList = rendimientoRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(rendimientoList)) {

            return rendimientoList.stream().map(rendimiento -> {
                return RendimientoCast.castRendimientoToRendimientoBean(rendimiento);
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public RendimientoBean find(BigDecimal id) {

        Optional<Rendimiento> gobierno = rendimientoRepository.findById(id);

        if (!gobierno.isPresent()) {
            return null;
        }

        return RendimientoCast.castRendimientoToRendimientoBean(gobierno.get());

    }

}
