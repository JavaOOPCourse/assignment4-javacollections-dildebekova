import java.util.ArrayList;
import java.util.Iterator;

class Student {
    int id;
    String name;
    double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Имя: " + name + " | GPA: " + gpa;
    }
}

// Методы для работы с ArrayList<Student>
public class StudentDatabase {
    private ArrayList<Student> students = new ArrayList<>();

    // ➕ Добавить студентов
    public void addStudents() {
        students.add(new Student(1, "Анна", 3.8));
        students.add(new Student(2, "Борис", 2.5));
        students.add(new Student(3, "Виктор", 1.9));  // GPA < 2.0 → будет удалён
        students.add(new Student(4, "Галина", 4.0));
        students.add(new Student(5, "Дмитрий", 3.2));
        System.out.println("✅ Добавлено 5 студентов");
    }

    // ❌ Удалить студентов с GPA < 2.0
    public void removeLowGPA() {
        // ⚠️ Важно: удаляем через iterator, чтобы избежать ConcurrentModificationException
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.gpa < 2.0) {
                System.out.println("🗑️ Удалён: " + s.name + " (GPA: " + s.gpa + ")");
                iterator.remove();
            }
        }
    }

    // 🔍 Найти студента с самым высоким GPA
    public Student findTopStudent() {
        Student top = students.get(0);
        for (Student s : students) {
            if (s.gpa > top.gpa) {
                top = s;
            }
        }
        return top;
    }

    // ➕ Вставить студента на индекс 2
    public void insertAtIndex2() {
        students.add(2, new Student(6, "Елена", 3.5));
        System.out.println("📌 Елена вставлена на позицию 2");
    }

    // 📋 Вывести всех студентов через Iterator
    public void printAllWithIterator() {
        System.out.println("\n📚 Все студенты:");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println("  • " + iterator.next());
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
