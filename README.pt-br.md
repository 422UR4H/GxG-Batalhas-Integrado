[![en](https://img.shields.io/badge/lang-en-red.svg)](https://github.com/422UR4H/GxG-Batalhas-Integrado/blob/main/README.md)

# GxG Batalhas: Integrado

Um aplicativo Desktop Java desenvolvido para gerenciar gameplays do Hunter X Hunter RPG System.

![AnimaçãoBatalhas](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/b3db066c-fc58-41c1-9a6e-343a26fbdb01)

## Descrição

Este programa evoluiu de sua primeira versão CLI escrita em C (para Windows).<br />
Ele integra o gerador, treinador e editor de fichas/personagens, gerenciador de habilidades e de batalhas em um único sistema.<br />
Esta é uma aplicação desenvolvida no Netbeans IDE usando Java Language com PostgreSQL para o bando de dados.<br />
A arquitetura não tem padrão, pois eu era um desenvolvedor amador que ainda viria a me tornar um profissional, ainda não conhecia os princípios SOLID, design patterns e nem mesmo o Client-Server pattern.<br />
Porém, este projeto carrega grande parte da minha paixão por desenvolvimento e RPG, sendo o principal motivo pelo qual me tornei desenvolvedor de software.<br />
E, por isso, estou criando uma aplicação web como gratidão à esse projeto que norteou minha vida profissional, mas também para deixar esse software/sistema gratuito para amantes de RPG e Hunter X Hunter.

## Demo

### Link de Download do Software:

```url
https://mega.nz/file/G0wFkCgQ#WdpVOMXqvipGcH_5YzTAXG0TYt2sdAIdCVV2rvBbKXI
```

## Quick start

Clone o repositório e abra na sua IDE favorita.

```bash
git clone https://github.com/422UR4H/GxG-Batalhas-Integrado
```

## Uso

Antes de comegar, preciso dizer que este é um sistema extenso e não poderia ser totalmente abordado aqui, então me limitarei a explicar o básico do funcionamento. Entre, explore e se divirta como um Hunter!

### Menus e Ficha

![AnimaçãoMenu](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/6ee0a9c0-d3b5-490f-8c45-244a495f4cbf)

### Gerador

Clique em "Executar Gerador 1.0" para abrir o gerador.<br />
Insira o formulário de perfil do personagem, como o seu nick (que deve ser único no sistema, ou gerará um erro).<br />
Escolha a classe dentre as disponíveis, bem como a categoria Nen, alinhamento e especialidade hunter (ou "Candidato", se ainda não for um hunter profissional) do personagem.<br />
É possível determinar um nível inicial pro personagem ou uma exp que definirá seu nível (é possível atribuir um bônus percentual à essa exp).<br />
Agora, defina os atributos Nen e atributos físicos iniciais do personagem a ser criado, as proficiencias treinadas e, por fim:<br />
Clique em "Calcular"

![AnimaçãoGerador](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/4b690090-ee3a-4dd6-b830-0e567af1c39a)

Na última seção estão os dados do personagem e os pontos para distribuir, caso ele comece além do nível 1.<br />
Distribua corretamente até que os pontos zerem e salve a ficha/personagem.<br />
Agora voce pode voltar para a tela do Batalhas e verificar o personagem criado diretamente neste gerenciador!

### Gerador por exp/lvl Nen

Também é possível criar personagens determinando um limite de nível ou experiência de Nen, permitindo a distribuição de pontos dos atributos Nen até esse limite determinado.<br />
Essa feature veio para permitir o mestre determinar certo nível inicial para os personagens de uma campanha ou partida, tornando possível eles distribuirem seus pontos e já começarem conhecendo Nen e o tendo treinado.<br />

![AnimaçãoGerador2](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/9cf6d36f-5dba-4c40-9a58-92ebe3b35d8c)

Também é possível evoluir um personagem através desta tela caso, por exemplo, o mestre queira dar uma temporada de treino pros personagens, dando-lhes pontos de experiência Nen e permitindo-lhes distribuir os níveis evoluídos.<br />
Escreva o nickname do personagem, clique em "Arquivo" -> "Treinar Personagem" e prossiga de maneira análoga com esse treino.

### Trainer

Clique em "Executar Trainer 1.0" para abrir o treinador.<br />
Obs.: o Trainer também pode ser executado após uma batalha ser concluída, como no Gif abaixo:

![AnimaçãoTreinoFinal](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/2a2a2fc2-13d6-482a-8184-effacd5b0cba)

Se você está rodando pelo "Execute":<br />
Insira o nickname do personagem e clique em "Começar Treino".<br />
Você verá o nível físico e de nen do personagem, bem como sua classe, idade, altura e peso (que podem ser editadas).<br />
Novas perícias e proficiências (na última seção) podem ser adicionadas e treinadas.<br />

Em ambos os trainers:<br />
Insira a experiência ganha pelo personagem (se houver) e seu respectivo bônus, se for o caso. Clique em "Aplicar Experiência".<br />
Abaixo você verá o nível físico e de nen do personagem.<br />
Insira quantos dias o personagem tem para treinar e comece a evoluí-lo.<br />
Perícias e proficiências podem ser treinadas e os atributos Nen também, ao clicar em "Treinar".

### Habilidades

Clique em "Executar Habilidades 1.0" para abrir o gerenciador de habilidades.<br />
Insira o nickname do personagem e clique em "OK".<br />
Agora escolha a habilidade que deseja modificar, ou selecione "NOVA", insira um nome e clique em "Começar" para criar uma nova habilidade.

![AnimaçãoHabilidades](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/b103407e-d313-40cb-a7a8-13784dee2ab6)

Preencha o perfil da habilidade e selecione as perícias, atributos Nen ou outros atributos que compõem o dano final da habilidade (normalmente é "For" e a categoria Nen, mas de qualquer forma, costuma ser 1 ou 2 atributos, apenas).<br />
O número após a habilidade diz quantas vezes esses atributo é somado no dano (na grande maioria das vezes é apenas 1).<br />
Selecione a arma e/ou o elemento que compõe a habilidade para incrementar o dano e definir os dados de dano da habilidade.<br />
Selecione a perícia que soma no dano (geralmente não soma).<br />
Marque "Manipulação" ou "Materialização", se for uma habilidade de respectiva categoria e edite a aura bônus se for o caso.<br />
Selecione "Ataque Padrão" para definir esta habilidade como ataque padrão e/ou o análogo para "Defesa Padrão".<br />
Se for o caso, defina se a habilidade gasta aura selecionando "Gasta Ryu" e também "Dano Rebote", se for uma habilidade (normalmente melee) que pode causar um dano rebote no atacante se o alvo for muito "duro".<br />
Você também pode definir a quantidade de RYU geralmente utilizada com essa habilidade (cuidado porque acima de 50% o gasto é grande e se for uma habilidade que gasta aura por ataque, pode ser ruim declará-la como habilidade padrão).<br />
E, finalmente, clique em "Salvar" para salvar a habilidade nova no banco de dados.<br />
Agora você pode voltar para a tela do Batalhas e verificar o personagem com sua habilidade criada, diretamente neste gerenciador!<br />

### Ficha do Personagem

Também é possível visualizar a ficha do personagem de várias partes da aplicação...

![AnimaçãoFicha](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/b17c27bc-1699-43f0-bc16-fd12c897c47b)

<br />
Nota: Este programa não foi feito pensando em segurança de dados e não tem tantas validações quanto deveria, use com carinho <3
