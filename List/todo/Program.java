public class Program {
        public static void main(String[] args) {
            TodoList todo = new TodoList();

            todo.addTask(new Task("Read Lambda class content", 1));
            todo.addTask(new Task("Learn Design Patterns", 2));
            todo.addTask(new Task("Clean the room", 3));

            todo.markTaskDone(1);

            todo.listTasks();

            System.out.println("----");

            todo.markTaskDone(2);
            todo.undoTask(1);

            todo.listTasks();

            System.out.println("----");

            try {
                todo.markTaskDone(2);
                todo.listTasks();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("----");

            todo.completeAll();
            todo.listTasks();
            System.out.println("----");

            todo.undoAll();
            todo.listTasks();
            System.out.println("----");

            boolean result = todo.markTaskDone(4);
            System.out.println(result);
            System.out.println("----");

            result = todo.undoTask(5);
            System.out.println(result);
            System.out.println("----");

            try {
                todo.addTask(new Task("Do the laundry", 2));
                todo.listTasks();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("----");

            try {
                todo.addTask(new Task("", 4));
                todo.listTasks();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("----");
        }
    }