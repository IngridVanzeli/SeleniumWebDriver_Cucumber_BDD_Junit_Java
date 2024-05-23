# language: pt

  @login
  Funcionalidade: Login
    Eu como usuário do sistema
    Quero fazer login
    Para fazer uma compra no site

  Contexto: Acessar tela de login
    Dado que estou na tela de login

    @login-sucesso
    Cenário: Login com sucesso
      Quando preencho login "eduardo.finotti@qazando.com" e senha "123456"
      E clico em Login
      Então vejo mensagem de login com sucesso

   @login-email-invalido
    Esquema do Cenário: Validação "<name>"
        Quando preencho login "<user>" e senha "<password>"
        E clico em Login
        Então vejo mensagem "<message>" de campo não preenchido

     Exemplos:
      |user|password|message|name|
      |emailinvalido|123456|E-mail inválido.|E-mail inválido|
      |             |123456|E-mail inválido.|E-mail vazio|
      |eduedo@qazando|0000|E-mail inválido.|Senha inválida|
      |eduedo@qazando|    |E-mail inválido.|Senha vazia|