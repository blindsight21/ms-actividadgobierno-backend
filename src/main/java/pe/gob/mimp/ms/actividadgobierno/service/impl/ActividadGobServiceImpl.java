/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.ActividadGob;
import pe.gob.mimp.siscap.repository.actividadGob.ActiGobRepository;
import pe.gob.mimp.ms.actividadgobierno.bean.FindByParamBean;
import pe.gob.mimp.ms.actividadgobierno.bean.ActividadGobBean;
import pe.gob.mimp.ms.actividadgobierno.converter.ActividadGobCast;
import pe.gob.mimp.ms.actividadgobierno.converter.FuncionTransferidaCast;
import pe.gob.mimp.ms.actividadgobierno.converter.GobiernoCast;
import pe.gob.mimp.ms.actividadgobierno.converter.ModalidadActividadCast;
import pe.gob.mimp.ms.actividadgobierno.converter.TipoModalidadCast;
import pe.gob.mimp.ms.actividadgobierno.converter.TipoObjetivoCast;
import pe.gob.mimp.ms.actividadgobierno.util.Util;
import pe.gob.mimp.ms.actividadgobierno.service.ActividadGobService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ActividadGobServiceImpl implements ActividadGobService {

    @Autowired
    private ActiGobRepository actividadGobiernoRepository;

    @Override
    public void crearActividadGob(ActividadGobBean actividadGobiernoBean) throws Exception {

        ActividadGob actividadGobierno = new ActividadGob();
        actividadGobierno.setNidActividadGob(actividadGobiernoBean.getNidActividadGob());
        actividadGobierno.setTxtObjetivo(actividadGobiernoBean.getTxtObjetivo());
        actividadGobierno.setTxtTema(actividadGobiernoBean.getTxtTema());
        actividadGobierno.setFecInicio(actividadGobiernoBean.getFecInicio());
        actividadGobierno.setFecFin(actividadGobiernoBean.getFecFin());
        actividadGobierno.setFecCreacion(actividadGobiernoBean.getFecCreacion());
        actividadGobierno.setNumAnio(actividadGobiernoBean.getNumAnio());
        actividadGobierno.setNumTrimestre(actividadGobiernoBean.getNumTrimestre());
        actividadGobierno.setTxtObservacionEliminado(actividadGobiernoBean.getTxtObservacionEliminado());

        actividadGobierno.setNidUsuario(actividadGobiernoBean.getNidUsuario());
        actividadGobierno.setTxtPc(actividadGobiernoBean.getTxtPc());
        actividadGobierno.setTxtIp(actividadGobiernoBean.getTxtIp());
        actividadGobierno.setFecEdicion(actividadGobiernoBean.getFecEdicion());
        actividadGobierno.setFlgActivo(actividadGobiernoBean.getFlgActivo());

        actividadGobierno.setNidArea(actividadGobiernoBean.getNidArea());
        actividadGobierno.setNidDepartamento(actividadGobiernoBean.getNidDepartamento());
        actividadGobierno.setTxtResponsableApepat(actividadGobiernoBean.getTxtResponsableApepat());
        actividadGobierno.setTxtResponsableApemat(actividadGobiernoBean.getTxtResponsableApemat());
        actividadGobierno.setTxtResponsableNombre(actividadGobiernoBean.getTxtResponsableNombre());
        actividadGobierno.setTxtResponsableTelef(actividadGobiernoBean.getTxtResponsableTelef());
        actividadGobierno.setTxtResponsableCorreo(actividadGobiernoBean.getTxtResponsableCorreo());
        actividadGobierno.setNumContadorMasculino(actividadGobiernoBean.getNumContadorMasculino());
        actividadGobierno.setNumContadorFemenino(actividadGobiernoBean.getNumContadorFemenino());
        actividadGobierno.setNumContadorTotal(actividadGobiernoBean.getNumContadorTotal());
        actividadGobierno.setTxtJustificacionReprogramado(actividadGobiernoBean.getTxtJustificacionReprogramado());
        actividadGobierno.setTxtJustificacionAnulado(actividadGobiernoBean.getTxtJustificacionAnulado());

        actividadGobierno.setNidTipoObjetivo(TipoObjetivoCast.castTipoObjetivoBeanToTipoObjetivo(actividadGobiernoBean.getTipoObjetivoBean()));
        actividadGobierno.setNidTipoModalidad(TipoModalidadCast.castTipoModalidadBeanToTipoModalidad(actividadGobiernoBean.getTipoModalidadBean()));
        actividadGobierno.setNidModalidadActividad(ModalidadActividadCast.castModalidadActividadBeanToModalidadActividad(actividadGobiernoBean.getModalidadActividadBean()));
        actividadGobierno.setNidGobierno(GobiernoCast.castGobiernoBeanToGobierno(actividadGobiernoBean.getGobiernoBean()));
        actividadGobierno.setNidFuncionTransferida(FuncionTransferidaCast.castFuncionTransferidaBeanToFuncionTransferida(actividadGobiernoBean.getFuncionTransferidaBean()));

        actividadGobierno.setNidTipoFuncion(actividadGobiernoBean.getNidTipoFuncion());
        actividadGobierno.setNidTipoGobierno(actividadGobiernoBean.getNidTipoGobierno());
        actividadGobierno.setNidEstadoActividad(actividadGobierno.getNidEstadoActividad());

        actividadGobiernoRepository.save(actividadGobierno);

    }

    @Override
    public void editarActividadGob(ActividadGobBean actividadGobiernoBean) {

        if (actividadGobiernoBean.getNidActividadGob() == null) {
            return;
        }

        ActividadGob actividadGobierno = new ActividadGob();

        actividadGobierno.setNidActividadGob(actividadGobiernoBean.getNidActividadGob());
        actividadGobierno.setTxtObjetivo(actividadGobiernoBean.getTxtObjetivo());
        actividadGobierno.setTxtTema(actividadGobiernoBean.getTxtTema());
        actividadGobierno.setFecInicio(actividadGobiernoBean.getFecInicio());
        actividadGobierno.setFecFin(actividadGobiernoBean.getFecFin());
        actividadGobierno.setFecCreacion(actividadGobiernoBean.getFecCreacion());
        actividadGobierno.setNumAnio(actividadGobiernoBean.getNumAnio());
        actividadGobierno.setNumTrimestre(actividadGobiernoBean.getNumTrimestre());
        actividadGobierno.setTxtObservacionEliminado(actividadGobiernoBean.getTxtObservacionEliminado());

        actividadGobierno.setNidUsuario(actividadGobiernoBean.getNidUsuario());
        actividadGobierno.setTxtPc(actividadGobiernoBean.getTxtPc());
        actividadGobierno.setTxtIp(actividadGobiernoBean.getTxtIp());
        actividadGobierno.setFecEdicion(actividadGobiernoBean.getFecEdicion());
        actividadGobierno.setFlgActivo(actividadGobiernoBean.getFlgActivo());

        actividadGobierno.setNidArea(actividadGobiernoBean.getNidArea());
        actividadGobierno.setNidDepartamento(actividadGobiernoBean.getNidDepartamento());
        actividadGobierno.setTxtResponsableApepat(actividadGobiernoBean.getTxtResponsableApepat());
        actividadGobierno.setTxtResponsableApemat(actividadGobiernoBean.getTxtResponsableApemat());
        actividadGobierno.setTxtResponsableNombre(actividadGobiernoBean.getTxtResponsableNombre());
        actividadGobierno.setTxtResponsableTelef(actividadGobiernoBean.getTxtResponsableTelef());
        actividadGobierno.setTxtResponsableCorreo(actividadGobiernoBean.getTxtResponsableCorreo());
        actividadGobierno.setNumContadorMasculino(actividadGobiernoBean.getNumContadorMasculino());
        actividadGobierno.setNumContadorFemenino(actividadGobiernoBean.getNumContadorFemenino());
        actividadGobierno.setNumContadorTotal(actividadGobiernoBean.getNumContadorTotal());
        actividadGobierno.setTxtJustificacionReprogramado(actividadGobiernoBean.getTxtJustificacionReprogramado());
        actividadGobierno.setTxtJustificacionAnulado(actividadGobiernoBean.getTxtJustificacionAnulado());

        actividadGobierno.setNidTipoObjetivo(TipoObjetivoCast.castTipoObjetivoBeanToTipoObjetivo(actividadGobiernoBean.getTipoObjetivoBean()));
        actividadGobierno.setNidTipoModalidad(TipoModalidadCast.castTipoModalidadBeanToTipoModalidad(actividadGobiernoBean.getTipoModalidadBean()));
        actividadGobierno.setNidModalidadActividad(ModalidadActividadCast.castModalidadActividadBeanToModalidadActividad(actividadGobiernoBean.getModalidadActividadBean()));
        actividadGobierno.setNidGobierno(GobiernoCast.castGobiernoBeanToGobierno(actividadGobiernoBean.getGobiernoBean()));
        actividadGobierno.setNidFuncionTransferida(FuncionTransferidaCast.castFuncionTransferidaBeanToFuncionTransferida(actividadGobiernoBean.getFuncionTransferidaBean()));

        actividadGobierno.setNidTipoFuncion(actividadGobiernoBean.getNidTipoFuncion());
        actividadGobierno.setNidTipoGobierno(actividadGobiernoBean.getNidTipoGobierno());
        actividadGobierno.setNidEstadoActividad(actividadGobierno.getNidEstadoActividad());

        actividadGobiernoRepository.save(actividadGobierno);

    }

    @Override
    public List<ActividadGobBean> loadActividadGobList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<ActividadGob> actividadGobiernoList = actividadGobiernoRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(actividadGobiernoList)) {

            return actividadGobiernoList.stream().map(actividadGobierno -> {
                ActividadGobBean actividadGobiernoBean = new ActividadGobBean();

                actividadGobiernoBean.setNidActividadGob(actividadGobierno.getNidActividadGob());
                actividadGobiernoBean.setTxtObjetivo(actividadGobierno.getTxtObjetivo());
                actividadGobiernoBean.setTxtTema(actividadGobierno.getTxtTema());
                actividadGobiernoBean.setFecInicio(actividadGobierno.getFecInicio());
                actividadGobiernoBean.setFecFin(actividadGobierno.getFecFin());
                actividadGobiernoBean.setFecCreacion(actividadGobierno.getFecCreacion());
                actividadGobiernoBean.setNumAnio(actividadGobierno.getNumAnio());
                actividadGobiernoBean.setNumTrimestre(actividadGobierno.getNumTrimestre());
                actividadGobiernoBean.setTxtObservacionEliminado(actividadGobierno.getTxtObservacionEliminado());

                actividadGobiernoBean.setNidUsuario(actividadGobierno.getNidUsuario());
                actividadGobiernoBean.setTxtPc(actividadGobierno.getTxtPc());
                actividadGobiernoBean.setTxtIp(actividadGobierno.getTxtIp());
                actividadGobiernoBean.setFecEdicion(actividadGobierno.getFecEdicion());
                actividadGobiernoBean.setFlgActivo(actividadGobierno.getFlgActivo());

                actividadGobiernoBean.setNidArea(actividadGobierno.getNidArea());
                actividadGobiernoBean.setNidDepartamento(actividadGobierno.getNidDepartamento());
                actividadGobiernoBean.setTxtResponsableApepat(actividadGobierno.getTxtResponsableApepat());
                actividadGobiernoBean.setTxtResponsableApemat(actividadGobierno.getTxtResponsableApemat());
                actividadGobiernoBean.setTxtResponsableNombre(actividadGobierno.getTxtResponsableNombre());
                actividadGobiernoBean.setTxtResponsableTelef(actividadGobierno.getTxtResponsableTelef());
                actividadGobiernoBean.setTxtResponsableCorreo(actividadGobierno.getTxtResponsableCorreo());
                actividadGobiernoBean.setNumContadorMasculino(actividadGobierno.getNumContadorMasculino());
                actividadGobiernoBean.setNumContadorFemenino(actividadGobierno.getNumContadorFemenino());
                actividadGobiernoBean.setNumContadorTotal(actividadGobierno.getNumContadorTotal());
                actividadGobiernoBean.setTxtJustificacionReprogramado(actividadGobierno.getTxtJustificacionReprogramado());
                actividadGobiernoBean.setTxtJustificacionAnulado(actividadGobierno.getTxtJustificacionAnulado());

                actividadGobiernoBean.setTipoObjetivoBean(TipoObjetivoCast.castTipoObjetivoToTipoObjetivoBean(actividadGobierno.getNidTipoObjetivo()));
                actividadGobiernoBean.setTipoModalidadBean(TipoModalidadCast.castTipoModalidadToTipoModalidadBean(actividadGobierno.getNidTipoModalidad()));
                actividadGobiernoBean.setModalidadActividadBean(ModalidadActividadCast.castModalidadActividadToModalidadActividadBean(actividadGobierno.getNidModalidadActividad()));
                actividadGobiernoBean.setGobiernoBean(GobiernoCast.castGobiernoToGobiernoBean(actividadGobierno.getNidGobierno()));
                actividadGobiernoBean.setFuncionTransferidaBean(FuncionTransferidaCast.castFuncionTransferidaToFuncionTransferidaBean(actividadGobierno.getNidFuncionTransferida()));

                actividadGobiernoBean.setNidTipoFuncion(actividadGobierno.getNidTipoFuncion());
                actividadGobiernoBean.setNidTipoGobierno(actividadGobierno.getNidTipoGobierno());
                actividadGobiernoBean.setNidEstadoActividad(actividadGobierno.getNidEstadoActividad());

                return actividadGobiernoBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = actividadGobiernoRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }
    
    @Override
    public ActividadGobBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<ActividadGob> actividadGob = actividadGobiernoRepository.findById(id);

        if (!actividadGob.isPresent()) {
            return null;
        }

        return ActividadGobCast.castActividadGobToActividadGobBean(actividadGob.get());

    }

}
