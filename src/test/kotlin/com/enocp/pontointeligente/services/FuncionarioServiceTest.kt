package com.enocp.pontointeligente.services

import com.enocp.pontointeligente.documents.Funcionario
import com.enocp.pontointeligente.enums.PerfilEnum
import com.enocp.pontointeligente.repositories.FuncionarioRepository
import com.enocp.pontointeligente.utils.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {
  
  @MockBean
  private val funcinarioRepository: FuncionarioRepository? = null
  
  @Autowired
  private val funciarioService: FunciarioService? = null
  
  private val email: String = "email@email.com"
  private val cpf: String = "34234855948"
  private val id: String = "1"
  
  @Before
  @Throws(Exception::class)
  fun setUp() {
    val willReturn = BDDMockito.given(funcinarioRepository?.save(Mockito.any(Funcionario::class.java)))
      .willReturn(funcionario())
    BDDMockito.given(funcinarioRepository?.findOne(id)).willReturn(funcionario())
    BDDMockito.given(funcinarioRepository?.findByEmail(email)).willReturn(funcionario())
    BDDMockito.given(funcinarioRepository?.findByCpf(cpf)).willReturn(funcionario())
    
  }
  
  @Test
  fun testPersistirFuncionario() {
    val funcionario: Funcionario? = this.funciarioService?.persistir(funcionario())
    Assert.assertNotNull(funcionario)
  }
  
  @Test
  fun testBuscarFuncionarioPorCpf() {
    val funcionario: Funcionario? = this.funciarioService?.buscarPorCpf(cpf)
    Assert.assertNotNull(funcionario)
  }
  
  @Test
  fun testBuscarFuncionarioPorEmail() {
    val funcionario: Funcionario? = this.funciarioService?.buscarPorEMail(email)
    Assert.assertNotNull(funcionario)
  }
  
  @Test
  fun testBuscarFuncionarioPorId() {
    val funcionario: Funcionario? = this.funciarioService?.buscarPorId(id)
  }
  
  
  private fun funcionario(): Funcionario =
    Funcionario("Nome", email, SenhaUtils().gerarBcrypt("123456"),
      cpf, PerfilEnum.ROLE_USUARIO, id)
}