public class ErrorInThread {
    public static void main(String[] args) {

        new ErrorInThread();
    }

    public ErrorInThread() {
        Operation operation = new Operation();

        for(int i = 0; i <= 1000; i++){
            new Thread1(operation).start();
        }
    }

    private static class Operation {
        private int number = 0;
        public  int operation() {   // synchronized
            number = number + 1;
            number = number - 1;

            return number;
        }
    }

    private static class Thread1 extends Thread  {
        Operation operation;

        public Thread1(Operation o ) {
            operation = o;
        }

        @Override
        public void run() {
            for(int i = 0; i <= 10000; i++){
                operation.operation();
            }

            System.out.println(operation.number);

        }
    }
}