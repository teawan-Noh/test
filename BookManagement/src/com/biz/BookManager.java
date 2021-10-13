package com.biz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dao.ArrayListBookDataAccessDaoImpl;
import com.dao.BookDataAccessDao;
import com.dao.OracleBookDataAccessDaoImpl;
import com.db.JDBCUtil;
import com.dto.Book;
import com.view.FormatWriter;
import com.view.InputValueReader;
import com.view.Menu;
import com.view.Message;

//도서관리 시스템 로직부분
public class BookManager {
	// 더이상 객체 변수 선언하지 마시오.
	InputValueReader reader = new InputValueReader();
	
//	BookDataAccessDao dao = new ArrayListBookDataAccessDaoImpl();
	//디비연결 
	BookDataAccessDao dao = new OracleBookDataAccessDaoImpl();

	public void start() throws IOException {
		//필요한건지 확인
//		ArrayList<Book> bookList = null;
		
		while (true) {
			FormatWriter.showMenu(Menu.MENU01);
			FormatWriter.showMessage(Message.MESSAGE09);
			int selectMenu = reader.readIntValue();
			switch (selectMenu) {
			case 1:// 저장
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
			case 2:// 검색
				ArrayList<Book> serchedbookList = null;
				Map<Integer, String> updateContent = new HashMap<Integer, String>();
				Book book = null;
				
				FormatWriter.showMessage(Message.MESSAGE03);
				String searchValue = reader.readStringValue();
				try {
					serchedbookList = dao.searchBookByName(searchValue);
					FormatWriter.showBookList(serchedbookList);
				}
				catch (NullPointerException e) {
					FormatWriter.showMessage(Message.MESSAGE19);
					continue;
				}
				if (!serchedbookList.isEmpty()) {
					while (true) {
						FormatWriter.showMenu(Menu.MENU03);
						FormatWriter.showMessage(Message.MESSAGE09);
						int selectMenu2 = reader.readIntValue();
						switch (selectMenu2) {
						case 1:// 수정
							FormatWriter.showMessage(Message.MESSAGE10);
							int selectBookNo = reader.readIntValue();
							book = dao.selectByNo(selectBookNo);
							if(book == null) {
								FormatWriter.showMessage(Message.MESSAGE19);
								continue;
							}
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
						case 2:// 삭제
							FormatWriter.showMessage(Message.MESSAGE10);
							int selectBookNo2 = reader.readIntValue();
							book = dao.selectByNo(selectBookNo2);
							if(book == null) {
								FormatWriter.showMessage(Message.MESSAGE19);
								continue;
							}
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
						case 3:// 주메뉴
							break;
						case 4:// 종료
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
			case 3:// 전체출력
				serchedbookList = dao.selectAll();
				FormatWriter.showBookList(serchedbookList);
				break;
			case 4:// 종료
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
}
