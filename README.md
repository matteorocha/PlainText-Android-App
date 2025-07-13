# PlainText - Gestor de Senhas Simples para Android

## 👨‍💻 Autor

Desenvolvido por Matheus Rocha Canto (Engenharia da Computação (UFAM) - 2025/01).

## 📖 Sobre o Projeto

**PlainText** é uma aplicação Android nativa desenvolvida como um projeto de estudo na disciplina Projeto de Programas. A atividade, trabalhada em 4 passos, na criação um gestor de senhas simples e seguro, permitindo que o utilizador guarde e gira as suas credenciais de forma local e persistente no dispositivo.

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
-   **SDK Mínimo:** API 30 (Android 11.0 "R")
-   **Arquitetura:**
    -   Activities para a gestão das telas e do ciclo de vida.
    -   XML para a construção de layouts declarativos.
    -   `RecyclerView` para a exibição eficiente de listas.
    -   `SharedPreferences` para a gestão de configurações simples.
-   **Base de Dados:** SQLite para persistência de dados local.
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
