package com.company;


    import java.util.*;

import static com.company.Oyunchular.*;
    public class ChykoGame {

        Random random = new Random();
        public Oyunjyiyntyk usersTurn(){
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            int guess = 0;
            int x = 0;
            int probability = 2;
            System.out.println("Оюн башталды");
            do {
                System.out.println("Сиз  сан  киргизиниш  керек 2ден  12 ге  чейин : ");
                guess = scan.nextInt();


            }
            while (guess < 2 || guess > 12);
            System.out.println("Ойногнуз  келбей жатабы  же алдгыныз  келдиби ?");
            String ans = scan2.nextLine();
            boolean minus = true;
            if (ans.equals("y")){
                int cheating1 = random.nextInt(1, probability + 1);
                int cheating2 = random.nextInt(1, probability + 1);
                minus = false;
                System.out.println(cheating1+" - "+cheating2+" "+probability);
                if (cheating1==cheating2){
                    guess = getResultOfRolling();
                    minus = true;
                }
            }


            int resultOfRolling = getResultOfRolling();

            getResult(OYUNCHU,
                    resultOfRolling,
                    guess,
                    "Сиз  ута  баштадыныз!",
                    "Сиз  утулуп жатасыз     "
            );

            int result = getResult(resultOfRolling, guess);

            Oyunjyiyntyk gameResult = new Oyunjyiyntyk(guess, resultOfRolling, result);
            return gameResult;
        }




        public Oyunjyiyntyk computersTurn() {
            Random random = new Random();
            System.out.println("компьютер  баштады  !");
            int guess = random.nextInt(1, 12);

            int resultOfRolling = getResultOfRolling();

            getResult(COMPUTER,
                    resultOfRolling,
                    guess,
                    "компьютер  выишгрывает!!",
                    "компьютер  проигрывает ."
            );

            int result = getResult(resultOfRolling, guess);

            Oyunjyiyntyk oyunjyiyntyk = new Oyunjyiyntyk(guess, resultOfRolling, result);
            System.out.println("\n  Оюн бутту " + "\n  Жыйынтыгы: ");
            return oyunjyiyntyk;
        }

        private int getResultOfRolling() {
           Chyko chyko = new Chyko();
            System.out.println("чукону окчоо...");
            int resultOfRolling = chyko.roll();

            Chyko chyko2 = new Chyko();
            System.out.println("экинчи чукону окчоо...");
            resultOfRolling += chyko2.roll();

            return resultOfRolling;
        }

        public void playPart3() {
            Map<Oyunchular, List<Oyunjyiyntyk>> results = new HashMap<>(Map.of(
                    OYUNCHU, new ArrayList<>(),
                    COMPUTER, new ArrayList<>()
            ));


            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    Oyunjyiyntyk oyunjyiyntyk = usersTurn();
                    results.get(OYUNCHU).add(oyunjyiyntyk);
                } else {
                    Oyunjyiyntyk oyunjyiyntyk = computersTurn();
                    results.get(COMPUTER).add(oyunjyiyntyk);
                }
            }

              printResult(results);
        }

        private void printResult(Map<Oyunchular, List<Oyunjyiyntyk>> results) {
            System.out.println(OYUNCHU.name());
            List<Oyunjyiyntyk> usersResult = results.get(OYUNCHU);
            usersResult.forEach(System.out::print);

            System.out.println(COMPUTER.name());
            List<Oyunjyiyntyk> computerResults = results.get(COMPUTER);
            computerResults.forEach(System.out::print);
        }

        private void getResult(Oyunchular gamePlayer,
                               int chykochet,
                               int oyunchutapty,
                               String winningMessage,
                               String losingMessage) {
            int result = getResult(chykochet, oyunchutapty);
            if (gamePlayer.equals(OYUNCHU)) {
                System.out.println("эсеп : " + chykochet);
                System.out.println("сиздин оюнуз : " + oyunchutapty);
                System.out.println("жалпы эсеп : " + result);
            } else {
                System.out.println("эсеп : " + chykochet);
                System.out.println("компьютердин ою : " + oyunchutapty);
                System.out.println("жалпы эсеп : " + result);
            }
            System.out.println(result > 0 ? winningMessage : losingMessage);
        }

        private int getResult(int diceScore, int userGuess) {
            return diceScore - Math.abs(diceScore - userGuess) * 2;
        }

    }


