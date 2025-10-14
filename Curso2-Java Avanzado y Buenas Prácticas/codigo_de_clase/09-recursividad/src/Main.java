public class Main {
    public static void main(String[] args) {
        //Sucesión de Fibonacci = {0, 1, 1, 2, 3, 5, 8, 13, 21...}
        System.out.println("Sin recursividad: " + fib(7));
        System.out.println("Con recursividad: " + fibr(7));
    }

    // Sin Recursividad
    public static int fib(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, r = 0;
        for (int i = 2; i <= n; i++) {
            r = a + b;
            a = b;
            b = r;
        }
        return r;
    }

    // Con Recursividad
    public static int fibr(int n) {
        if (n <= 1) return n;                       // caso base
        return fibr(n - 1) + fibr(n - 2);           // llamada recursiva
    }
}