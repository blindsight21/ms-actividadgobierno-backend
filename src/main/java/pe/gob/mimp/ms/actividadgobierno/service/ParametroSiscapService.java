/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.ms.actividadgobierno.bean.FindAllByFieldBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ParametroSiscapBean;

/**
 *
 * @author Omar
 */
public interface ParametroSiscapService {

    void crearParametroSiscap(ParametroSiscapBean parametroSiscapBean) throws Exception;

    void editarParametroSiscap(ParametroSiscapBean parametroSiscapBean) throws Exception;

    List<ParametroSiscapBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;

    ParametroSiscapBean find(BigDecimal id) throws Exception;
}
