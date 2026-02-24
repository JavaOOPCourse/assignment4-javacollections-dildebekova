import java.util.PriorityQueue;
import java.util.Iterator;

// Класс проблемы с реализацией Comparable
class Issue implements Comparable<Issue> {
    String description;
    int urgencyLevel; // 1 = самый срочный, 5 = наименее срочный

    public Issue(String description, int urgencyLevel) {
        this.description = description;
        this.urgencyLevel = urgencyLevel;
    }

    // 🔑 Сравниваем: меньшее число = выше приоритет
    @Override
    public int compareTo(Issue other) {
        return Integer.compare(this.urgencyLevel, other.urgencyLevel);
    }

    @Override
    public String toString() {
        return "[" + urgencyLevel + "] " + description;
    }
}

public class EmergencyIssues {
    private PriorityQueue<Issue> issues = new PriorityQueue<>();

    // ➕ Добавить 5+ проблем
    public void addIssues() {
        issues.add(new Issue("Не сдан экзамен", 1));        // 🔥 самый срочный
        issues.add(new Issue("Ошибка в расписании", 3));
        issues.add(new Issue("Пропущена лекция", 4));
        issues.add(new Issue("Нужна справка", 2));
        issues.add(new Issue("Вопрос по стипендии", 5));
        System.out.println("✅ Добавлено 5 проблем");
    }

    // 🔝 Показать самую срочную (не удаляя)
    public void showMostUrgent() {
        if (!issues.isEmpty()) {
            System.out.println("🔥 Самая срочная проблема: " + issues.peek());
        }
    }

    // ✅ Решить 2 проблемы (удалить из очереди)
    public void resolveTwoIssues() {
        System.out.println("\n🔧 Решаем проблемы:");
        for (int i = 1; i <= 2 && !issues.isEmpty(); i++) {
            Issue resolved = issues.poll(); // удаляет и возвращает самый приоритетный
            System.out.println("  " + i + ". ✅ Решено: " + resolved);
        }
    }

    // 📋 Вывести оставшиеся через Iterator
    public void printRemainingWithIterator() {
        System.out.println("\n📋 Оставшиеся проблемы (в порядке приоритета):");
        Iterator<Issue> iterator = issues.iterator();
        while (iterator.hasNext()) {
            System.out.println("  • " + iterator.next());
        }
        // ⚠️ Внимание: Iterator по PriorityQueue не гарантирует порядок!
        // Для упорядоченного вывода лучше использовать poll() в цикле.
    }

    // 🔁 Правильный способ вывести по приоритету (если нужно сохранить очередь)
    public void printInPriorityOrder() {
        System.out.println("\n📋 По приоритету (копия очереди):");
        PriorityQueue<Issue> temp = new PriorityQueue<>(issues);
        while (!temp.isEmpty()) {
            System.out.println("  • " + temp.poll());
        }
    }

    public PriorityQueue<Issue> getIssues() {
        return issues;
    }
}
