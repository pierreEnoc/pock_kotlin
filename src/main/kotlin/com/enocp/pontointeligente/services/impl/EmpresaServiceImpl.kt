package com.enocp.pontointeligente.services.impl

import com.enocp.pontointeligente.documents.Empresa
import com.enocp.pontointeligente.repositories.EmpresaRepository
import com.enocp.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {
  
  override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)
  
  override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}
