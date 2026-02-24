import java.util.LinkedList;
import java.util.Iterator;

class AppointmentQueue {
    private LinkedList<String> appointments = new LinkedList<>();

    // ➕ Добавить 3 обычные записи
    public void addNormalAppointments() {
        appointments.add("Консультация по математике");
        appointments.add("Обсуждение курсовой");
        appointments.add("Проверка диплома");
        System.out.println("✅ Добавлено 3 обычные записи");
    }

    // ⚡ Добавить срочную запись в начало
    public void addUrgentAtBeginning() {
        appointments.addFirst("🔥 СРОЧНО: Проблема с оценкой!");
        System.out.println("⚡ Срочная запись добавлена в начало");
    }

    // ❌ Отменить последнюю запись
    public void cancelLast() {
        if (!appointments.isEmpty()) {
            String cancelled = appointments.removeLast();
            System.out.println("🗑️ Отменена запись: " + cancelled);
        }
    }

    // 👀 Показать первую и последнюю запись
    public void showFirstAndLast() {
        if (!appointments.isEmpty()) {
            System.out.println("🔹 Первая запись: " + appointments.getFirst());
            System.out.println("🔹 Последняя запись: " + appointments.getLast());
        }
    }

    // 🔁 Пройтись через Iterator
    public void printWithIterator() {
        System.out.println("\n📋 Все записи:");
        Iterator<String> iterator = appointments.iterator();
        int num = 1;
        while (iterator.hasNext()) {
            System.out.println("  " + num + ". " + iterator.next());
            num++;
        }
    }

    public LinkedList<String> getAppointments() {
        return appointments;
    }
}
