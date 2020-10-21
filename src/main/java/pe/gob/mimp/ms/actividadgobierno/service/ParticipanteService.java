/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ParticipanteBean;

/**
 *
 * @author Omar
 */
public interface ParticipanteService {

    void crearParticipante(ParticipanteBean participanteBean) throws Exception;

    void editarParticipante(ParticipanteBean participanteBean) throws Exception;

    List<ParticipanteBean> loadParticipanteList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

}
