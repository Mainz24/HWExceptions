package HWExceptions;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class Main {
    public static void main (String[] args)
            throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();

        System.out.println("Введите пароль: ");
        String pass = scanner.nextLine();

//        System.out.println("Введите email: ");
//        String email = scanner.nextLine();
        User user = getUserByLoginAndPassword(login, pass);
        validateUser(user);
    }
    public static void validateUser(User user) throws AccessDeniedException{
        if (user.getAge() < 18) {
            throw new  AccessDeniedException("Доступ запрещен!");
        } else {
                    System.out.println("Доступ разрешен!");
        }
    }
    public static User[] getUser() {
        User userMax = new User("Max", "123", "max@mail.ru", 26 );
        User userMilli = new User("Milli", "456", "milli@mail.ru", 30);
        User userNikol = new User("Nikol", "789", "nikol@mail.ru", 17);
        return new User[]{userMax, userMilli, userNikol};
    }
    public static User getUserByLoginAndPassword(String login, String password)
            throws UserNotFoundException {
        for (User user : getUser()) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password));
            return user;
        }
        throw new UserNotFoundException("Пользователь не найден!");
    }
}
