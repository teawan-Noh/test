package lab.itank;

public class GuessGame {
	
	Player player;
	
	public void startGame() {
		
		RandomManager m1 = new RandomManager();
		int randomNumber = m1.getRandomNumber();
		
		Player p1 = new Player();
		int count = 1;
		int i = 1;
		p1.guess();
		while(i < 4) {
			int playerNum = p1.getNumber();
			if(randomNumber == playerNum) {
				System.out.println(count + "번만에 맞추셨습니다");
				break;
			}
			else {
				System.out.println("틀리셨습니다");
				i++;
				if(i == 4) {
					System.out.println("3번의 기회를 모두 날리셨군요");
					break;
				}
				count += 1;
				p1.guess();
			}
		}
	}
}

