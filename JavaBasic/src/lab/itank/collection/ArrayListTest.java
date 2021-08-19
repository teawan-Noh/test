package lab.itank.collection;

import java.util.ArrayList;

public class ArrayListTest { //�������� �迭
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("A"); //0���濡 A
		list.add("B"); //1���濡 B
		list.add("C"); //2���濡 C
		
		for (int i = 0; i < list.size(); i++) { //�迭�� ũ�⸦ ������
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		list.set(1, "BB");  //�迭�� 1���濡 �ִ� B�� BB�� �ٲ��ش�
		
		for (String string : list) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		list.remove(1); //�迭�� 1������ ����
		
		for (String string : list) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		//Book��ü�� �ִ� ArrayList�� �����ϼ���
		//å 3���� ��������.
		//��� å�� ����(�̸�, ����) ����ϼ��� (for�� 2���� �� ���)
		//�˰����� å�� ������ 1500���� �������ּ���
		//������ 3500, java2 5500 2���� �߰����ּ���
		//java å�� �˻��ؼ� ������ּ���
		//�������� Java å�� �������ּ���
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("Java", 3000));
		bookList.add(new Book("Spring", 5000));
		bookList.add(new Book("�˰���", 1000));
		
		
		
		for(int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			System.out.println(book.getName() + ", " + book.getPrice());
			//System.out.println(bookList.get(i).getName() + ", " + bookList.get(i).getPrice());
		}
		System.out.println("=========================================");
		
		for(Book string : bookList) {
			System.out.println(string.getName() + ", " + string.getPrice());
		}
		System.out.println("=========================================");
		
		bookList.get(2).setPrice(1500);
		//bookList.set(2, new Book("�˰���", 1500)); //��å�缭 ������ �̷���
		
		//for(Book item : bookList) {            //�˰��� �˻��ؼ� ���� ����
		//	if(item.getName().equals("�˰���"))
		//		item.setPrice(1500);
		//}
		
		bookList.add(new Book("������", 3500));
		bookList.add(new Book("java2", 5500));
		
		//�˻��ؼ� ���
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getName().toLowerCase().contains("java")) {
				System.out.println(bookList.get(i).getName() + bookList.get(i).getPrice());
			}
		}
		System.out.println("=========================================");
		
		//�˻��ؼ� ����
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getName().contains("Java")) {
				bookList.remove(i);
			}
		}
		//2�� �� for�� ���� //�������� �迭�� ũ�Ⱑ �پ�� ������ ����� //break; ����ؼ� �������� ���������� 
		
		//Ȯ��
//		System.out.println("=========================================");
//		for(int i = 0; i < bookList.size(); i++) {
//			System.out.print(bookList.get(i).getName() + ", ");
//			System.out.println(bookList.get(i).getPrice());
//		}
		
	}
}
