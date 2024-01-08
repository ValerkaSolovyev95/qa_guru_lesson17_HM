<h1>Проект по автоматизации тестирования сайта банка <a href="https://www.tinkoff.ru/">Tinkoff</a>.</h1>

<a href="https://www.tinkoff.ru"><img src="images/logo/Tinkoff.jpg" width="920" height="400"  alt="Java"/></a>

## О банке:
>Один из крупнейших в мире онлайн-банков, основан в 2006 году. На конец 2022 года у «Тинькофф» было 20,2 млн активных клиентов — по этому показателю он входит в тройку крупнейших банков России.

## ☑️ Содержание:

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
---

<a id="tools"></a>
<a name="Технологии и инструменты">**Технологии и инструменты:**</a>

| Java                                                                                                     | IntelliJ  <br>  Idea                                                                                               | GitHub                                                                                           | JUnit 5                                                                                                          | Gradle                                                                                                     | Selenide                                                                                                         | Selenoid                                                                                                                  | Allure <br> Report                                                                                                         | Jenkins                                                                                                          | Jira                                                                                                                                    | Telegram                                                                                                            |                                                                                            Allure <br> TestOps |
|:---------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------:|
| <a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="images/logo/GitHub.png" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="images/logo/junit5.png" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/software/jira/"><img src="images/logo/Jira.svg" width="50" height="50" alt="Java" title="Java"/></a> | <a href="https://web.telegram.org/"><img src="images\logo\Telegram.svg" width="50" height="50" alt="Telegram"/></a> | <a href="https://qameta.io/"><img src="images\logo\allureTestOps.svg" width="50" height="50" alt="Allure_TO"/></a> |

* В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
* В качестве сборщика был использован - <code>Gradle</code>.
* Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
* При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
* Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
* Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.
---

<a id="cases"></a>
<a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>

* Проверка отправки сообщения на номер телефона, при открытии вклада
* Проверка меню главной страницы сайта
* Проверка отправки сообщения на номер телефона, при заказе дебетовой карты
* Проверка отправки сообщения на номер телефона, при открытии счета для малого бизнеса
* Проверка меню страницы карьера

____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/qa_guru_stream_22_lesson17HW_vasolovev/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/qa_guru_stream_22_lesson17HW_vasolovev/"><img src="images/screen/jenkins_build.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**
- *TASK (задача для запуска тестов tinkoff_test)*
- *ENVIRONMENT (указатель окружения для запуска тестов, по умолчанию TEST)*
- *COMMENT (переменная для передачи id telegram ответственного за прогон)*
- *ENV (указатель, что тесты запускаются удаленно, по умолчанию remote)*

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean test -Dtag=tinkoff_test
```

***Удалённый запуск через Jenkins:***
```bash  
clean ${TASK} 
"-Denv=${ENV}" 
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/qa_guru_stream_22_lesson17HW_vasolovev/9/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/main_page_allure_report.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screen/test_cases_allure.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screen/allure_graphs.png" width="850">

<img title="Allure Graphics" src="images/screen/graphs.png" width="850">  
</p>

___
<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="images/logo/allureTestOps.svg" width="25"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/3928/dashboards">Allure TestOps</a>
____
### *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/screen/allure_overview.png" width="850">  
</p>  

### *Ручные тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screen/allure_autotests_manual.png" width="850">  
</p>

### *Автоматизированные тест-кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="images/screen/allure_autotestsN.png" width="850">  
</p>

___
<a id="jira"></a>
## <img alt="Allure" height="25" src="images/logo/Jira.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1028">Jira</a>
____
<p align="center">  
<img title="Jira" src="images/screen/jira.png" width="850">  
</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/telegram.png" width="550">  
</p>

____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="images/logo/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____
<p align="center">
<img title="Selenoid Video" src="images/video/video.gif" width="550" height="350"  alt="video">   
</p>
