*** Settings ***
Library  SeleniumLibrary

*** Variables ***

*** Keywords ***

Abrir Site
    Open Browser  https://localhost:8080    chrome

*** Test Cases ***
Cenário 1: Acessando o site da QAZANDO
    Abrir Site