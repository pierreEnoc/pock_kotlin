package com.enocp.pontointeligente.repositories

import com.enocp.pontointeligente.documents.Funcionario
import org.springframework.data.mongodb.repository.MongoRepository

interface FuncionarioRepository : MongoRepository<Funcionario, String> {
  fun findByEmail(email: String): Funcionario?
  fun findByCpf(cpf: String): Funcionario?
  fun findOne(id: String): Funcionario?
}
