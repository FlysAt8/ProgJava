package lr3;

import java.util.*;

public class CollectionBenchmark {
    
    private static final int ADD_REMOVE_COUNT = 3_000_000;           // 3 млн элементов
    private static final long GET_OPERATIONS = 3_000_000L;      // 3 млрд операций
    private static final long TIMEOUT_MS = 5000;                    // 5 секунд таймаут
    private static volatile boolean timeoutReached = false;
    
    public static void main(String[] args) {
        System.out.println("СРАВНИТЕЛЬНЫЙ АНАЛИЗ ПРОИЗВОДИТЕЛЬНОСТИ КОЛЛЕКЦИЙ");
        System.out.println();

        // ДОБАВЛЕНИЕ
        System.out.println("-".repeat(60));
        System.out.println("СРАВНЕНИЕ ВРЕМЕНИ ДОБАВЛЕНИЯ ЭЛЕМЕНТОВ");
        
        // ArrayList
        System.out.println("\nКоллекция ArrayList");
        testArrayListAdd();
        
        // ArrayDeque
        System.out.println("\nКоллекция ArrayDeque");
        testArrayDequeAdd();
        
        // LinkedHashSet
        System.out.println("\nКоллекция LinkedHashSet");
        testLinkedHashSetAdd();
        
        // УДАЛЕНИЕ
        System.out.println("-".repeat(60));
        System.out.println("\nСРАВНЕНИЕ ВРЕМЕНИ УДАЛЕНИЯ ЭЛЕМЕНТОВ");
        
        // ArrayList
        System.out.println("\nКоллекция ArrayList");
        testArrayListRemove();
        
        // ArrayDeque
        System.out.println("\nКоллекция ArrayDeque");
        testArrayDequeRemove();
        
        // LinkedHashSet
        System.out.println("\nКоллекция LinkedHashSet");
        testLinkedHashSetRemove();
        
        
        // ПОЛУЧЕНИЕ
        System.out.println("-".repeat(60));
        System.out.println("\nСРАВНЕНИЕ ВРЕМЕНИ ПОЛУЧЕНИЯ ЭЛЕМЕНТА ПО ИНДЕКСУ");
        System.out.println("(количество 3 млн)");
        
        // ArrayList
        System.out.println("\nКоллекция ArrayList");
        testArrayListGet();
        
        // ArrayDeque
        System.out.println("\nКоллекция ArrayDeque");
        testArrayDequeGet();
        
        // LinkedHashSet
        System.out.println("\nКоллекция LinkedHashSet");
        testLinkedHashSetGet();
    }
    
    // ==================== МЕТОДЫ С ТАЙМАУТОМ ====================
    
    /**
     * Выполнение операции с проверкой таймаута
     */
    private static long executeWithTimeout(Operation operation, String operationName) {
        timeoutReached = false;
        
        Thread timeoutThread = new Thread(() -> {
            try {
                Thread.sleep(TIMEOUT_MS);
                timeoutReached = true;
            } catch (InterruptedException e) {
                // Нормальное завершение
            }
        });
        
        timeoutThread.start();
        
        long start = System.currentTimeMillis();
        try {
            operation.execute();
            long end = System.currentTimeMillis();
            timeoutThread.interrupt();
            
            if (timeoutReached) {
                return -2; // Таймаут
            }
            return end - start;
        } catch (Exception e) {
            timeoutThread.interrupt();
            return -1; // Ошибка
        }
    }
    
    // ==================== ДОБАВЛЕНИЕ ====================
    
    private static void testArrayListAdd() {
        // Добавление в конец (быстрая операция)
        long endTime = executeWithTimeout(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                list.add(i);
            }
        }, "добавление в конец");
        System.out.println("в конец (мс) - " + formatTime(endTime));
        
        // Добавление в начало (медленная операция)
        long beginTime = executeWithTimeout(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                list.add(0, i);
            }
        }, "добавление в начало");
        System.out.println("в начало (мс) - " + formatTime(beginTime));
        
        // Добавление в середину (медленная операция)
        long middleTime = executeWithTimeout(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                list.add(list.size() / 2, i);
            }
        }, "добавление в середину");
        System.out.println("в середину (мс) - " + formatTime(middleTime));
    }
    
    private static void testArrayDequeAdd() {
        // Добавление в конец
        long endTime = executeWithTimeout(() -> {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                deque.addLast(i);
            }
        }, "добавление в конец");
        System.out.println("в конец (мс) - " + formatTime(endTime));
        
        // Добавление в начало
        long beginTime = executeWithTimeout(() -> {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                deque.addFirst(i);
            }
        }, "добавление в начало");
        System.out.println("в начало (мс) - " + formatTime(beginTime));
        
        // Добавление в середину (нет операции)
        System.out.println("в середину (мс) - нет операции (добавление только в начало/конец)");
    }
    
    private static void testLinkedHashSetAdd() {
        long time = executeWithTimeout(() -> {
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                set.add(i);
            }
        }, "добавление");
        System.out.println("добавление (мс) - " + formatTime(time));
        System.out.println("(все добавления выполняются одинаково, позиция не важна)");
    }
    
    // ==================== УДАЛЕНИЕ ====================
    
    private static void testArrayListRemove() {
        // Удаление с конца
        long endTime = executeWithTimeout(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                list.add(i);
            }
            for (int i = ADD_REMOVE_COUNT - 1; i >= 0 && !timeoutReached; i--) {
                list.remove(i);
            }
        }, "удаление с конца");
        System.out.println("в конце (мс) - " + formatTime(endTime));
        
        // Удаление с начала
        long beginTime = executeWithTimeout(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                list.add(i);
            }
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                list.remove(0);
            }
        }, "удаление с начала");
        System.out.println("в начале (мс) - " + formatTime(beginTime));
        
        // Удаление из середины
        long middleTime = executeWithTimeout(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                list.add(i);
            }
            for (int i = 0; i < ADD_REMOVE_COUNT / 2 && !timeoutReached; i++) {
                list.remove(list.size() / 2);
            }
        }, "удаление из середины");
        System.out.println("в середине (мс) - " + formatTime(middleTime));
    }
    
    private static void testArrayDequeRemove() {
        // Удаление с конца
        long endTime = executeWithTimeout(() -> {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                deque.add(i);
            }
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                deque.removeLast();
            }
        }, "удаление с конца");
        System.out.println("в конце (мс) - " + formatTime(endTime));
        
        // Удаление с начала
        long beginTime = executeWithTimeout(() -> {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                deque.add(i);
            }
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                deque.removeFirst();
            }
        }, "удаление с начала");
        System.out.println("в начале (мс) - " + formatTime(beginTime));
        
        // Удаление из середины
        long middleTime = executeWithTimeout(() -> {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                deque.add(i);
            }
            for (int i = ADD_REMOVE_COUNT / 3; i < 2 * ADD_REMOVE_COUNT / 3 && !timeoutReached; i++) {
                deque.remove(i);
            }
        }, "удаление из середины");
        System.out.println("в середине (мс) - " + formatTime(middleTime));
    }
    
    private static void testLinkedHashSetRemove() {
        long time = executeWithTimeout(() -> {
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                set.add(i);
            }
            for (int i = 0; i < ADD_REMOVE_COUNT && !timeoutReached; i++) {
                set.remove(i);
            }
        }, "удаление");
        System.out.println("удаление (мс) - " + formatTime(time));
        System.out.println("(все удаления выполняются одинаково, позиция не важна)");
    }
    
    // ==================== ПОЛУЧЕНИЕ ПО ИНДЕКСУ ====================
    
    private static void testArrayListGet() {
        long time = executeWithTimeout(() -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                list.add(i);
            }
            int size = list.size();
            // 3 МЛРД операций доступа с проверкой таймаута
            for (long i = 0; i < GET_OPERATIONS && !timeoutReached; i++) {
                list.get((int)(i % size));
            }
        }, "получение по индексу (3 млн операций)");
        System.out.println("по индексу (мс) - " + formatTime(time));
        System.out.println("(прямой доступ O(1), 3 млн операций)");
    }
    
    private static void testArrayDequeGet() {
        long time = executeWithTimeout(() -> {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                deque.add(i);
            }
            // Для ArrayDeque нет доступа по индексу, поэтому итерация
            // Выполняем итерацию, чтобы получить сопоставимое количество операций
            long operationsPerIteration = ADD_REMOVE_COUNT;
            long neededIterations = GET_OPERATIONS / operationsPerIteration;
            neededIterations = Math.min(neededIterations, 1000); // Ограничиваем для таймаута
            
            for (long iter = 0; iter < neededIterations && !timeoutReached; iter++) {
                Iterator<Integer> it = deque.iterator();
                while (it.hasNext() && !timeoutReached) {
                    it.next();
                }
            }
        }, "итерация (3 млн операций)");
        System.out.println("по индексу (мс) - " + formatTime(time));
        System.out.println("(нет доступа по индексу, используется итерация O(n))");
    }
    
    private static void testLinkedHashSetGet() {
        long time = executeWithTimeout(() -> {
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            for (int i = 0; i < ADD_REMOVE_COUNT; i++) {
                set.add(i);
            }
            // Для LinkedHashSet нет доступа по индексу, поэтому итерация
            long operationsPerIteration = ADD_REMOVE_COUNT;
            long neededIterations = GET_OPERATIONS / operationsPerIteration;
            neededIterations = Math.min(neededIterations, 1000); // Ограничиваем для таймаута
            
            for (long iter = 0; iter < neededIterations && !timeoutReached; iter++) {
                Iterator<Integer> it = set.iterator();
                while (it.hasNext() && !timeoutReached) {
                    it.next();
                }
            }
        }, "итерация (3 млн операций)");
        System.out.println("по индексу (мс) - " + formatTime(time));
        System.out.println("(нет доступа по индексу, используется итерация O(n))");
    }
    
    // ==================== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ====================
    
    @FunctionalInterface
    private interface Operation {
        void execute() throws Exception;
    }
    
    private static String formatTime(long timeMs) {
        if (timeMs == -2) {
            return "> " + TIMEOUT_MS + " (ТАЙМАУТ)";
        } else if (timeMs == -1) {
            return "ОШИБКА";
        } else {
            return timeMs + " мс";
        }
    }
}