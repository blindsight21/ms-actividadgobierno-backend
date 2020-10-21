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
import pe.gob.mimp.siscap.model.NivelEvaluacion;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.NivelEvaluacionBean;
import pe.gob.mimp.ms.actividadgobierno.converter.NivelEvaluacionCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.NivelEvaluacionService;
import pe.gob.mimp.siscap.repository.nivelevaluacion.NivelEvalRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class NivelEvauacionServiceImpl implements NivelEvaluacionService {

    @Autowired
    private NivelEvalRepository nivelEvaluacionRepository;

    @Override
    public void crearNivelEvaluacion(NivelEvaluacionBean nivelEvaluacionBean) throws Exception {

        NivelEvaluacion nivelEvaluacion = NivelEvaluacionCast.castNivelEvaluacionBeanToNivelEvaluacion(nivelEvaluacionBean);

        nivelEvaluacionRepository.save(nivelEvaluacion);

    }

    @Override
    public void editarNivelEvaluacion(NivelEvaluacionBean nivelEvaluacionBean) {

        if (nivelEvaluacionBean.getNidNivelEvaluacion() == null) {
            return;
        }

        NivelEvaluacion nivelEvaluacion = NivelEvaluacionCast.castNivelEvaluacionBeanToNivelEvaluacion(nivelEvaluacionBean);

        nivelEvaluacionRepository.save(nivelEvaluacion);

    }

    @Override
    public List<NivelEvaluacionBean> loadNivelEvaluacionList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<NivelEvaluacion> nivelEvaluacionList = nivelEvaluacionRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(nivelEvaluacionList)) {

            return nivelEvaluacionList.stream().map(nivelEvaluacion -> {
                NivelEvaluacionBean nivelEvaluacionBean = new NivelEvaluacionBean();

                nivelEvaluacionBean = NivelEvaluacionCast.castNivelEvaluacionToNivelEvaluacionBean(nivelEvaluacion);

                return nivelEvaluacionBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

//    @Override
//    public List<NivelEvaluacionBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {
//
//        if (findAllByFieldBean == null) {
//            return null;
//        }
//
//        List<NivelEvaluacion> nivelEvaluacionList = nivelEvaluacionRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());
//
//        if (Util.esListaVacia(nivelEvaluacionList)) {
//            return null;
//        }
//
//        return nivelEvaluacionList.stream().map(nivelEvaluacion -> {
//            NivelEvaluacionBean nivelEvaluacionBean = new NivelEvaluacionBean();
//
//            nivelEvaluacionBean = NivelEvaluacionCast.castNivelEvaluacionToNivelEvaluacionBean(nivelEvaluacion);
//
//            return nivelEvaluacionBean;
//        }).collect(Collectors.toList());
//
//    }
    @Override
    public NivelEvaluacionBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<NivelEvaluacion> nivelEvaluacion = nivelEvaluacionRepository.findById(id);

        if (!nivelEvaluacion.isPresent()) {
            return null;
        }

        return NivelEvaluacionCast.castNivelEvaluacionToNivelEvaluacionBean(nivelEvaluacion.get());

    }
}
