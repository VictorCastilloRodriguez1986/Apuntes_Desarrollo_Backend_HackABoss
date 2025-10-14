// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		int num1, num2, sum;
		num1 = 10; // Initialize num1 with a value
		num2 = 20;
		sum = num1 + num2;
		System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
		int num3 = 30;
		sum += num3;
		System.out.println("The new sum after adding " + num3 + " is: " + sum);

		final String NOMBRE = "John Doe"; // Declare a constant

		int seconds = 300020;
		int minutes = seconds / 60; // Convert seconds to minutes
		int remainingSeconds = seconds % 60; // Get the remaining seconds
		System.out.println("Total minutes: " + minutes);
		System.out.println("Remaining seconds: " + remainingSeconds);
		int hours = minutes / 60; // Convert minutes to hours
		int remainingMinutes = minutes % 60; // Get the remaining minutes
		System.out.println("Total hours: " + hours);
		System.out.println("Remaining minutes: " + remainingMinutes);

		System.out.println("Han pasado " + hours + " horas, " + remainingMinutes + " minutos y " + remainingSeconds + " segundos desde el inicio del programa.");

		System.out.println(83*3600 + 20*60 + 20);
	}

}