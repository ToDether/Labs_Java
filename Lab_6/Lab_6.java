package Lab_6;

public class Lab_6 {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~ TASK #1 ~~~~~~~~~~~~~");
        Task1 task1 = new Task1();
        int value1 = 21;
        int value2 = 45;
        int value3 = -45;
        System.out.println("Binary representation of " + value1 + ": " + task1.intToBinaryString(value1));
        System.out.println("Binary representation of " + value1 + ": " + task1.intToBinaryString(value2));
        try {
            System.out.println("Binary representation of " + value2 + ": " + task1.intToBinaryString(value3));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception for value3: " + e.getMessage());
        }

        System.out.println();

        System.out.println("~~~~~~~~~~ TASK #2 ~~~~~~~~~~~~~");
        Task2 task2 = new Task2();
        String sentence1 = "The user with the nickname koala757677 this month left 3 times more comments than the user with the nickname croco181dile181920 4 months ago";
        String sentence2 = "Hello world!";
        String sentence3 = null;

        System.out.println("Number of words in sentence 1: " + task2.countWords(sentence1));
        System.out.println("Number of words in sentence 2: " + task2.countWords(sentence2));
        try {
            System.out.println("Number of words in sentence 3: " + task2.countWords(sentence3));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception for sentence2: " + e.getMessage());
        }

    }
}

class Task1 {

    public String intToBinaryString(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The input integer must be non-negative");
        }

        return Integer.toBinaryString(i);
    }
}

class Task2 {

    int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("The input sentence cannot be null or empty");
        }

        String[] words = sentence.split("[^a-zA-Z0-9]+");

        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        return count;
    }
}

// ~~~~Контрольні питання~~~:


// 1. Що таке immutable об’єкт? Для чого об’єкти класу String зробили імутабельними? Чому клас String задекларований як final?


// Immutable об'єкт - це об'єкт, стан якого не може бути змінено після створення. На відміну від мутабельних об'єктів, стан яких може змінюватися після створення.Існує кілька причин, чому об'єкти класу String зробили імутабельними. По-перше, це спрощує програмування. Якщо ми знаємо, що об'єкт String є імутабельним, то нам не потрібно турбуватися про те, що він може бути змінений іншим потоком виконання. Це може допомогти уникнути помилок, пов'язаних з одночасним доступом до об'єктів.

// По-друге, імутабельні об'єкти є більш ефективними. Якщо об'єкт не може бути змінений, то немає необхідності зберігати його в пам'яті. Це може призвести до зниження споживання пам'яті та покращення продуктивності.

// По-третє, імутабельні об'єкти є більш безпечними. Якщо об'єкт не може бути змінений, то він не може бути використаний для злому системи. Це може допомогти зробити програму більш захищеною від хакерських атак.

// Клас String задекларований як final, щоб запобігти створенню нових підкласів класу String. Це означає, що програмісти не можуть змінити внутрішню реалізацію класу String. Це допомагає гарантувати, що об'єкти класу String будуть завжди імутабельними.

// Ось кілька прикладів того, як можна використовувати імутабельні об'єкти:

// Для зберігання постійних даних, таких як значення констант або дані, які не повинні змінюватися з часом.
// Для передачі даних між потоками виконання, не турбуючись про те, що вони можуть бути змінені.
// Для створення ефективних і безпечних програм.


// 2. Що таке регулярні вирази? Наведіть приклади регулярних виразів.


// Регулярний вираз - це рядок, який є шаблоном (pattern), який описує набір рядків. Регулярний вираз можна використовувати для пошуку, заміни, поділи або перевірки відповідності рядків.

// У Java регулярні вирази реалізуються за допомогою класів Pattern і Matcher.

// Ось кілька прикладів регулярних виразів:

// Пошук усіх малих літер: [a-z]+
// Пошук усіх чисел: [0-9]+
// Пошук усіх символів від a до z, від A до Z та від 0 до 9: [a-zA-Z0-9]+
// Пошук усіх слів, розділених пробілами: \w+\s+\w+
// Пошук усіх електронних адрес: [a-zA-Z0-9_.]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}


// 3. В чому полягає різниця між оператором «==» та методом «equals()»? 

// Оператор «==» порівнює два об'єкти по посиланню, тобто перевіряє, чи вказують вони на один і той же об'єкт у пам'яті. Метод «equals()» порівнює два об'єкти по значенню, тобто перевіряє, чи мають вони однакові значення всіх своїх полів.


// 4. Для чого потрібні класи StringBuilder та StringBuffer?
//Класи StringBuilder і StringBuffer потрібні для роботи з рядками, які можуть бути змінені. На відміну від класу String, який є імутабельним, об'єкти класів StringBuilder і StringBuffer можна змінювати після створення.

// Класи StringBuilder і StringBuffer схожі, але є між ними одна важлива відмінність:

// Клас StringBuilder не є синхронізованим, а клас StringBuffer є. Це означає, що методи класу StringBuilder можуть бути виконані одночасно декількома потоками виконання, а методи класу StringBuffer - ні.
// Якщо ви не використовуєте багатопоточну програму, то краще використовувати клас StringBuilder, оскільки він швидше, ніж клас StringBuffer. Однак, якщо ви використовуєте багатопотокову програму, то вам потрібно використовувати клас StringBuffer, щоб уникнути проблем з одночасним доступом до об'єктів.

// Ось кілька прикладів того, як можна використовувати класи StringBuilder і StringBuffer:

// Для обробки рядків, які можуть бути змінені. Наприклад, для обробки рядків, які вводяться користувачем.
// Для створення нових рядків шляхом додавання або видалення символів. Наприклад, для створення нових рядків з порядковими номерами.
// Для обробки рядків, які містять велику кількість символів. Наприклад, для обробки рядків, які містять код.


// 5. Яким чином простіше всього прибрати пробіли на початку та кінці об’єкту String?

// Найпростіший спосіб видалити пробіли на початку та кінці об'єкту String - це використовувати метод trim(). Цей метод повертає новий рядок, із видаленими пробіли на початку та кінці.