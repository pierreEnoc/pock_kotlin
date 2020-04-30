package com.enocp.pontointeligente.services.impl

import com.enocp.pontointeligente.documents.Funcionario
import com.enocp.pontointeligente.repositories.FuncionarioRepository
import com.enocp.pontointeligente.services.FunciarioService
import org.springframework.stereotype.Service


@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FunciarioService {
  override fun persistir(funcionario: Funcionario): Funcionario =
    funcionarioRepository.save(funcionario)
  
  override fun buscarPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)
  
  override fun buscarPorEMail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)
  
  override fun buscarPorId(id: String): Funcionario? = funcionarioRepository.findOne(id)
}
