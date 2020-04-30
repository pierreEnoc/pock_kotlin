package com.enocp.pontointeligente.services

import com.enocp.pontointeligente.documents.Funcionario

interface FunciarioService {
  fun persistir(funcionario: Funcionario): Funcionario
  fun buscarPorCpf(cpf: String): Funcionario?
  fun buscarPorEMail(email: String): Funcionario?
  fun buscarPorId(id: String): Funcionario?
}
