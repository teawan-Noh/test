package lab.itank2;

import java.util.Scanner;

public class GuessGame {

	Player player;

	public void startGame(Player player) {
		System.out.println("=============================");
		System.out.println("GuessGame을 시작합니다 \n예측하신 번호를 입력해주세요.");

		while(true) {
			int randomNumber = RandomManager.getRandomNumber();
			for (int i = 0; i < 3; i++) {
				player.guess();
				if (randomNumber == player.getNumber()) {
					System.out.println((i + 1) + "번만에 맞추셨습니다");
					System.out.println("=============================");
					break;
				} 
				else {
					System.out.println("틀리셨습니다");
					System.out.println("=============================");
					if (i == 2) {
						System.out.println("3번의 기회를 모두 사용하셨습니다");
					}
				}
			}
			askRetry(player);
			//player.sc.close();
		}
	}
	public void askRetry(Player player) {
		System.out.println("=============================");
		System.out.println("재도전 하시겠습니까?");
		System.out.println("1.재도전  2.종료");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch(n) {
		case 1:
			startGame(player);
			break;
		case 2:
			System.out.println("게임을 종료합니다.");
			System.exit(0);
			break;
		}
		sc.close();
	}
}
