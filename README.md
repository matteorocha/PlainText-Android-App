# PlainText - Gestor de Senhas Simples para Android

![Ícone da Aplicação](https://i.imgur.com/your-app-icon.png) <!-- Sugestão: Faça upload de um ícone do seu app e substitua o link -->

## 📖 Sobre o Projeto

**PlainText** é uma aplicação Android nativa desenvolvida como um projeto de estudo para a disciplina de Técnicas Avançadas de Programação. A aplicação funciona como um gestor de senhas simples e seguro, permitindo que o utilizador guarde e gira as suas credenciais de forma local e persistente no dispositivo.

O projeto cobre conceitos fundamentais do desenvolvimento Android, desde a criação de interfaces com XML até à gestão de dados com bases de dados SQLite, seguindo as melhores práticas e a arquitetura recomendada.

---

## ✨ Funcionalidades

-   **Tela de Login Segura:** Autenticação do utilizador baseada em credenciais definidas nas configurações.
-   **Configurações Personalizáveis:** Uma tela de preferências dedicada onde o utilizador pode definir o seu login, senha e outras opções da aplicação.
-   **Gestão de Senhas:**
    -   Visualização de todas as senhas guardadas numa lista limpa e organizada (`RecyclerView`).
    -   Funcionalidade para **adicionar** novas credenciais.
    -   Funcionalidade para **editar** credenciais existentes.
-   **Persistência de Dados:** Todas as senhas são guardadas de forma segura e permanente numa base de dados **SQLite** local, garantindo que os dados não se percam ao fechar a aplicação.
-   **Interface Intuitiva:** Design consistente e amigável, utilizando componentes do Material Design.

---

## 🛠️ Tecnologias Utilizadas

-   **Linguagem:** Java
-   **IDE:** Android Studio
-   **SDK Mínimo:** API 21 (Android 5.0 Lollipop)
-   **Arquitetura:**
    -   Activities para a gestão das telas e do ciclo de vida.
    -   XML para a construção de layouts declarativos.
    -   `RecyclerView` para a exibição eficiente de listas.
    -   `SharedPreferences` para a gestão de configurações simples.
-   **Base de Dados:** SQLite para persistência de dados local.

---

## 🚀 Como Executar

Para compilar e executar o projeto localmente, siga estes passos:

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/PlainText.git](https://github.com/seu-usuario/PlainText.git)
    ```
2.  **Abra no Android Studio:**
    -   Inicie o Android Studio.
    -   Selecione "Open an existing Project".
    -   Navegue até à pasta onde clonou o repositório e selecione-a.
3.  **Sincronize o Gradle:** Aguarde o Android Studio sincronizar e descarregar todas as dependências necessárias.
4.  **Execute a Aplicação:**
    -   Selecione um emulador (AVD) ou conecte um dispositivo físico com a depuração USB ativada.
    -   Clique no botão "Run 'app'" (ícone de play verde).

---

## 🏗️ Estrutura do Projeto

O projeto está organizado da seguinte forma:

-   `MainActivity.java`: A tela de login inicial e ponto de entrada após a autenticação.
-   `ListActivity.java`: Exibe a lista de senhas guardadas utilizando um `RecyclerView`.
-   `EditActivity.java`: Um formulário para adicionar ou editar uma entrada de senha.
-   `PreferencesActivity.java`: Tela de configurações da aplicação.
-   `Password.java`: A classe de modelo (POJO) que representa uma única senha.
-   `PasswordDAO.java`: A classe "Data Access Object" responsável por toda a comunicação com a base de dados SQLite.
-   `Database.java`: A classe auxiliar que estende `SQLiteOpenHelper` para criar e gerir a versão da base de dados.

---

## 🖼️ Telas da Aplicação

<p align="center">
  <img src="https://i.imgur.com/your-login-screen.png" width="200" alt="Tela de Login">
  <img src="https://i.imgur.com/your-list-screen.png" width="200" alt="Tela da Lista">
  <img src="https://i.imgur.com/your-edit-screen.png" width="200" alt="Tela de Edição">
</p>

---

## 👨‍💻 Autor

Desenvolvido por Matheus Rocha Canto (Engenharia da Computação (UFAM) - 2025/01).
