[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](https://github.com/422UR4H/GxG-Batalhas-Integrado/blob/main/README.pt-br.md)

# GxG Battles: Integrated

A Desktop Java Application built for manage gameplay on the Hunter X Hunter RPG System.

![AnimaçãoBatalhas](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/b3db066c-fc58-41c1-9a6e-343a26fbdb01)

## Description

This program evolved from its first CLI version written in C for Windows.<br />
It integrates the Generator, Trainer and Editor of sheets/characters, Skill manager and Battle manager into a single system.<br />
This is an application built in Netbeans IDE using Java Language with PostgreSQL for the database.<br />
The architecture has no standard, as I was an amateur developer who would later become a professional, I still didn't know the SOLID principles, design patterns or even the Client-Server Pattern.<br />
However, this project carries a large part of my passion for development and RPG, being the main reason I became a software developer.<br />
And, therefore, I am creating a web application as gratitude to this project that guided my professional life, but also to leave this software/system free (and open software) for RPG and Hunter X Hunter lovers!

## Demo

### Software Download Link:

```url
https://mega.nz/file/6pQgECpJ#WbzxHgVh6SJ0NiMZx4lIrOnWhpxXxhF3aOvqe5P-zgI
```

## Quick start

Clone the repository and open in your favorite IDE.

```bash
git clone https://github.com/422UR4H/GxG-Batalhas-Integrado
```

## Usage

Before starting, I need to say that this is an extensive system and could not be fully covered here, so I will limit myself to explaining the basics of how it works. Jump in, explore and have fun like a Hunter!

### Menus and Sheet

![AnimaçãoMenu](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/6ee0a9c0-d3b5-490f-8c45-244a495f4cbf)

### Generator

Click "Executar Gerador 1.0" to open the generator.<br />
Enter the character profile form, such as your nickname (which must be unique in the system, or it will generate an error).<br />
Choose the class, as well as the Nen category, alignment and hunter specialty (or "Candidato", if you are not yet a professional hunter) of the character.<br />
It is possible to determine an initial level for the character or an exp that will define their level (it is possible to assign a percentage bonus to this exp).<br />
Now, define the Nen attributes and initial physical attributes of the character to be created, the trained proficiencies and, finally:<br />
Click "Calcular"

![AnimaçãoGerador](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/4b690090-ee3a-4dd6-b830-0e567af1c39a)

In the last section are the character's data and the points to distribute if he starts beyond level 1.<br />
Distribute correctly until the points are zero and save the sheet/character.<br />
Now you can go back to the Battles Screen and check the character created directly in this manager!

### Generator by exp/lvl Nen:

It is also possible to create characters by determining a Nen level or experience limit, allowing the distribution of Nen attribute points up to this determined limit.<br />
This feature came to allow the master to determine a certain initial Nen level for the characters of a campaign or match, making it possible for them to distribute their points and start by knowing Nen and having trained him.<br />

![AnimaçãoGerador2](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/9cf6d36f-5dba-4c40-9a58-92ebe3b35d8c)

It is also possible to evolve a character through this screen if, for example, the master wants to give the characters a training season, giving them Nen experience points and allowing them to distribute the evolved levels.<br />
Write the character's nickname, click on "Arquivo" -> "Treinar Personagem" and proceed in a similar way with this training.

### Trainer

Click "Executar Trainer 1.0" to open the trainer.<br />
Note: the Trainer can also be run after a battle is completed, as in the Gif below:

![AnimaçãoTreinoFinal](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/2a2a2fc2-13d6-482a-8184-effacd5b0cba)

If you are running through "Executar":<br />
Enter the character's nickname and click "Começar Treino".<br />
You'll see the character's physical and nen level, as well as their class, age, height, and weight (which can be edited).<br />
New skills and proficiencies (in the last section) can be added and trained.<br />

On both trainers:<br />
Enter the experience gained by the character (if any) and its respective bonus, if applicable. Click "Aplicar Experiência".<br />
Below you will see the character's physical and nen level.<br />
Enter how many days the character has to train and start evolving him.<br />
Skills and proficiencies can be trained, as well as nen attributes, by clicking "Treinar".

### Skills

Click "Executar Habilidades 1.0" to open the skills manager.<br />
Enter the character's nickname and click "OK".<br />
Now choose the skill you want to modify, or select "NOVA" and enter a name and click "Começar" to create a new skill.

![AnimaçãoHabilidades](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/b103407e-d313-40cb-a7a8-13784dee2ab6)

Fill in the skill profile and select the skills, nen attributes or other attributes that make up the skill's final damage (normally it is "For" and the nen category, but in any case, it is usually 1 or 2 attributes only).<br />
The number after the skill tells how many times these attributes are added to the damage (most of the time it is just 1).<br />
Select the weapon and/or element that makes up the skill to increase the damage and define the skill's damage data.<br />
Select the skill that adds to the damage (usually it doesn't).<br />
Check "Manipulação" or "Materialização", if it is a skill in the respective category and edit the bonus aura if applicable.<br />
select "Ataque Padrão" to set this skill as the default attack and/or the analogue for "Defesa Padrão" (for defense).<br />
If applicable, define whether the skill spends aura by selecting "Gasta Ryu" and also "Dano Rebote", if it is a skill (normally melee) that can cause rebound damage to the attacker if the target is very "hard".<br />
You can also define the amount of ryu generally used with this skill (be careful because above 50% the expense is large and if it is a skill that uses aura, it may be bad to declare it as a standard skill).<br />
Finally, click "Salvar" to save the new skill.<br />
Now you can go back to the battles screen and check the character with his created skill directly in this manager!<br />

### Character Sheet

It is also possible to view the character's profile from various parts of the application...

![AnimaçãoFicha](https://github.com/422UR4H/GxG-Batalhas-Integrado/assets/36780789/b17c27bc-1699-43f0-bc16-fd12c897c47b)

<br />
Note: This program was not created with data security in mind and does not have as many validations as it should, use it with care <3
