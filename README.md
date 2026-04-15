# Loja Virtual - Cadastro de Eletrônicos 📱💻

Este é um projeto de estudo desenvolvido em Android nativo (Kotlin) para o gerenciamento de estoque de produtos eletrônicos. O aplicativo permite o cadastro de itens com validações rigorosas e a visualização em uma lista moderna e organizada.

## ✨ Funcionalidades

- **Cadastro de Produtos**: Registro de nome, código identificador, preço e quantidade em estoque.
- **Validações de Dados**: 
  - Todos os campos são obrigatórios.
  - O preço deve ser um valor positivo.
  - A quantidade deve ser um número inteiro positivo.
- **Listagem em Tempo Real**: Visualização de todos os produtos cadastrados utilizando `RecyclerView`.
- **Persistência Local**: Uso do banco de dados **Room** para salvar as informações permanentemente no dispositivo.

## 🎨 Interface (Design)

O aplicativo utiliza os princípios do **Material Design**, apresentando:
- Tema visual moderno em tons de **Verde**.
- Componentes em **Cards** com elevação para melhor separação visual.
- Layout responsivo com `ConstraintLayout`.
- Inputs com ícones para melhorar a experiência do usuário (UX).

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: [Kotlin](https://kotlinlang.org/)
- **Banco de Dados**: [Room Persistence Library](https://developer.android.com/training/data-storage/room)
- **Componentes de UI**: Material Components, RecyclerView, CardView, ConstraintLayout.
- **Assincronismo**: Kotlin Coroutines para operações de banco de dados fora da Main Thread.
- **Build System**: Gradle (Kotlin DSL).

## 🚀 Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/isaquebersalim/loja-Virtual.git
   ```
2. Abra o projeto no **Android Studio** (versão Hedgehog ou superior recomendada).
3. Aguarde o **Gradle Sync** finalizar.
4. Execute o app em um emulador ou dispositivo físico com Android 7.0 (API 24) ou superior.

## 👤 Autor

**Isaque Bersalim**  
- GitHub: [@isaquebersalim](https://github.com/isaquebersalim)  
- E-mail: isaquebersalim@gmail.com

---
*Este projeto foi desenvolvido com foco em boas práticas de desenvolvimento Android e organização de código.*
