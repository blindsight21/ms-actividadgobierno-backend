/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.RendimientoBean;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;

/**
 *
 * @author Omar
 */
public interface RendimientoService {

    void crearRendimiento(RendimientoBean rendimientoBean) throws Exception;

    void editarRendimiento(RendimientoBean rendimientoBean) throws Exception;
    
    List<RendimientoBean> loadRendimientoList(FindByParamBean findByParamBean) throws Exception;

    RendimientoBean find(BigDecimal id);
}
