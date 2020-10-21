/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.ms.actividadgobierno.converter;

import pe.gob.mimp.ms.actividadgobierno.bean.FuncionTransferidaBean;
import pe.gob.mimp.siscap.model.FuncionTransferida;

/**
 *
 * @author Omar
 */
public class FuncionTransferidaCast {

    public static FuncionTransferidaBean castFuncionTransferidaToFuncionTransferidaBean(FuncionTransferida funcionTransferida) {

        if (funcionTransferida == null) {
            return null;
        }

        FuncionTransferidaBean funcionTransferidaBean = new FuncionTransferidaBean();

        funcionTransferidaBean.setNidFuncionTransferida(funcionTransferida.getNidFuncionTransferida());
        funcionTransferidaBean.setTxtFuncionTransferida(funcionTransferida.getTxtFuncionTransferida());
        funcionTransferidaBean.setFlgActivo(funcionTransferida.getFlgActivo());
        funcionTransferidaBean.setNidUsuario(funcionTransferida.getNidUsuario());
        funcionTransferidaBean.setTxtPc(funcionTransferida.getTxtPc());
        funcionTransferidaBean.setTxtIp(funcionTransferida.getTxtIp());
        funcionTransferidaBean.setFecEdicion(funcionTransferida.getFecEdicion());
        funcionTransferidaBean.setTipoFuncionBean(TipoFuncionCast.castTipoFuncionToTipoFuncionBean(funcionTransferida.getNidTipoFuncion()));

        return funcionTransferidaBean;
    }
    
    public static FuncionTransferida castFuncionTransferidaBeanToFuncionTransferida(FuncionTransferidaBean funcionTransferidaBean) {

        if (funcionTransferidaBean == null) {
            return null;
        }

        FuncionTransferida funcionTransferida = new FuncionTransferida();

        funcionTransferida.setNidFuncionTransferida(funcionTransferidaBean.getNidFuncionTransferida());
        funcionTransferida.setTxtFuncionTransferida(funcionTransferidaBean.getTxtFuncionTransferida());
        funcionTransferida.setFlgActivo(funcionTransferidaBean.getFlgActivo());
        funcionTransferida.setNidUsuario(funcionTransferidaBean.getNidUsuario());
        funcionTransferida.setTxtPc(funcionTransferidaBean.getTxtPc());
        funcionTransferida.setTxtIp(funcionTransferidaBean.getTxtIp());
        funcionTransferida.setFecEdicion(funcionTransferidaBean.getFecEdicion());
        funcionTransferida.setNidTipoFuncion(TipoFuncionCast.castTipoFuncionBeanToTipoFuncion(funcionTransferidaBean.getTipoFuncionBean()));

        return funcionTransferida;
    }
}
