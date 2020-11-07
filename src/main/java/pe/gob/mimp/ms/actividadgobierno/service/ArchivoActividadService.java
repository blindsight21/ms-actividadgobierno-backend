/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ArchivoActividadBean;

/**
 *
 * @author Omar
 */
public interface ArchivoActividadService {

    ArchivoActividadBean crearArchivoActividad(ArchivoActividadBean archivoActividadBean) throws Exception;

    ArchivoActividadBean editarArchivoActividad(ArchivoActividadBean archivoActividadBean) throws Exception;

    List<ArchivoActividadBean> loadArchivoActividadList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

}
