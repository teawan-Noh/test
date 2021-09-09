package com.biz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dao.ArrayListBookDataAccessDaoImpl;
import com.dao.BookDataAccessDao;
import com.dto.Book;
import com.view.FormatWriter;
import com.view.InputValueReader;
import com.view.Menu;
import com.view.Message;

//�������� �ý��� �����κ�
public class BookManager {
	// ���̻� ��ü ���� �������� ���ÿ�.
	InputValueReader reader = new InputValueReader();
	BookDataAccessDao dao = new ArrayListBookDataAccessDaoImpl();

	public void start() throws IOException {
		while (true) {
			FormatWriter.showMenu(Menu.MENU01);
			FormatWriter.showMessage(Message.MESSAGE09);
			int selectMenu = reader.readIntValue();
			switch (selectMenu) {
			case 1:// ����
				while (true) {
					FormatWriter.showMessage(Message.MESSAGE11);
					Book book = reader.readBookData();
					if (book != null) {
						FormatWriter.showMessage(Message.MESSAGE01);
						while (true) {
							FormatWriter.showMenu(Menu.MENU02);
							int saveOrNot = reader.readIntValue();
							switch (saveOrNot) {
							case 1:
								dao.saveBook(book);
								FormatWriter.showMessage(Message.MESSAGE02);
								break;
							case 2:
								FormatWriter.showMessage(Message.MESSAGE12);
								break;
							default:
								FormatWriter.showMessage(Message.MESSAGE16);
								continue;
							}
							break;
						}
					}
					else {
						continue;
					}
					break;
				}
				break;
			case 2:// �˻�
				ArrayList<Book> serchedbookList = new ArrayList<Book>();
				serchedbookList.clear();
				Map<Integer, String> updateContent = new HashMap<Integer, String>();
				updateContent.clear();
				
				FormatWriter.showMessage(Message.MESSAGE03);
				String serchValue = reader.readStringValue();
				serchedbookList = dao.searchBook(serchValue, serchedbookList);
				if (serchedbookList != null) {
					while (true) {
						FormatWriter.showMenu(Menu.MENU03);
						FormatWriter.showMessage(Message.MESSAGE09);
						int selectMenu2 = reader.readIntValue();
						switch (selectMenu2) {
						case 1:// ����
							int selectBookNo = selectBook(serchedbookList);
							while (true) {
								FormatWriter.showMenu(Menu.MENU04);
								FormatWriter.showMessage(Message.MESSAGE13);
								int seleteModifyMenu = reader.readIntValue();
								FormatWriter.showMessage(Message.MESSAGE17);
								switch (seleteModifyMenu) {
								case 1:
									String modifyBookName = reader.readStringValue();
									updateContent.put(1, modifyBookName);
									break;
								case 2:
									String modifyAuthor = reader.readStringValue();
									updateContent.put(2, modifyAuthor);
									break;
								case 3:
									String modifyPublisher = reader.readStringValue();
									updateContent.put(3, modifyPublisher);
									break;
								default:
									FormatWriter.showMessage(Message.MESSAGE16);
									continue;
								}
								FormatWriter.showMessage(Message.MESSAGE14);
								FormatWriter.showMenu(Menu.MENU02);
								if (continueOrNot()) {
									continue;
								}
								break;
							}
							dao.updateBook(selectBookNo, updateContent);
							FormatWriter.showMessage(Message.MESSAGE06);
							break;
						case 2:// ����
							int selectBookNo2 = selectBook(serchedbookList);
							while (true) {
								FormatWriter.showMessage(Message.MESSAGE07);
								FormatWriter.showMenu(Menu.MENU02);
								int deleteOrNot = reader.readIntValue();

								switch (deleteOrNot) {
								case 1:
									dao.deleteBook(selectBookNo2);
									FormatWriter.showMessage(Message.MESSAGE08);
									break;
								case 2:
									FormatWriter.showMessage(Message.MESSAGE12);
									break;
								default:
									FormatWriter.showMessage(Message.MESSAGE16);
									continue;
								}
								break;
							}
							break;
						case 3:// �ָ޴�
							break;
						case 4:// ����
							askExit();
							break;
						default:
							FormatWriter.showMessage(Message.MESSAGE16);
							continue;
						}
						break;
					}
				}
				else {
					FormatWriter.showMessage(Message.MESSAGE19);
				}
				break;
			case 3:// ��ü���
				dao.selectAll();
				break;
			case 4:// ����
				askExit();
				break;
			default:
				FormatWriter.showMessage(Message.MESSAGE16);
				break;
			}
		}
	}

	public void askExit() throws IOException {

		FormatWriter.showMessage(Message.MESSAGE18);
		while (true) {
			FormatWriter.showMenu(Menu.MENU02);
			int exitOrNot = reader.readIntValue();

			switch (exitOrNot) {
			case 1:
				FormatWriter.showMessage(Message.MESSAGE20);
				System.exit(0);
			case 2:
				break;
			default:
				FormatWriter.showMessage(Message.MESSAGE16);
				continue;
			}
			break;
		}
	}

	public boolean continueOrNot() throws IOException {
		while (true) {
			int continueOrNot = reader.readIntValue();
			switch (continueOrNot) {
			case 1:
				return true;
			case 2:
				return false;
			default:
				FormatWriter.showMessage(Message.MESSAGE16);
				continue;
			}
		}
	}

	public int selectBook(ArrayList<Book> serchedbookList) throws IOException {
		Book book;
		while (true) {
			FormatWriter.showMessage(Message.MESSAGE10);
			int selectBookNo = reader.readIntValue();
			book = dao.selectByNo(selectBookNo, serchedbookList);
			if (book != null) {
				return selectBookNo;
			} else {
				continue;
			}
		}
	}
}