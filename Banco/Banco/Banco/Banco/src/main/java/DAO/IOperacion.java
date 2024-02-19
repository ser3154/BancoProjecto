/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTOS.OperacionDTO;
import DTOS.RetiroSinTarjetaDTO;
import DTOS.TransferenciaDTO;
import Dominio.Operacion;
import Dominio.RetiroSinTarjeta;
import Dominio.Transferencia;
import Exceptiones.PersisteciaException;

/**
 *
 * @author Serva
 */
public interface IOperacion {
    public Operacion nuevaOperacion (OperacionDTO operacion) throws PersisteciaException;
    public Transferencia nuevaTransferencia (TransferenciaDTO transferencia) throws PersisteciaException;
    public RetiroSinTarjeta nuevaRetiroSinTarjeta(RetiroSinTarjetaDTO retiroSinTarjeta) throws PersisteciaException;
   
    
    
}
