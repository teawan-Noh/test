package model.memo;

public class Memo {
	private int memoid;
	private String name;
	private int age;
	
	public Memo() {}
	
	public Memo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Memo(int memoid, String name, int age) {
		super();
		this.memoid = memoid;
		this.name = name;
		this.age = age;
	}

	public int getMemoid() {
		return memoid;
	}
	public void setMemoid(int memoid) {
		this.memoid = memoid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Memo [memoid=" + memoid + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
//	create table memo(
//			memoid number primary key,
//			name varchar2(50),
//			age number(5)
//		);

//		create sequence seqMemo;
//
//		select memoid, name, age from memo;
//		select memoid, name, age from memo where memoid = ?;
//		insert into memo values (seqMemo.nextval, ?, ?);
//		insert into memo values (seqMemo.nextval, '타미', 10);
//		insert into memo values (seqMemo.nextval, '줄리엣', 17);
//
//		update memo set name = ?, age = ? where memoid = ?;
//		update memo set name = '타미2', age = 12 where memoid = 1;
//
//		delete from memo where memoid = ?;
//		delete from memo where memoid = 1;
	
}
