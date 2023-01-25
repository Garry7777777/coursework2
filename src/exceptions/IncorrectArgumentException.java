package exceptions;


public class IncorrectArgumentException extends Throwable{
      public IncorrectArgumentException(String s) {
           System.out.println( " не корректное значение: " + s );
      }

}
