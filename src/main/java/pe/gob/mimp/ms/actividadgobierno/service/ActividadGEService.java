/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobEActGobBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.siscap.model.ActividadGobEActGob;

/**
 *
 * @author Omar
 */
public interface ActividadGEService {

    ActividadGobEActGobBean crearActividadGE(ActividadGobEActGobBean actividadGobiernoBean) throws Exception;

    ActividadGobEActGobBean editarActividadGE(ActividadGobEActGobBean actividadGobiernoBean) throws Exception;

    List<ActividadGobEActGobBean> loadActividadGEList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

}
