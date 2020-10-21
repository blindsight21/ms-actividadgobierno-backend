/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;

/**
 *
 * @author Omar
 */
public interface PersonaSiscapService {

    void crearPersonaSiscap(PersonaSiscapBean personaSiscapBean) throws Exception;

    void editarPersonaSiscap(PersonaSiscapBean personaSiscapBean) throws Exception;

    List<PersonaSiscapBean> loadPersonaSiscapList(FindByParamBean findByParamBean) throws Exception;

    PersonaSiscapBean find(BigDecimal id) throws Exception;
    
    List<PersonaSiscapBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;
}
