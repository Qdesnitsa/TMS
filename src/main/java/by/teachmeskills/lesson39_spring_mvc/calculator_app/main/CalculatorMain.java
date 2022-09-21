//package by.teachmeskills.lesson39_spring_mvc.calculator_app.main;
//
//import by.teachmeskills.lesson39_spring_mvc.calculator_app.springconfig.RootConfiguration;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class CalculatorMain {
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(RootConfiguration.class);
//
//        Application app = context.getBean("application", Application.class);
//        app.run();
//
////        Calculator dataFromConsole = new Calculator();
////        dataFromConsole.getResult();
////        OutputConsole.printResultingMsg(dataFromConsole.toString());
////
////        Calculator dataFromArgument = new Calculator("1,1+19.1-((3-2)+15)/1");
////        dataFromArgument.getResult();
////        OutputConsole.printResultingMsg(dataFromArgument.toString());
//    }
//}
