import java.util.Random;
import java.util.ArrayList;

class Game {
    ArrayList<Integer> numbers;
    Random random = new Random();

    public Game() {
        generateNumbers();
    }

    void generateNumbers() {
        numbers.clear();
        while(numbers.size() < 3) {
            numbers.add(getRandomNumber());
        }
    }

    int getRandomNumber() {
        int result = 0;
        while(result == 0 || numbers.contains(result)) {
            result = random.nextInt(9);
        }
        return result;
    }
}
