#План автоматизации тестирования
***************************************
**Перечень автоматизируемых сценариев:**  
1. Позитивные сценарии.
   * Пользователь вводит валидные данные, выбирая оплату по карте (успешно);
    * Пользователь вводит валидные данные, выбирая покупку с использованием кредита (успешно);
   * Пользователь вводит валидные данные, выбирая оплату по карте на которой недостаточно средств (отказ);
   * Пользователь вводит валидные данные, выбирая покупку с использованием кредита по заблокированной карте (отказ).  
   
2. Негативные сценарии. Для каждого способа оплаты вводятся невалидные данные:
   * пустая форма;
   * неверный номер карты;
   * карта с истёкшим сроком действия;
   * неверно указан номер месяца в сроке действия карты;
   * неверно указан CVV-код;
   * в поле "Владелец" вносятся недопустимые символы (кириллица); 
   
3. Проверка корректности данных записанных в БД.

**Перечень используемых инструментов:**  
1. Java + JUnit5 - платформа для реализации сценариев тестирования, позволяет сравнительно небольшим количеством вводимого кода реализовать требуемые автотесты.
2. Gradle - cистема управления зависимости. Преимущества: позволяет удобно ставить необходимые фреймворки без проблем с постоянной настройкой зависимостей.   
3. Selenide - создание Page Objects, UI тестирование, заполнение формы через веб-интерфейс. Преимущества: с ним удобно делать PageObjects, Selenide достаточно простой (в отличие, например, от Selenium).
4. Faker - фреймворк для генерации недостающих данных для тестирования. Преимущества: нет необходимости тратить время на самостоятельное выдумывание данных.
5. Docker - ПО для развертывания и запуска приложения в контейнере. Преимущества: Можно одновременно запускать на одном компьютере несколько контейнеров, при этом будет потребляться меньше ресурсов, чем для виртуализации.
6. Git и Github. Git- cистема контроля версий, для хранения кодов автотестов и настроек окружения. Код размещенный на Github доступен удаленно для преподавателя.
7. Allure - фреймворк, предназначенный для создания подробных отчетов о выполнении тестов. Преимущества: требует минимальных временных затратах на подключение к проекту.

**Перечень и описание возможных рисков при автоматизации:**  
1. Риск появления проблем с настройкой приложения и необходимых БД.
2. Риск связанный с комплексным характером тестирования. Возможно потребуется больше времени на дополнительные проверки и оформление баг-репортов.

**Интервальная оценка с учётом рисков:**  
- Подготовка окружения, развертывание БД - 10 часов.
- Написание автотестов, тестирование и отладка автотестов - 30 часов.
- Формирование и анализ отчетов - 6 часов.

**План сдачи работ (когда будут авто-тесты, результаты их прогона и отчёт по автоматизации):**  

Плановая дата сдачи работы - 31.01.2021
***************************************