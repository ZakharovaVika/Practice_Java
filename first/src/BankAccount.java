import java.time.LocalDateTime;

public class BankAccount {
    private String ownerName;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;
    BankAccount( String ownerName){
        this.ownerName = ownerName;
        this.balance = 0; // Начальный баланс 0
        this.openingDate = LocalDateTime.now(); // Текущая дата и время открытия
        this.isBlocked = false; // Счет изначально не заблокирован
    }
    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }
    public boolean isBlocked() {
        return isBlocked;
    }

    public boolean deposit(int amount) {
        // Проверка на заблокированный счет
        if (this.isBlocked) {
            System.out.println("Ошибка: Невозможно пополнить счет '" + ownerName + "', так как он заблокирован.");
            return false;
        }
        // Проверка на корректность суммы
        if (amount <= 0) {
            System.out.println("Ошибка: Сумма пополнения должна быть положительной.");
            return false;
        }

        this.balance += amount; // Увеличиваем баланс
        System.out.println("Пополнение счета '" + ownerName + "' на " + amount + " успешно. Новый баланс: " + this.balance);
        return true;
    }
    public boolean withdraw(int amount) {
        // Проверка на заблокированный счет
        if (this.isBlocked) {
            System.out.println("Ошибка: Невозможно снять средства со счета '" + ownerName + "', так как он заблокирован.");
            return false;
        }
        // Проверка на корректность суммы
        if (amount <= 0) {
            System.out.println("Ошибка: Сумма снятия должна быть положительной.");
            return false;
        }
        // Проверка на достаточность средств
        if (this.balance < amount) {
            System.out.println("Ошибка: Недостаточно средств на счете '" + ownerName + "'. Текущий баланс: " + this.balance + ", попытка снять: " + amount);
            return false;
        }

        this.balance -= amount; // Уменьшаем баланс
        System.out.println("Снятие со счета '" + ownerName + "' на " + amount + " успешно. Новый баланс: " + this.balance);
        return true;
    }
    public boolean transfer(BankAccount otherAccount, int amount) {
        // Проверка, что целевой счет существует и не равен текущему счету
        if (otherAccount == null) {
            System.out.println("Ошибка: Целевой счет не указан (null).");
            return false;
        }
        if (this == otherAccount) {
            System.out.println("Ошибка: Нельзя перевести деньги на тот же самый счет.");
            return false;
        }

        // Проверка на заблокированный текущий счет
        if (this.isBlocked) {
            System.out.println("Ошибка: Невозможно выполнить перевод со счета '" + ownerName + "', так как он заблокирован.");
            return false;
        }
        // Проверка на заблокированный целевой счет
        if (otherAccount.isBlocked()) {
            System.out.println("Ошибка: Невозможно выполнить перевод на счет , так как он заблокирован.");
            return false;
        }
        // Проверка на корректность суммы
        if (amount <= 0) {
            System.out.println("Ошибка: Сумма перевода должна быть положительной.");
            return false;
        }
        // Проверка на достаточность средств на текущем счете
        if (this.balance < amount) {
            System.out.println("Ошибка: Недостаточно средств на счете '" + ownerName + "' для перевода. Текущий баланс: " + this.balance + ", попытка перевести: " + amount);
            return false;
        }

        // Если все проверки пройдены, выполняем перевод
        // Сначала снимаем с текущего счета
        this.balance -= amount;
        // Затем зачисляем на целевой счет
        otherAccount.balance += amount;

        System.out.println("Перевод со счета '" + ownerName + "' на сумму " + amount + " успешно.");
        System.out.println("Баланс счета '" + ownerName + "': " + this.balance);
        return true;
    }

}
