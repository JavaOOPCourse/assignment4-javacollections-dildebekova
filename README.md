[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/DPi9QhIt)
# 🎓 Smart University Service System

==================================================
🇷🇺 РУССКАЯ ВЕРСИЯ (ПОЛНОСТЬЮ)
==================================================

📚 Комплексное задание: Smart University Service System

Сценарий

Вы разрабатываете систему обслуживания студентов университета, которая управляет:

• Запросами студентов  
• Срочными академическими проблемами  
• Недавно выполненными действиями  

Система должна имитировать работу реальных студенческих сервисов, используя:

✅ ArrayList  
✅ LinkedList  
✅ PriorityQueue  
✅ ArrayDeque  

Функциональные требования

1️⃣ База данных студентов — ArrayList

Создайте класс:

class Student {

    int id;
    String name;
    double gpa;

}

Задачи

• Хранить студентов в ArrayList<Student>  
• Добавить как минимум 5 студентов  
• Удалить студентов с GPA < 2.0  
• Найти и вывести студента с самым высоким GPA  
• Вставить нового студента на индекс 2  
• Вывести всех студентов, используя Iterator  

2️⃣ Очередь ежедневных записей — LinkedList

Студенты записываются на консультации.

Использовать:

LinkedList<String> appointments  

Задачи

• Добавить 3 обычные записи  
• Добавить 1 срочную запись в начало  
• Отменить последнюю запись  
• Показать:
  o Первую запись  
  o Последнюю запись  
• Пройтись по списку, используя Iterator  

3️⃣ Срочные академические проблемы — PriorityQueue

Создать:

class Issue implements Comparable<Issue> {

    String description;
    int urgencyLevel; // 1 = самый срочный

}

Использовать:

PriorityQueue<Issue>

Задачи

• Добавить как минимум 5 проблем  
• Показать самую срочную проблему  
• Решить (удалить) 2 проблемы  
• Вывести оставшиеся проблемы, используя Iterator  

4️⃣ История действий студента — ArrayDeque

Отслеживать недавние действия, такие как:

• "Submitted Assignment"  
• "Dropped Course"  
• "Registered Course"  
• "Updated Profile"  

Использовать:

ArrayDeque<String> actions  

Задачи

• Добавить 4 действия  
• Отменить последнее действие  
• Добавить новое действие: "Requested Transcript"  
• Показать:
  o Первое действие  
  o Последнее действие  
• Пройтись по истории  

⭐ Финальное интеграционное задание

Создать систему с меню:

1. Показать студентов  
2. Показать записи  
3. Показать срочные проблемы  
4. Показать историю действий  
5. Добавить новую проблему  
6. Отменить действие  
7. Выход  

Использовать соответствующие структуры данных для каждой опции.

==================================================
🇬🇧 ENGLISH VERSION (FULL ORIGINAL)
==================================================

Complex Assignment: Smart University Service System

Scenario

You are developing a University Student Service System that manages:

• Student requests  
• Urgent academic issues  
• Recently performed actions  

The system must simulate how real student services work using:

✅ ArrayList  
✅ LinkedList  
✅ PriorityQueue  
✅ ArrayDeque  

Functional Requirements

1️⃣ Student Database — ArrayList

Create a class:

class Student {

    int id;
    String name;
    double gpa;

}

Tasks

• Store students in an ArrayList<Student>  
• Add at least 5 students  
• Remove students with GPA < 2.0  
• Find and print the student with the highest GPA  
• Insert a new student at index 2  
• Print all students using an iterator  

2️⃣ Daily Appointment Queue — LinkedList

Students book advisor meetings.

Use:

LinkedList<String> appointments  

Tasks

• Add 3 normal appointments  
• Add 1 urgent appointment at the beginning  
• Cancel the last appointment  
• Show:
  o First appointment  
  o Last appointment  
• Traverse using Iterator  

3️⃣ Emergency Academic Issues — PriorityQueue

Create:

class Issue implements Comparable<Issue> {

    String description;
    int urgencyLevel; // 1 = most urgent

}

Use:

PriorityQueue<Issue>

Tasks

• Add at least 5 issues  
• Show the most urgent issue  
• Resolve (remove) 2 issues  
• Print remaining issues using iterator  

4️⃣ Student Action History — ArrayDeque

Track recent actions like:

• "Submitted Assignment"  
• "Dropped Course"  
• "Registered Course"  
• "Updated Profile"  

Use:

ArrayDeque<String> actions  

Tasks

• Add 4 actions  
• Undo last action  
• Add new action: "Requested Transcript"  
• Show:
  o First action  
  o Last action  
• Iterate through history  

⭐ Final Integration Task

Create a menu-driven system:

1. Show Students  
2. Show Appointments  
3. Show Emergency Issues  
4. Show Action History  
5. Add New Issue  
6. Undo Action  
7. Exit  

Use appropriate data structures for each option.
