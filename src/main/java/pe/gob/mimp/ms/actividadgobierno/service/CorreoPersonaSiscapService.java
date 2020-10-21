/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.CorreoPersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;

/**
 *
 * @author Omar
 */
public interface CorreoPersonaSiscapService {

    void crearCorreoPersonaSiscap(CorreoPersonaSiscapBean correoPersonaSiscapBean) throws Exception;

    void editarCorreoPersonaSiscap(CorreoPersonaSiscapBean correoPersonaSiscapBean) throws Exception;

//    List<CorreoPersonaSiscapBean> loadCorreoPersonaSiscapList(FindByParamBean findByParamBean) throws Exception;

    List<CorreoPersonaSiscapBean> obtenerCorreos(PersonaSiscapBean personaSiscapBean) throws Exception;
    
    CorreoPersonaSiscapBean find(BigDecimal id) throws Exception;
}
