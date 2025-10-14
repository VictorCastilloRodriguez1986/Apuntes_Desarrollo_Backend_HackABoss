public class RepasoExepciones {
    public static void main(String[] args) {
        Character op = '-';
        Integer numeroA = 3;
        Integer numeroB = 1;
        Integer resultado = 0;
        try {
            try {
                funcionQueGeneraExcepcion();
            }catch (MyException e){
                System.out.println(e.getMessage());
            }

            switch (op) {
                case '+':
                    resultado = suma(numeroA, numeroB);
                    break;
                case '-':
                    resultado = resta(numeroA, numeroB);
                    break;
                case '*':
                    resultado = multiplicacion(numeroA, numeroB);
                    break;
                case '/':
                    resultado = division(numeroA, numeroB);
                    break;
                default:
                    //System.out.println("Operador no valido");
                    throw new MyException("Operador no valido");
            }

            System.out.printf("%d %c %d = %d", numeroA, op, numeroB, resultado); // 3 + 4 = 7
            System.out.println();
            // System.out.println(numeroA + " " + op + " " + numeroB + " = " + resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("El programa sigue....");
    }

    private static void funcionQueGeneraExcepcion() {
        //throw new MyException("Error no grave");
        Integer res = 4 / 0;
    }

    private static Integer division(Integer n1, Integer n2) {
        if(n2 == 0){
            throw new MyException("No se puede dividir por zero!");
        }
        return (Integer) n1 / n2;
    }

    private static Integer multiplicacion(Integer n1, Integer n2) {
        return n1 * n2;
    }

    private static Integer resta(Integer n1, Integer n2) {
        if(n2 > n1){
            throw new MyException("La calculadora no gestiona números negativos!");
        }
        return n1 - n2;
    }

    private static Integer suma(Integer n1, Integer n2) {
        return n1 + n2;
    }
}
