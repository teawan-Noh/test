package lab.itank;

public class GuessGame {

	Player player;

	public void startGame(Player player) {
		System.out.println("GuessGame�� �����մϴ� \n�����Ͻ� ��ȣ�� �Է����ּ���.");

		int randomNumber = RandomManager.getRandomNumber();
		for (int i = 0; i < 3; i++) {
			player.guess();
			if (randomNumber == player.getNumber()) {
				System.out.println((i + 1) + "������ ���߼̽��ϴ�");
				System.out.println("=============================");
				break;
			} 
			else {
				System.out.println("Ʋ���̽��ϴ�");
				System.out.println("=============================");
				if (i == 2) {
					System.out.println("3���� ��ȸ�� ��� ����ϼ̽��ϴ� \n������ �����մϴ�.");
				}
			}
		}
		player.sc.close();
	}
}
