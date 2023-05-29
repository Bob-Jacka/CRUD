public class NotRegisteredException extends RuntimeException {
    NotRegisteredException() {
        super();
        System.out.println("Такого игрока нет в списке");
    }
}
