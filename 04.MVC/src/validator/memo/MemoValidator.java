package validator.memo;

import java.util.ArrayList;
import java.util.List;

import form.memo.MemoForm;
import formError.MemoError;
	//v1
public class MemoValidator {
   public List<String> validate(MemoForm memoForm){
      List<String> errors = new ArrayList<>();
      String name = memoForm.getName();
      if(name == null || name.trim().isEmpty()) {
         errors.add("�̸��� �Է��ϼ���");
      }
      
      String age = memoForm.getAge();
      if(age == null || age.trim().isEmpty()) {
         errors.add("���̸� �Է��ϼ���");
      } else {
         try {
            Integer.parseInt(age);
         } catch (NumberFormatException nfe) {
            errors.add("������ �������� �Է����ּ���");
         }
      }
      return errors;
   }
   //v2 : ������Ʈ�Ҷ� �̰ɷ� : ������� ���Ǽ��� �̰� �� ����
   public MemoError validate_v2(MemoForm memoForm) {
	   MemoError memoError = new MemoError();
	   
	   String name = memoForm.getName();
	   
	   if(name == null || name.trim().isEmpty()) {
		   memoError.setNameErr("�̸��� �Է����ּ���!");
		   memoError.setResult(true);
	   }
	      
	   String age = memoForm.getAge();
	      
	   if(age == null || age.trim().isEmpty()) {
		   memoError.setAgeErr("���̸� �Է����ּ���!");
		   memoError.setResult(true);
	   } else {
		   try {
			   Integer.parseInt(age);
		   } catch (NumberFormatException nfe) {
			   memoError.setAgeErr("���ڸ� ��������!");
			   memoError.setResult(true);
	       }
	    }
	   
	   return memoError;
   }
}