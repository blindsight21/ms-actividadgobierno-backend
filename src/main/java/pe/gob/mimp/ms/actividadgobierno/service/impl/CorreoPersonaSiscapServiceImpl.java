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
import pe.gob.mimp.siscap.model.CorreoPersonaSiscap;
import pe.gob.mimp.ms.actividadgobierno.bean.CorreoPersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.converter.CorreoPersonaSiscapCast;
import pe.gob.mimp.ms.actividadgobierno.converter.PersonaSiscapCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.CorreoPersonaSiscapService;
import pe.gob.mimp.siscap.repository.correopersonasiscap.CorrPerSiscapRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CorreoPersonaSiscapServiceImpl implements CorreoPersonaSiscapService {

    @Autowired
    private CorrPerSiscapRepository correoPersonaSiscapRepository;

    @Override
    public void crearCorreoPersonaSiscap(CorreoPersonaSiscapBean correoPersonaSiscapBean) throws Exception {

        CorreoPersonaSiscap correoPersonaSiscap = CorreoPersonaSiscapCast.castCorreoPersonaSiscapBeanToCorreoPersonaSiscap(correoPersonaSiscapBean);

        correoPersonaSiscapRepository.save(correoPersonaSiscap);

    }

    @Override
    public void editarCorreoPersonaSiscap(CorreoPersonaSiscapBean correoPersonaSiscapBean) {

        if (correoPersonaSiscapBean.getNidCorreoPersonaSiscap() == null) {
            return;
        }

        CorreoPersonaSiscap correoPersonaSiscap = CorreoPersonaSiscapCast.castCorreoPersonaSiscapBeanToCorreoPersonaSiscap(correoPersonaSiscapBean);

        correoPersonaSiscapRepository.save(correoPersonaSiscap);

    }

//    @Override
//    public List<CorreoPersonaSiscapBean> loadCorreoPersonaSiscapList(FindByParamBean findByParamBean) throws Exception {
//
//        if (findByParamBean.getParameters() == null) {
//            findByParamBean.setParameters(new HashMap<>());
//        }
//
//        List<CorreoPersonaSiscap> correoPersonaSiscapList = correoPersonaSiscapRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());
//
//        if (!Util.esListaVacia(correoPersonaSiscapList)) {
//
//            return correoPersonaSiscapList.stream().map(correoPersonaSiscap -> {
//                CorreoPersonaSiscapBean correoPersonaSiscapBean = new CorreoPersonaSiscapBean();
//
//                correoPersonaSiscapBean = CorreoPersonaSiscapCast.castCorreoPersonaSiscapToCorreoPersonaSiscapBean(correoPersonaSiscap);
//
//                return correoPersonaSiscapBean;
//            }).collect(Collectors.toList());
//        }
//
//        return null;
//    }
    @Override
    public List<CorreoPersonaSiscapBean> obtenerCorreos(PersonaSiscapBean personaSiscapBean) throws Exception {

        if (personaSiscapBean == null) {
            return null;
        }

        List<CorreoPersonaSiscap> correoPersonaSiscapList = correoPersonaSiscapRepository.obtenerCorreos(PersonaSiscapCast.castPersonaSiscapBeanToPersonaSiscap(personaSiscapBean));

        if (!Util.esListaVacia(correoPersonaSiscapList)) {

            return correoPersonaSiscapList.stream().map(correoPersonaSiscap -> {
                CorreoPersonaSiscapBean correoPersonaSiscapBean = new CorreoPersonaSiscapBean();

                correoPersonaSiscapBean = CorreoPersonaSiscapCast.castCorreoPersonaSiscapToCorreoPersonaSiscapBean(correoPersonaSiscap);

                return correoPersonaSiscapBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public CorreoPersonaSiscapBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<CorreoPersonaSiscap> correoPersonaSiscap = correoPersonaSiscapRepository.findById(id);

        if (!correoPersonaSiscap.isPresent()) {
            return null;
        }

        return CorreoPersonaSiscapCast.castCorreoPersonaSiscapToCorreoPersonaSiscapBean(correoPersonaSiscap.get());

    }
}
