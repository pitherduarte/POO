# Atividade Bônus — Git e GitHub

**Nome:** Pither Mikael Gonçalves Duarte  
**Matrícula:** 202600679  
**Disciplina:** Programação Orientada a Objetos

Nesta atividade, utilizei o Git para controlar as versões de arquivos e o GitHub para armazenar o repositório. Os procedimentos seguiram o [tutorial de Git do professor](https://github.com/marceloakira/tutorials/blob/main/git/tutorial_git.md).

## 1. Repositório e clonagem

Utilizei o repositório público [POO](https://github.com/pitherduarte/POO), criado na minha conta do GitHub.

![Repositório no GitHub](evidencias/01-repositorio-publico.jpg)

Para fazer uma cópia no computador, utilizei:

```bash
git clone https://github.com/pitherduarte/POO.git
cd POO
```

## 2. Alterações e commits

Na branch `main`, criei a pasta da atividade e o arquivo `exemplo.txt`. Depois utilizei:

```bash
git status
git add .
git commit -m "Adiciona atividade de Git"
git push origin main
```

O `git status` mostra as alterações, `git add` prepara os arquivos, `git commit` registra uma versão e `git push` envia essa versão ao GitHub.

![Commit na main](evidencias/02-commit-main-github.jpg)

## 3. Criando uma branch

Criei a branch `bonus-git` e mudei para ela:

```bash
git branch bonus-git
git checkout bonus-git
git branch
```

Nessa branch, alterei o arquivo `exemplo.txt` e registrei a mudança:

```bash
git add .
git commit -m "Altera arquivo de exemplo"
git push --set-upstream origin bonus-git
```

![Commit na branch bonus-git](evidencias/03-commit-bonus-github.jpg)

![Branch publicada no GitHub](evidencias/04-branch-publicada.jpg)

## 4. Histórico de versões

Para consultar os commits e as branches, utilizei:

```bash
git log --oneline --all --graph --decorate
git branch -a
```

O histórico mostra os commits realizados, e a lista de branches permite verificar a `main` e a `bonus-git`.

![Histórico de commits](evidencias/05-historico-github.jpg)

![Branches no GitHub](evidencias/06-branches-github.jpg)

O arquivo `exemplo.txt` ficou com uma versão na `main` e outra na `bonus-git`, sem fazer merge entre elas.
