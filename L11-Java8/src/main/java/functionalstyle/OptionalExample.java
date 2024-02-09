package functionalstyle;

import java.util.Optional;

public class OptionalExample {
    public static void main( String[] args ) {
        var data = Optional.ofNullable( someData() );

        var result = data
                .map( OptionalExample::someFunc1 )
                .map( OptionalExample::someFunc2 )
                .filter( v -> v < 200 )
                .orElseThrow( () -> new RuntimeException( "data is null" ) );
    }

    private static Integer someData() {
        return 50;
        //return null;
    }

    // Nullable
    private static Integer someFunc1( Integer value ) {
        return 50 + value;
        //return null;
    }

    // Nullable
    private static Integer someFunc2( Integer value ) {
        return value * 2;
        //return null;
    }
}
