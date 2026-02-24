package service;

import model.Student;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // ➕ 1. Добавить как минимум 5 студентов
    public void initializeStudents() {
        students.add(new Student(1, "Anna", 3.8));
        students.add(new Student(2, "Boris", 2.5));
        students.add(new Student(3, "Victor", 1.9));   // GPA < 2.0 → будет удалён
        students.add(new Student(4, "Galina", 4.0));
        students.add(new Student(5, "Dmitry", 3.2));
        System.out.println("✅ Added 5 students to database");
    }

    // ❌ 2. Удалить студентов с GPA < 2.0
    public void removeLowGPA() {
        // ⚠️ Важно: удаляем через Iterator, чтобы избежать ConcurrentModificationException
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.gpa < 2.0) {
                System.out.println("🗑️ Removed: " + s.name + " (GPA: " + s.gpa + ")");
                iterator.remove();  // ✅ Безопасное удаление
            }
        }
    }

    // 🔍 3. Найти и вывести студента с самым высоким GPA
    public void findHighestGPA() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students in database");
            return;
        }
        
        Student top = students.get(0);  // начинаем с первого
        for (Student s : students) {
            if (s.gpa > top.gpa) {
                top = s;  // обновляем, если нашли лучше
            }
        }
        System.out.println("🏆 Highest GPA: " + top.name + " (" + top.gpa + ")");
    }

    // ➕ 4. Вставить нового студента на индекс 2
    public void insertAtIndex() {
        // Проверяем, чтобы индекс был в допустимых границах
        int index = Math.min(2, students.size());
        students.add(index, new Student(6, "Elena", 3.5));
        System.out.println("📌 Inserted Elena at index " + index);
    }

    // 📋 5. Вывести всех студентов через Iterator
    public void printStudents() {
        System.out.println("\n📚 === ALL STUDENTS ===");
        if (students.isEmpty()) {
            System.out.println("  (empty)");
            return;
        }
        
        Iterator<Student> iterator = students.iterator();
        int num = 1;
        while (iterator.hasNext()) {
            Student s = iterator.next();
            System.out.println("  " + num + ". ID:" + s.id + 
                             " | " + s.name + 
                             " | GPA:" + s.gpa);
            num++;
        }
    }
    
    // 🔧 Helper: получить список для других операций (опционально)
    public ArrayList<Student> getStudents() {
        return students;
    }
}
