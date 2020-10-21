/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobPubliProcBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

/**
 *
 * @author Omar
 */
public interface ActividadGPPService {

    void crearActividadGPP(ActividadGobPubliProcBean actividadGPPBean) throws Exception;

    void editarActividadGPP(ActividadGobPubliProcBean actividadGPPBean) throws Exception;

    List<ActividadGobPubliProcBean> loadActividadGPPList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

}
