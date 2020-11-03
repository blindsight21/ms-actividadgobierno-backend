/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobResultadoBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

/**
 *
 * @author Omar
 */
public interface ActividadGRService {

    ActividadGobResultadoBean crearActividadGRA(ActividadGobResultadoBean actividadGRABean) throws Exception;

    ActividadGobResultadoBean editarActividadGRA(ActividadGobResultadoBean actividadGRABean) throws Exception;

    List<ActividadGobResultadoBean> loadActividadGRAList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

}
