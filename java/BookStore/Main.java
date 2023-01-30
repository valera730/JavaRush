import model.*;

import java.util.ArrayList;

public class Main {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Seller> sellers = new ArrayList<>();
    static ArrayList<Buyer> buyers = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        initData();
        System.out.println(getBookById(2).getPrice());

        System.out.println(getCountSoldBooks());
    }

    //получить сумму проданных книг в одном заказе
    public static int getSummSoldedBooksInOneOrder(int orderId) {
        int count = 0;
        for (Order order : orders) {
            if (order.getId() == orderId) {
                count = order.getBooks().length;
            }
        }

        return count;
    }

    //получить количество проданных книг
    public static int getCountSoldBooks() {
        int count = 0;
        for (Order order : orders) {
            count += order.getBooks().length;
        }

        return count;
    }

    /**
     * поиск книги в списке книг по Id
     *
     * @param id уникальный номер книги
     * @return найденная книга
     */
    public static Book getBookById(long id) {
        Book current = null;

        for (Book book : books) {
            if (book.getId() == id) {
                current = book;
                break;
            }
        }

        return current;
    }

    public static void initData() {
        sellers.add(new Seller(1, "Иванов Иван", 32));
        sellers.add(new Seller(2, "Петров Пётр", 30));
        sellers.add(new Seller(3, "Васильева Алиса", 26));

        buyers.add(new Buyer(1, "Сидоров Алексей", 25));
        buyers.add(new Buyer(2, "Романов Дмитрий", 32));
        buyers.add(new Buyer(3, "Симонов Кирилл", 19));
        buyers.add(new Buyer(4, "Кириенко Данил", 45));
        buyers.add(new Buyer(5, "Воротынцева Элина", 23));

        books.add(new Book(1, "Война и мир", "Лев Толстой", 1600, BookGenre.Art));
        books.add(new Book(2, "Преступление и наказание", "Федор Достоевский", 600, BookGenre.Art));
        books.add(new Book(3, "Мертвые души", "Николай Гоголь", 750, BookGenre.Art));
        books.add(new Book(4, "Руслан и Людмила", "Александр Пушкин", 500, BookGenre.Art));

        books.add(new Book(5, "Введение в психоанализ", "Зигмунд Фрейд", 1050, BookGenre.Psychology));

        books.add(new Book(6, "Gang of four", "Эрих Гамма", 900, BookGenre.Programming));

        orders.add(new Order(1, 1, 1, new long[]{2, 3, 4, 6}));
        orders.add(new Order(2, 1, 2, new long[]{1}));
        orders.add(new Order(3, 2, 3, new long[]{5, 6, 7}));
        orders.add(new Order(4, 2, 4, new long[]{1, 2, 3, 4}));
        orders.add(new Order(5, 2, 3, new long[]{2, 5, 6}));
    }
}