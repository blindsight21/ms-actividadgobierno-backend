/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobBean;

/**
 *
 * @author Omar
 */
public interface ActividadGobService {

    void crearActividadGob(ActividadGobBean actividadGobBean) throws Exception;

    void editarActividadGob(ActividadGobBean actividadGobBean) throws Exception;

    List<ActividadGobBean> loadActividadGobList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    ActividadGobBean find(BigDecimal id) throws Exception;
    
}
