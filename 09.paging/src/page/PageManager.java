package page;

public class PageManager {
	
	private int requestPage; //1
	
	public PageManager() {}
	
	public PageManager(int requestPage) {
		
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		//������ ����ؼ� �ֱ�
		//private int rowStartNumber; //ȭ�鿡 ������ ���� �ٹ�ȣ
		//private int rowEndNumber;  //ȭ�鿡 ������ �� �ٹ�ȣ
		pageRowResult.setRowStartNumber((PageInfo.ROW_COUNT_PER_PAGE*requestPage) - (PageInfo.ROW_COUNT_PER_PAGE - 1)); //1
//		pageRowResult.setRowStartNumber((requestPage-1)*PageInfo.ROW_COUNT_PER_PAGE+1); //1
		pageRowResult.setRowEndNumber((PageInfo.ROW_COUNT_PER_PAGE*requestPage)); //5
		
		return pageRowResult;
		
	}
	
	public PageGroupResult getPageGroupResult(int cnt) {
		//������ ����ؼ� �ֱ�
		//3���� �����ٰŴ�
		//[1,2,3]����
		//����[4,5,6]����
		//����[7,8,9]����
		//����[10,11]
		//private int groupStartNumber; //��ũ ���۹�ȣ
		//private int groupEndNumber; //��ũ ����ȣ
		PageGroupResult pgr = new PageGroupResult();
		int reqPageGroupNumber =  (int)Math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT); 
		pgr.setGroupStartNumber((reqPageGroupNumber * PageInfo.SHOW_PAGE_COUNT) - (PageInfo.SHOW_PAGE_COUNT-1));
		pgr.setGroupEndNumber(reqPageGroupNumber * PageInfo.SHOW_PAGE_COUNT);
		
		//ex)22�� 2�پ� =>��ũ:11�� ��ũ�׷� 3���� 
		int totalPageNumber = (int)Math.ceil((double)cnt/PageInfo.ROW_COUNT_PER_PAGE);
		System.out.println(cnt + "Ȯ�ο���");
		System.out.println(totalPageNumber + "Ȯ�ο���2");
		if(pgr.getGroupEndNumber() > totalPageNumber) {
			pgr.setGroupEndNumber(totalPageNumber);
		}
		
		//private boolean beforePage = true; //���� ��ũ
		if(pgr.getGroupStartNumber() == 1) {
			pgr.setBeforePage(false);
		}
		//private boolean afterPage = true; //���� ��ũ
		if(pgr.getGroupEndNumber() == totalPageNumber) {
			pgr.setAfterPage(false);
		}
		//private int selectPageNumber;  //���� ������
		pgr.setSelectPageNumber(requestPage);
		
		return pgr;
	}
	
	public static void main(String[] args) {
//		PageManager pm = new PageManager(4);
//		PageRowResult prr = pm.getPageRowResult();
//		
//		System.out.println(prr.getRowStartNumber()); //1 6 11
//		System.out.println(prr.getRowEndNumber()); //5 10 15
		
//		PageGroupResult pgr = pm.getPageGroupResult();
//		System.out.println(pgr.getGroupStartNumber());
//		System.out.println(pgr.getGroupEndNumber());
	}
	
}
