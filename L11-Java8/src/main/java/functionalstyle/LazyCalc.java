package functionalstyle;

import java.util.Date;
import java.util.function.Function;

import static java.lang.Thread.sleep;

public class LazyCalc {


    public static void main(String[] args){
        var calc = new LazyCalc();
        var variable = true;
        var startTime = new Date().getTime();
        System.out.println("== FIRST VARIANT == ");
        calc.calculation(true, calc.veryHeavyFunc( 60 ));
        var endTime = new Date().getTime();
        System.out.println("== FIRST, true time : " + (endTime - startTime));
        startTime = endTime;
        calc.calculation(false, calc.veryHeavyFunc( 60 ));
        endTime = new Date().getTime();
        System.out.println("== FIRST, true time : " + (endTime - startTime));
        startTime = endTime;


        System.out.println("== SECOND VARIANT == ");
        calc.calculation( true, 60, calc::veryHeavyFunc );
        endTime = new Date().getTime();
        System.out.println("==  true time : " + (endTime - startTime));
        startTime = endTime;
        calc.calculation( false, 60, calc::veryHeavyFunc );
        endTime = new Date().getTime();
        System.out.println("== true time : " + (endTime - startTime));

    }

    private void calculation( boolean variable, int value, Function<Integer, Integer> veryHeavyFunc ) {
        if (variable){
            // do smth
        } else {
            System.out.println(veryHeavyFunc.apply( value ));
        }
    }

    private void calculation( boolean variable, Integer veryHeavyFunc ) {
        if (variable){
            // do smth
        } else {
            System.out.println(veryHeavyFunc);
        }
    }


    private Integer veryHeavyFunc(Integer input){
        try {
            sleep(1000L);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        return input*2;
    }
}
