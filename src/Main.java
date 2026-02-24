import service.*;  // Импорт всех сервисов из пакета
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 🚀 Инициализация сервисов
        StudentService studentService = new StudentService();
        AppointmentService appointmentService = new AppointmentService();
        IssueService issueService = new IssueService();
        ActionHistoryService actionService = new ActionHistoryService();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== 🎓 Smart University Service System =====");
            System.out.println("1. Show Students");
            System.out.println("2. Show Appointments");
            System.out.println("3. Show Emergency Issues");
            System.out.println("4. Show Action History");
            System.out.println("5. Add New Issue");
            System.out.println("6. Undo Action");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            // ⚠️ Защита от нечислового ввода
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number (1-7): ");
                scanner.next(); // отбрасываем неверный ввод
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // 🧹 очистка буфера после nextInt()

            switch (choice) {
                case 1 -> {
                    System.out.println("\n👥 === STUDENTS ===");
                    studentService.displayStudents();  // ✅ Вывод студентов через Iterator
                }
                case 2 -> {
                    System.out.println("\n📅 === APPOINTMENTS ===");
                    appointmentService.displayAppointments();  // ✅ Показ записей
                }
                case 3 -> {
                    System.out.println("\n🚨 === EMERGENCY ISSUES ===");
                    issueService.showMostUrgent();     // 🔝 Самая срочная
                    issueService.displayIssues();      // 📋 Все проблемы
                }
                case 4 -> {
                    System.out.println("\n🔄 === ACTION HISTORY ===");
                    actionService.displayHistory();    // 📜 История действий
                }
                case 5 -> {
                    System.out.println("\n➕ Add New Issue:");
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    
                    System.out.print("Urgency level (1-5, where 1 = most urgent): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Enter number 1-5: ");
                        scanner.next();
                    }
                    int level = scanner.nextInt();
                    scanner.nextLine(); // 🧹 очистка буфера
                    
                    if (level >= 1 && level <= 5) {
                        issueService.addIssue(desc, level);  // ✅ Добавление проблемы
                        System.out.println("✅ Issue added!");
                    } else {
                        System.out.println("❌ Level must be between 1 and 5");
                    }
                }
                case 6 -> {
                    System.out.println("\n↩️ Undo last action...");
                    actionService.undoLastAction();  // ✅ Отмена действия
                }
                case 7 -> {
                    System.out.println("Exiting... 👋 Good luck with your studies! 🎓");
                }
                default -> System.out.println("Invalid option ❌ Please choose 1-7");
            }

        } while (choice != 7);

        scanner.close();
        System.out.println("✅ Resources closed. Bye! 💙");
    }
}
