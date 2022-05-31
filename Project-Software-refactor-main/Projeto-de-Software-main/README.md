# Projeto OO: Sistema Iface

<p align="justify"> O objetivo do projeto consiste em implementar uma rede de relacionamentos como um sistema que mantém uma rede de relacionamentos, nos moldes de
uma série de outras que há na Internet hoje em dia (Facebook, Twitter, etc.).
</p>

* <p align="justify">Alguns Usuários serão donos de comunidades, e se responsabilizarão em aceitar solicitações para entrar na comunidade</p>

* <p align="justify">Haverá usuários postando no feed que não estao relacionado em sua respectiva rede de amigos, e mesmo assim você poderá ver suas postagens, se o mesmo permitir.</p>

    - Usuário pode escolher se todos podem ver suas postagens ou apenas seus amigos.
    - Pode editar seu perfil. Mudar nome, apelido, e ate mesmo adicionar email e numero de telefone.
    - Pode fazer um backup de dados antigos como: logins alterados, mensagens enviadas.
    - Pode remover seu perfil da Rede Iface

</p>

## Sobre o projeto:
Um pacote Usuário, onde dentro possue todas as classes utilitarias:
- Community
- Menu
- Menulogin
- UserDo
- Users

* <p align="justify">Users: Uma classe absrata, onde é a base do código, possuindo todos os elementos necessarios para um usuario arraylist: friends, message, request, requestcommunity, backup, feedFriends.</p>

* <p align="justify">@verride toString para retornar informações base do usuario.</p>
 * <p align="justify">Uma função Register, onde registra o usuario no sistema(sujeita a polimorfismo).</p>

* <p align="justify">UserDo: uma Classe que herda da Super classe Users e possue um papel de construtora, onde todos o casos de implementação passa por ela. No uso de arrays e instancias.</p>

* <p align="justify">Menu: Função do Menu incial, onde ocorre os primeiros cadastros de usuarios e chama a função principal "MenuLogin".</p>

* <p align="justify">MenuLogin: Função principal do code, onde o user cadastrado acessa seu menu de login, onde esta interligado com todas as outras funcionalidades. Nessa Classe temos as funções de editar perfil, adicionar e remover amigos, enviar mensagem, criar comunidade, postar no feed e fazer backup</p>

* <p align="justify">Community: Uma classe que herda da classe UsersDo utiliza todos os dados dos usuarios e guarda os dados do usuario criador da comunidade.</p>


## Funções
|  Título        | Descrição | Progresso atual | Finalizado | 
|----------------|---------------|----------------|-----------|
| Criação de Conta  | Permita a um usuário criar uma conta no iFace. Deve ser fornecido um login, uma senha e um nome com o qual o usuário será conhecido na rede. | Concluído | <ul><li>[x] ok</li></ul>
| Criação/Edição de Perfil | Permita a um usuário cadastrado do iFace criar/editar atributos de seu perfil. Ele deve poder modificar qualquer atributo do perfil ou preencher um atributo inexistente. | Concluído | <ul><li>[x] ok</li></ul>
| Adição de Amigos  | Permita a um usuário cadastrado do iFace adicionar outro usuário como amigo, o que faz o sistema enviar-lhe um convite. O relacionamento só é efetivado quando o outro usuário o adicionar de volta. | Concluído | <ul><li>[x] ok</li></ul>
| Envio de Mensagens | Permita a um usuário cadastrado do iFace enviar um recado a qualquer outro usuário cadastrado ou comunidade. | Concluído | <ul><li>[x] ok</li></ul>
| Criação de Comunidades |Permita a um usuário cadastrado do iFace criar uma comunidade. Deve ser fornecido um nome e uma descrição. O usuário passa a ser o dono da comunidade e é o responsável por gerenciar os membros. | Concluído | <ul><li>[x] ok</li></ul>
| Adição de membros | Permita a um usuário cadastrado do iFace se tornar membro de uma comunidade. | Concluído | <ul><li>[x] ok</li></ul>
| Recuperar Informações sobre um determinado Usuário | Permita a um usuário cadastrado do iFace recuperar informações sobre o seu perfil, comunidades, amigos e mensagens. | Concluído | <ul><li>[x] ok</li></ul>
| Remoção de Conta | Permita a um usuário encerrar sua conta no iFace. Todas as suas informações devem sumir do sistema: relacionamentos, mensagens enviadas, perfil. | Concluído | <ul><li>[x] ok</li></ul>
| Envio de Mensagens no Feed de Notícias | Permita a um usuário enviar mensagens no Feed de notícias | Concluído | <ul><li>[x] ok</li></ul>
|Controle de visualização do Feed de Notícias | Permita a um usuário definir o controle de visualização das mensagens do Feed (somente amigos ou todos podem visualizar as mensagens) | Concluído | <ul><li>[x] ok</li></ul>
