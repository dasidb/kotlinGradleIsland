import org.junit.Test;

public class Test1 {


    public static void main(String[] args) {
        Test1 test = new Test1();
        test.scoreAsFives("23455");
    }

    public int scoreAsFives(String roll){

        return (int) (roll.chars()
                .filter(c -> c == '5')
                .count() *5 );

    }


}
