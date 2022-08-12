package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Lada", 2110)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("WV Polo", 214)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Niva", 2014)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Lada", 2110)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user.toString());
            System.out.println(user.getCar().toString());
        }

        List<User> usersWithCar = userService.findUserByCarModelAndSeries("Lada", 2110);
        for (User user : usersWithCar) {
            System.out.println("finding...");
            System.out.println(user.toString());
            System.out.println(user.getCar().toString());
        }

        context.close();
    }
}
