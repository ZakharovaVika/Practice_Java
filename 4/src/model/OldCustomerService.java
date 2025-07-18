package model;

import annotations.DeprecatedEx;

@DeprecatedEx(message = "Используйте класс 'NewCustomerService'")
public class OldCustomerService {
    @DeprecatedEx(message = "Используйте метод 'processNewCustomer'")
    public void processCustomer() {
        System.out.println("Обработка старого клиента...");
    }

    public void processNewCustomer() {
        System.out.println("Обработка нового клиента...");
    }
}
