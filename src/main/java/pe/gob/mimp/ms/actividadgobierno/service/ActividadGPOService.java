/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobPubliObjeBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

/**
 *
 * @author Omar
 */
public interface ActividadGPOService {

    void crearActividadGPO(ActividadGobPubliObjeBean actividadGPOBean) throws Exception;

    void editarActividadGPO(ActividadGobPubliObjeBean actividadGPOBean) throws Exception;

    List<ActividadGobPubliObjeBean> loadActividadGPOList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

}
