package lab.tank.swing;
//�Ϲ� ����Ŭ����    //Ŭ�����ȿ� Ŭ������ ���� �� �ִ� �޼ҵ� �ȿ� Ŭ������ ���� �� �ִ�  // �𸣸� �Ѿ�� �ȴ� 
//���� ����Ŭ����   //�����ϴ� ������ �ص� �ȴ�
//���� ����Ŭ����
//�͸� ����Ŭ����

public class Outer {

	int outData = 100;
	static int staticOutData = 500;
	final int finalOutData = 700;
	
	public void printOuter() {
		
		System.out.println("OuterŬ������ printOuter() �޼ҵ� ȣ��");
	}
	
	public static void staticPrintOuter() {
		
		System.out.println("OuterŬ������ staticPrintOuter() �޼ҵ� ȣ��");
	}
	
	//�Ϲ� ���� Ŭ����
	class Inner {
		
		int inData = 200;
		
		public void printInner() {
			System.out.println(inData);
			
			System.out.println(outData); //�ܺ�Ŭ������ ������ ������ �� �� �ִ�.
			System.out.println(staticOutData);
			System.out.println(finalOutData);
			
			printOuter();       //�ܺ�Ŭ������ �޼ҵ� ������ �� �� �ִ�.
			staticPrintOuter();
		}
	}
	
	//���� ����Ŭ���� : �ܺ� Ŭ������ static �����͸� ����� �� �ִ�
	static class StaticInner {
		
		int inData = 200;
		
		public void printInner() {
			System.out.println(inData);
			
			//System.out.println(outData);  //staticŬ�������� �ڱ�Ͱ� static�� ������ �� �� �ִ�
			System.out.println(staticOutData);
			//System.out.println(finalOutData);  //staticŬ�������� �ڱ�Ͱ� static�� ������ �� �� �ִ�
			
			//printOuter();       
			staticPrintOuter();	 //staticŬ�������� �ڱ�Ͱ� static�� ������ �� �� �ִ�
		}
	}
	//���� ���� Ŭ���� : �޼ҵ� �ȿ� ����� Ŭ���� 
	Object getLocal() {
		int localData = 10;
		final int finalLocalData = 5;
		
		class Local{
			
			public String toString() {
				String temp = "";
				temp += "\n Outer Ŭ������ �ν��Ͻ� ������ = " + outData;  //outData : �ܺ� Ŭ������ ����
				temp += "\n Outer Ŭ������ static ������ = " + staticOutData;  //staticOutData : �ܺ� Ŭ������ ����
				temp += "\n Outer Ŭ������ final ������ = " + finalOutData;  //finalOutData : �ܺ� Ŭ������ ����
				
				temp += "\n getLocal()�� non-final ������ = " + localData;  //localData : �޼ҵ��� �����ȿ� ����
				temp += "\n getLocal()�� final ������ = " + finalLocalData;  //finalLocalData : �޼ҵ��� �����ȿ� ����
				
				return temp;
			}
		}
		
		return new Local();
	}
	
	//�͸��� Ŭ����
	Object getAnoymous() {
		
		int localData = 10;
		final int finalLocalData = 5;
		
		return (new Object() { //Object �ڸ��� �������̽��� �´�
			
			public String toString() {
				String temp = "";
				temp += "\n Outer Ŭ������ �ν��Ͻ� ������ = " + outData;  //outData : �ܺ� Ŭ������ ����
				temp += "\n Outer Ŭ������ static ������ = " + staticOutData;  //staticOutData : �ܺ� Ŭ������ ����
				temp += "\n Outer Ŭ������ final ������ = " + finalOutData;  //finalOutData : �ܺ� Ŭ������ ����
				
				temp += "\n getLocal()�� non-final ������ = " + localData;  //localData : �޼ҵ��� �����ȿ� ����
				temp += "\n getLocal()�� final ������ = " + finalLocalData;  //finalLocalData : �޼ҵ��� �����ȿ� ����
				
				return temp;
			}
		});
		
	}
}
