import classes.EmailService;
import classes.IoCContainer;
import classes.SMSService;
import service.Service;
import web.UserController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IoCContainer container = new IoCContainer();

        // Register the service
        Service notificationService = new EmailService();
        container.RegisterService(EmailService.class, notificationService);

        // Retrieve the service from the container
       Service service = container.getService(EmailService.class);

        // Pass the service to the UserController
        UserController userController = new UserController(service);
        userController.notifyUser();

    }
}