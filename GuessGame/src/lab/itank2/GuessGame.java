package lab.itank2;

import java.util.Scanner;

public class GuessGame {

	Player player;

	public void startGame(Player player) {
		System.out.println("=============================");
		System.out.println("GuessGame�� �����մϴ� \n�����Ͻ� ��ȣ�� �Է����ּ���.");

		while(true) {
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
						System.out.println("3���� ��ȸ�� ��� ����ϼ̽��ϴ�");
					}
				}
			}
			askRetry(player);
			//player.sc.close();
		}
	}
	public void askRetry(Player player) {
		System.out.println("=============================");
		System.out.println("�絵�� �Ͻðڽ��ϱ�?");
		System.out.println("1.�絵��  2.����");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch(n) {
		case 1:
			startGame(player);
			break;
		case 2:
			System.out.println("������ �����մϴ�.");
			System.exit(0);
			break;
		}
		sc.close();
	}
}
