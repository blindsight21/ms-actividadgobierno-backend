/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.TelefonoPersonaSiscapBean;
import pe.gob.mimp.ms.actividadgobierno.bean.PersonaSiscapBean;

/**
 *
 * @author Omar
 */
public interface TelefonoPersonaSiscapService {

    void crearTelefonoPersonaSiscap(TelefonoPersonaSiscapBean telefonoPersonaSiscapBean) throws Exception;

    void editarTelefonoPersonaSiscap(TelefonoPersonaSiscapBean telefonoPersonaSiscapBean) throws Exception;

//    List<TelefonoPersonaSiscapBean> loadTelefonoPersonaSiscapList(FindByParamBean findByParamBean) throws Exception;
    List<TelefonoPersonaSiscapBean> obtenerTelefonos(PersonaSiscapBean personaSiscapBean) throws Exception;

    TelefonoPersonaSiscapBean find(BigDecimal id) throws Exception;
}
