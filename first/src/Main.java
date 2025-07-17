public class Main {
    public static void main(String[] args){
// Создаем два счета
        BankAccount account1 = new BankAccount("Иван Петров");
        BankAccount account2 = new BankAccount("Мария Сидорова");
        System.out.println(account2.getOwnerName());

        account1.deposit(1000); // Успешное пополнение
        account1.deposit(-200); // Неуспешное пополнение (отрицательная сумма)
        account1.deposit(500);  // Еще одно успешное пополнение
        System.out.println(account1.getBalance());

        account1.withdraw(300);  // Успешное снятие
        account1.withdraw(1000); // Недостаточно средств (1000 + 500 - 300 = 1200, пытаемся снять 1000) - должно быть OK
        account1.withdraw(1500); // Недостаточно средств (1200 - 1000 = 200, пытаемся снять 1500) - должно быть FAIL
        account1.withdraw(-100); // Неуспешное снятие (отрицательная сумма)
        account1.withdraw(0);    // Неуспешное снятие (нулевая сумма)
        System.out.println(account1.getBalance());

        account1.transfer(account2, 200); // Успешный перевод
        account1.transfer(account2, 1000); // Недостаточно средств (осталось 200, пытаемся перевести 1000) - FAIL
        account1.transfer(account2, -100); // Неуспешный перевод (отрицательная сумма)
        account1.transfer(account2, 0);    // Неуспешный перевод (нулевая сумма)
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

    }
}
