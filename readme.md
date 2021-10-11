# Reboot School Java Developer Project

[![build](https://img.shields.io/github/workflow/status/AleksMikhailenko/home-work/Java%20CI%20with%20Maven/develop)](https://github.com/AleksMikhailenko/home-work/actions?query=branch%3Adevelop++workflow%3A%22Java+CI+with+Maven%22++)
[![codecov](https://codecov.io/gh/AleksMikhailenko/home-work/branch/master/graph/badge.svg)](https://codecov.io/gh/AleksMikhailenko/home-work)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=AleksMikhailenko_home-work&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=AleksMikhailenko_home-work)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=AleksMikhailenko_home-work&metric=security_rating)](https://sonarcloud.io/dashboard?id=AleksMikhailenko_home-work)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=AleksMikhailenko_home-work&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=AleksMikhailenko_home-work)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=AleksMikhailenko_home-work&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=AleksMikhailenko_home-work)

* [№2 - Calculator](#homework-2)
* [№3 - AccountService](#homework-3)
* [№4 - AccountRepository](#homework-4)
* [№5 - Cassette model](#homework-5)
* [№7 - AccountUtils](#homework-7)
* [№9 - json/xml serialization and deserialization utils](#homework-9)
* [№11 - AccountService with Stream API](#homework-11)
* [№14 - MainReport with CompletableFuture and Project Reactor](#homework-14)
* [№15 - Java Servlet API](#homework-15)
* [№16 - Spring Application Context](#homework-16)

---

## Homework 2

1. Написать класс _Calculator_:
    1. сложение
    2. вычитание
    3. умножение
    4. деление
    5. 3 метода на свое усмотрение
2. Написать ко всем методам тесты

### Выполнение

1. Локально подключить исходный репозиторий `git/manage remotes`
2. Создать новую ветку от _develop_
3. Сделать `pull` из ветки урока в новую локальную ветку
4. Выполнить задание и собрать проект
5. Выполнить `commit` и `push`
6. Создать `pull request` из новой ветки в _develop_

---

## Homework 3

1. Создать иерархию классов (на основе тестового класса _AccountServiceTest_) с простой логикой. Должны присутствовать
   Интерфейс/абстрактный класс.
2. Написать тесты. Использовать Mock*.
3. В проекте использовать _maven_ и _lombok_.
4. Добиться успешного прохождения тестов из _AccountServiceTest_.

---

## Homework 4

1. Создать класс _AccountRepositoryImpl_ реализующий интерфейс _AccountRepository_ с прошлого урока.
2. Единственный метод для реализации `AccountRepository#getAllAccountsByClientId`.

#### Реализовать метод `AccountRepository#getAllAccountsByClientId` по следующим требованиям:

1. Прочитать файл _Accounts.txt_ используя _InputStream_ и _BufferedReader_ (возможны варианты).
2. Распарсить полученные строки (любым способом на ваш выбор, можно стандартными методами класса _String_).
3. Создать _Set_ на основе данных из файла, где value = number из файла исключительно для clientId переданного на вход.

#### Задание на 5+.

1. Добавить в репозиторий метод обновления номера счета с входными параметрами id клиента и номер счета(который нужно
   обновить) в файле.
2. Заменить в прочитанном файле любой номер счета у клиента.

#### В приложении:

1. Для чтения\записи файлов использовать классы из _Java I/O_
2. Для обработки текста использовать классы для работы со строками из JDK (использовать сторонние либы).

---

## Homework 5

В нижней части банкомата размещается сейф, в котором имеется несколько кассет для хранения денежных купюр. В одной
кассете могут находиться купюры одного достоинства. Как правило, банкомат загружают купюрами на 100, 500, 1000 и 5000
рублей.

1. Создать класс _Banknote_, определяющий нашу сущность - купюра.
2. Создать класс _Cassette_, определяющий нашу сущность - кассета в банкомате (Использовать _Generics_).
3. Добиться успешного выполнения теста _CassetteTest_.

---

## Homework 7

#### Реализовать утилиту сортировки коллекций со счетами.

Создать класс с двумя методами:

1. `AccountUtils#sortedById` - метод сортирует коллекцию со счетами по полю _id_ (id счета).
2. `AccountUtils#sortedByIdDate` - метод сортирует коллекцию со счетами по полям _id_ (id счета) и _createDate_ (дата
   создания счета). При чем, порядок создания - от более старых к более новым.

#### Дополнительное задание.

1. Реализовать метод сортировки по трем полям: _id_ (id счета) и _createDate_ (дата создания счета) и _balance_ (баланс
   счёта).
2. Написать к нему тест.

---

## Homework 9

#### Реализовать утилиту сериализации и десериализации в json\xml классов, передаваемых между банкоматом и хостом.

---

## Homework 11

#### С помощью _Stream API_ реализовать новые методы класса _AccountService_.

1. `AccountService#getMaxAccountBalance` - метод возвращает счёт с максимальным балансом.
2. `AccountService#getAllAccountsByDateMoreThen` - метод возвращает счета с более поздними датами создания, чем указано
   во входных параметрах.

#### Дополнительное задание на 5+

1. Придумать собственный метод для работы со счетами используя _Stream API_.
2. Написать к нему тест.

---

## Homework 14

#### Реализовать распараллеливание задач с помощью CompletableFuture и Project Reactor

1. Реализовать методы `MainReport#getTotalsWithCompletableFuture` и `MainReport#getTotalsWithReact`
2. Методы получают на вход _Stream_ и возвращает сумму балансов рублевых счетов открытых между 01.07.2021 и 01.08.2021 и
   принадлежащих клиентам в возрасте между 18 и 30.
3. Решение задачи должно использовать максимально доступное количество ядер процессора.

---

## Homework 15

#### Написать сервлет, обрабатывающий GET-запрос

1. Передается один параметр - _name_.
2. В ответ возвращать строку `"Привет, "` + значение переменной _name_.
3. У сервлета должно быть поле _counter_ со стартовым значением 0. В нем должен происходить инкремент при каждом HTTP
   GET запросе. Значение каунтера также должно возвращаться после текста приветствия. Например: `Counter = 5`

---

## Homework 16

#### Ознакомьтесь с примером консольного приложения SpringConsoleApp

1. Объявить классы _Client_ и _Account_ spring-бинами.
2. Добавить возможность инициализации этих бинов через аннотации и xml (необходимо будет явно создавать контекст).
3. В реальных приложениях создание контекста скрыто "под капотом". В этом примере нужно понять как работает ядро Spring.