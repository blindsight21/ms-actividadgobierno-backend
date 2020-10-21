/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobEActGobBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

/**
 *
 * @author Omar
 */
public interface ActividadGEService {

    void crearActividadGE(ActividadGobEActGobBean actividadGobiernoBean) throws Exception;

    void editarActividadGE(ActividadGobEActGobBean actividadGobiernoBean) throws Exception;

    List<ActividadGobEActGobBean> loadActividadGEList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

}
