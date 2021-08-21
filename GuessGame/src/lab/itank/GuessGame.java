package lab.itank;

public class GuessGame {

	Player player;

	public void startGame(Player player) {
		System.out.println("GuessGame을 시작합니다 \n예측하신 번호를 입력해주세요.");

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
					System.out.println("3번의 기회를 모두 사용하셨습니다 \n게임을 종료합니다.");
				}
			}
		}
		player.sc.close();
	}
}
