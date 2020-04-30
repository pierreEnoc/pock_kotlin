package com.enocp.pontointeligente.documents

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Empresa(
  val razaoSocial: String,
  val cnpj: String,
  // id do comtrole do mongo
  @Id val id: String? = null
)


