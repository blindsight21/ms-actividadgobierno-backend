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
import pe.gob.mimp.ms.actividadgobierno.bean.NivelEvaluacionBean;

/**
 *
 * @author Omar
 */
public interface NivelEvaluacionService {
//
    void crearNivelEvaluacion(NivelEvaluacionBean nivelEvaluacionBean) throws Exception;

    void editarNivelEvaluacion(NivelEvaluacionBean nivelEvaluacionBean) throws Exception;

    List<NivelEvaluacionBean> loadNivelEvaluacionList(FindByParamBean findByParamBean) throws Exception;

    NivelEvaluacionBean find(BigDecimal id) throws Exception;
    
//    List<NivelEvaluacionBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;
}
