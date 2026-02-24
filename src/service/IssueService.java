package service;

import model.Issue;
import java.util.PriorityQueue;
import java.util.Iterator;

public class IssueService {

    private PriorityQueue<Issue> issues = new PriorityQueue<>();

    // ➕ 1. Добавить как минимум 5 проблем
    public void initializeIssues() {
        // urgencyLevel: 1 = самый срочный, 5 = наименее срочный
        issues.add(new Issue("Exam not submitted", 1));           // 🔥 самый срочный
        issues.add(new Issue("Schedule conflict", 3));
        issues.add(new Issue("Missed lecture", 4));
        issues.add(new Issue("Need official transcript", 2));
        issues.add(new Issue("Scholarship question", 5));
        System.out.println("✅ Added 5 issues to priority queue");
    }

    // 🔝 2. Показать самую срочную проблему (не удаляя)
    public void showMostUrgent() {
        if (issues.isEmpty()) {
            System.out.println("⚠️ No issues in queue");
            return;
        }
        // peek() возвращает элемент с наивысшим приоритетом, но не удаляет его
        System.out.println("🔥 Most urgent issue: " + issues.peek());
    }

    // ✅ 3. Решить (удалить) 2 проблемы
    public void resolveIssues() {
        System.out.println("\n🔧 Resolving issues:");
        for (int i = 1; i <= 2; i++) {
            if (!issues.isEmpty()) {
                // poll() извлекает и удаляет элемент с наивысшим приоритетом
                Issue resolved = issues.poll();
                System.out.println("  " + i + ". ✅ Resolved: " + resolved);
            } else {
                System.out.println("  " + i + ". ⚠️ No more issues to resolve");
            }
        }
    }

    // 📋 4. Вывести оставшиеся проблемы через Iterator
    public void printRemainingIssues() {
        System.out.println("\n📋 Remaining issues (via Iterator):");
        if (issues.isEmpty()) {
            System.out.println("  (empty)");
            return;
        }
        
        Iterator<Issue> iterator = issues.iterator();
        while (iterator.hasNext()) {
            System.out.println("  • " + iterator.next());
        }
        
        // ⚠️ ВАЖНО: Iterator по PriorityQueue НЕ гарантирует порядок приоритета!
        // Он обходит внутреннюю структуру (кучу), а не выдаёт отсортированно.
    }

    // 🔁 Бонус-метод: вывести по приоритету (если нужен упорядоченный вывод)
    public void printInPriorityOrder() {
        System.out.println("\n📋 By priority (sorted view):");
        if (issues.isEmpty()) {
            System.out.println("  (empty)");
            return;
        }
        
        // Создаём копию, чтобы не испортить оригинальную очередь
        PriorityQueue<Issue> temp = new PriorityQueue<>(issues);
        while (!temp.isEmpty()) {
            System.out.println("  • " + temp.poll());
        }
    }

    // ➕ 5. Добавить новую проблему (вызывается из меню)
    public void addNewIssue(String description, int urgency) {
        // Валидация уровня срочности
        if (urgency < 1 || urgency > 5) {
            System.out.println("❌ Urgency must be between 1 and 5");
            return;
        }
        issues.add(new Issue(description, urgency));
        System.out.println("✅ Added: [" + urgency + "] " + description);
    }
    
    // 🔧 Helper: получить очередь для внешних операций (опционально)
    public PriorityQueue<Issue> getIssues() {
        return issues;
    }
}
