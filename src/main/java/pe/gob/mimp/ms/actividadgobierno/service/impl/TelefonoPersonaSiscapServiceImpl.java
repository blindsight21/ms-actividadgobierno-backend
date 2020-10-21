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
import pe.gob.mimp.siscap.model.TelefonoPersonaSiscap;
import pe.gob.mimp.ms.actividadgobierno.bean.TelefonoPersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.converter.TelefonoPersonaSiscapCast;
import pe.gob.mimp.ms.actividadgobierno.converter.PersonaSiscapCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.TelefonoPersonaSiscapService;
import pe.gob.mimp.siscap.repository.telefonopersonasiscap.TelPerSiscapRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TelefonoPersonaSiscapServiceImpl implements TelefonoPersonaSiscapService {

    @Autowired
    private TelPerSiscapRepository telefonoPersonaSiscapRepository;

    @Override
    public void crearTelefonoPersonaSiscap(TelefonoPersonaSiscapBean telefonoPersonaSiscapBean) throws Exception {

        TelefonoPersonaSiscap telefonoPersonaSiscap = TelefonoPersonaSiscapCast.castTelefonoPersonaSiscapBeanToTelefonoPersonaSiscap(telefonoPersonaSiscapBean);

        telefonoPersonaSiscapRepository.save(telefonoPersonaSiscap);

    }

    @Override
    public void editarTelefonoPersonaSiscap(TelefonoPersonaSiscapBean telefonoPersonaSiscapBean) {

        if (telefonoPersonaSiscapBean.getNidTelefonoPersonaSiscap() == null) {
            return;
        }

        TelefonoPersonaSiscap telefonoPersonaSiscap = TelefonoPersonaSiscapCast.castTelefonoPersonaSiscapBeanToTelefonoPersonaSiscap(telefonoPersonaSiscapBean);

        telefonoPersonaSiscapRepository.save(telefonoPersonaSiscap);

    }

//    @Override
//    public List<TelefonoPersonaSiscapBean> loadTelefonoPersonaSiscapList(FindByParamBean findByParamBean) throws Exception {
//
//        if (findByParamBean.getParameters() == null) {
//            findByParamBean.setParameters(new HashMap<>());
//        }
//
//        List<TelefonoPersonaSiscap> telefonoPersonaSiscapList = telefonoPersonaSiscapRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());
//
//        if (!Util.esListaVacia(telefonoPersonaSiscapList)) {
//
//            return telefonoPersonaSiscapList.stream().map(telefonoPersonaSiscap -> {
//                TelefonoPersonaSiscapBean telefonoPersonaSiscapBean = new TelefonoPersonaSiscapBean();
//
//                telefonoPersonaSiscapBean = TelefonoPersonaSiscapCast.castTelefonoPersonaSiscapToTelefonoPersonaSiscapBean(telefonoPersonaSiscap);
//
//                return telefonoPersonaSiscapBean;
//            }).collect(Collectors.toList());
//        }
//
//        return null;
//    }
    @Override
    public List<TelefonoPersonaSiscapBean> obtenerTelefonos(PersonaSiscapBean personaSiscapBean) throws Exception {

        if (personaSiscapBean == null) {
            return null;
        }

        List<TelefonoPersonaSiscap> telefonoPersonaSiscapList = telefonoPersonaSiscapRepository.obtenerTelefonos(PersonaSiscapCast.castPersonaSiscapBeanToPersonaSiscap(personaSiscapBean));

        if (!Util.esListaVacia(telefonoPersonaSiscapList)) {

            return telefonoPersonaSiscapList.stream().map(telefonoPersonaSiscap -> {
                TelefonoPersonaSiscapBean telefonoPersonaSiscapBean = new TelefonoPersonaSiscapBean();

                telefonoPersonaSiscapBean = TelefonoPersonaSiscapCast.castTelefonoPersonaSiscapToTelefonoPersonaSiscapBean(telefonoPersonaSiscap);

                return telefonoPersonaSiscapBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public TelefonoPersonaSiscapBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<TelefonoPersonaSiscap> telefonoPersonaSiscap = telefonoPersonaSiscapRepository.findById(id);

        if (!telefonoPersonaSiscap.isPresent()) {
            return null;
        }

        return TelefonoPersonaSiscapCast.castTelefonoPersonaSiscapToTelefonoPersonaSiscapBean(telefonoPersonaSiscap.get());

    }
}
