/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.DisponibilidadBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

/**
 *
 * @author Omar
 */
public interface DisponibilidadService {

    void crearDisponibilidad(DisponibilidadBean tipoGobiernoBean) throws Exception;
    
    void editarDisponibilidad(DisponibilidadBean tipoGobiernoBean) throws Exception;

    List<DisponibilidadBean> loadDisponibilidadList(FindByParamBean findByParamBean) throws Exception;

    DisponibilidadBean find(BigDecimal id);
}
