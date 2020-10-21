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
import pe.gob.mimp.siscap.model.Participante;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ParticipanteBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobCast;
import pe.gob.mimp.ms.actividadgobierno.converter.ParticipanteCast;
import pe.gob.mimp.ms.actividadgobierno.converter.PersonaSiscapCast;
import pe.gob.mimp.ms.actividadgobierno.converter.PublicoObjetivoCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.ParticipanteService;
import pe.gob.mimp.siscap.repository.participante.ParticipanteRepository;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Override
    public void crearParticipante(ParticipanteBean participanteBean) throws Exception {

        Participante participante = ParticipanteCast.castParticipanteBeanToParticipante(participanteBean);
        participanteRepository.save(participante);

    }

    @Override
    public void editarParticipante(ParticipanteBean participanteBean) {

        if (participanteBean.getNidParticipante() == null) {
            return;
        }

        Participante participante = ParticipanteCast.castParticipanteBeanToParticipante(participanteBean);
        participanteRepository.save(participante);

    }

    @Override
    public List<ParticipanteBean> loadParticipanteList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<Participante> participanteList = participanteRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(participanteList)) {

            return participanteList.stream().map(participante -> {
                return ParticipanteCast.castParticipanteToParticipanteBean(participante);
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = participanteRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

}
