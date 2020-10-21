/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.ms.actividadgobierno.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ParametroSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ParametroSiscapCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.siscap.model.ParametroSiscap;
import pe.gob.mimp.siscap.repository.parametrosiscap.ParamSiscapRepository;
import pe.gob.mimp.ms.actividadgobierno.service.ParametroSiscapService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ParametroSiscapServiceImpl implements ParametroSiscapService {

    @Autowired
    private ParamSiscapRepository paramSiscapRepository;

    @Override
    public void crearParametroSiscap(ParametroSiscapBean parametroSiscapBean) throws Exception {

        paramSiscapRepository.save(ParametroSiscapCast.castParametroSiscapBeanToParametroSiscap(parametroSiscapBean));

    }

    @Override
    public void editarParametroSiscap(ParametroSiscapBean parametroSiscapBean) throws Exception {

        if (parametroSiscapBean.getNidParametro() == null) {
            return;
        }

        paramSiscapRepository.save(ParametroSiscapCast.castParametroSiscapBeanToParametroSiscap(parametroSiscapBean));
    }

    @Override
    public List<ParametroSiscapBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        if (findAllByFieldBean == null) {
            return null;
        }

        List<ParametroSiscap> listaParametroSiscap = paramSiscapRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if (Util.esListaVacia(listaParametroSiscap)) {
            return null;
        }

        return listaParametroSiscap.stream().map(parametroSiscap -> {

            return ParametroSiscapCast.castParametroSiscapToParametroSiscapBean(parametroSiscap);
        }).collect(Collectors.toList());

    }

    @Override
    public ParametroSiscapBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<ParametroSiscap> parametroSiscap = paramSiscapRepository.findById(id);

        if (!parametroSiscap.isPresent()) {
            return null;
        }

        return ParametroSiscapCast.castParametroSiscapToParametroSiscapBean(parametroSiscap.get());

    }

}
