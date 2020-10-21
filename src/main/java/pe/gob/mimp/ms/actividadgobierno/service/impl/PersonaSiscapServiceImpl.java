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
import pe.gob.mimp.ms.actividadgobierno.bean.FindAllByFieldBean;
import pe.gob.mimp.siscap.model.PersonaSiscap;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.converter.PersonaSiscapCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.PersonaSiscapService;
import pe.gob.mimp.siscap.repository.personasiscap.PersoSiscapRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PersonaSiscapServiceImpl implements PersonaSiscapService {

    @Autowired
    private PersoSiscapRepository personaSiscapRepository;

    @Override
    public void crearPersonaSiscap(PersonaSiscapBean personaSiscapBean) throws Exception {

        PersonaSiscap personaSiscap = PersonaSiscapCast.castPersonaSiscapBeanToPersonaSiscap(personaSiscapBean);

        personaSiscapRepository.save(personaSiscap);

    }

    @Override
    public void editarPersonaSiscap(PersonaSiscapBean personaSiscapBean) {

        if (personaSiscapBean.getNidPersonaSiscap() == null) {
            return;
        }

        PersonaSiscap personaSiscap = PersonaSiscapCast.castPersonaSiscapBeanToPersonaSiscap(personaSiscapBean);

        personaSiscapRepository.save(personaSiscap);

    }

    @Override
    public List<PersonaSiscapBean> loadPersonaSiscapList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<PersonaSiscap> personaSiscapList = personaSiscapRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(personaSiscapList)) {

            return personaSiscapList.stream().map(personaSiscap -> {
                PersonaSiscapBean personaSiscapBean = new PersonaSiscapBean();

                personaSiscapBean = PersonaSiscapCast.castPersonaSiscapToPersonaSiscapBean(personaSiscap);

                return personaSiscapBean;
            }).collect(Collectors.toList());
        }

        return null;
    }
    
    @Override
    public List<PersonaSiscapBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        if (findAllByFieldBean == null) {
            return null;
        }

        List<PersonaSiscap> personaSiscapList = personaSiscapRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if (Util.esListaVacia(personaSiscapList)) {
            return null;
        }

        return personaSiscapList.stream().map(personaSiscap -> {
            PersonaSiscapBean personaSiscapBean = new PersonaSiscapBean();

            personaSiscapBean = PersonaSiscapCast.castPersonaSiscapToPersonaSiscapBean(personaSiscap);

            return personaSiscapBean;
        }).collect(Collectors.toList());

    }

    @Override
    public PersonaSiscapBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<PersonaSiscap> personaSiscap = personaSiscapRepository.findById(id);

        if (!personaSiscap.isPresent()) {
            return null;
        }

        return PersonaSiscapCast.castPersonaSiscapToPersonaSiscapBean(personaSiscap.get());

    }
}
