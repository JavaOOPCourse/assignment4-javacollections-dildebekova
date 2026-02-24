import java.util.ArrayDeque;
import java.util.Iterator;

class ActionHistory {
    private ArrayDeque<String> actions = new ArrayDeque<>();

    // ➕ Добавить 4 действия
    public void addInitialActions() {
        actions.addLast("Submitted Assignment");
        actions.addLast("Dropped Course");
        actions.addLast("Registered Course");
        actions.addLast("Updated Profile");
        System.out.println("✅ Добавлено 4 действия в историю");
    }

    // ↩️ Отменить последнее действие (LIFO — как стек)
    public void undoLastAction() {
        if (!actions.isEmpty()) {
            String undone = actions.removeLast();
            System.out.println("↩️ Отменено: " + undone);
        }
    }

    // ➕ Добавить новое действие
    public void addNewAction(String action) {
        actions.addLast(action);
        System.out.println("✅ Добавлено: " + action);
    }

    // 👀 Показать первое и последнее действие
    public void showFirstAndLast() {
        if (!actions.isEmpty()) {
            System.out.println("🔹 Первое действие: " + actions.getFirst());
            System.out.println("🔹 Последнее действие: " + actions.getLast());
        }
    }

    // 🔁 Пройтись через Iterator
    public void printHistoryWithIterator() {
        System.out.println("\n📜 История действий:");
        Iterator<String> iterator = actions.iterator();
        while (iterator.hasNext()) {
            System.out.println("  → " + iterator.next());
        }
    }

    public ArrayDeque<String> getActions() {
        return actions;
    }
}
