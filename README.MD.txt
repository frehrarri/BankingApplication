Banking Application
Created by Mitchell Frehr

Technologies used:
Language: Java, 
RDBM: PostgreSQL 
Unit Testing: JUnit
Dependency Manager: Maven

Flow:
Driver -> StartMenu(branches):

StartMenu -> UserAccounts -> MainMenu(branches):
(or)
StartMenu -> MainMenu(branches):


MainMenu -> UserAccounts -> MainMenu
(or)
MainMenu -> AccountDAO -> AccountDAOImpl