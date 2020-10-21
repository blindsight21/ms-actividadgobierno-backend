/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.repository.actividadgobresultado.ActiGobResultadoRepository;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobResultadoBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobResultadoCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.siscap.model.ActividadGobResultado;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGRService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ActividadGRServiceImpl implements ActividadGRService {

    @Autowired
    private ActiGobResultadoRepository actiGobResultadoRepository;

    @Override
    public void crearActividadGRA(ActividadGobResultadoBean actividadGRABean) throws Exception {

        ActividadGobResultado actividadGobResultado = ActividadGobResultadoCast.castActividadGobResultadoBeanToActividadGobResultado(actividadGRABean);
        actiGobResultadoRepository.save(actividadGobResultado);
    }

    @Override
    public void editarActividadGRA(ActividadGobResultadoBean actividadGRABean) throws Exception {

        if (actividadGRABean.getNidActividadGobResultado() == null) {
            return;
        }

        ActividadGobResultado actividadGobResultado = ActividadGobResultadoCast.castActividadGobResultadoBeanToActividadGobResultado(actividadGRABean);
         actiGobResultadoRepository.save(actividadGobResultado);

    }

    @Override
    public List<ActividadGobResultadoBean> loadActividadGRAList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<ActividadGobResultado> actividadGobResultadoList = actiGobResultadoRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(actividadGobResultadoList)) {

            return actividadGobResultadoList.stream().map(actividadGobResultado -> {
                return ActividadGobResultadoCast.castActividadGobResultadoToActividadGobResultadoBean(actividadGobResultado);
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = actiGobResultadoRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

}
