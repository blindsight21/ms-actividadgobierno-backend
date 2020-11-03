/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobPubliProcBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.siscap.model.ActividadGobPubliProc;

/**
 *
 * @author Omar
 */
public interface ActividadGPPService {

    ActividadGobPubliProcBean crearActividadGPP(ActividadGobPubliProcBean actividadGPPBean) throws Exception;

    ActividadGobPubliProcBean editarActividadGPP(ActividadGobPubliProcBean actividadGPPBean) throws Exception;

    List<ActividadGobPubliProcBean> loadActividadGPPList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

}
