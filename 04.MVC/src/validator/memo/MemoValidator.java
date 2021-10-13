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
         errors.add("이름을 입력하세요");
      }
      
      String age = memoForm.getAge();
      if(age == null || age.trim().isEmpty()) {
         errors.add("나이를 입력하세요");
      } else {
         try {
            Integer.parseInt(age);
         } catch (NumberFormatException nfe) {
            errors.add("숫자의 형식으로 입력해주세요");
         }
      }
      return errors;
   }
   //v2 : 프로잭트할땐 이걸로 : 사용자의 편의성에 이게 더 좋음
   public MemoError validate_v2(MemoForm memoForm) {
	   MemoError memoError = new MemoError();
	   
	   String name = memoForm.getName();
	   
	   if(name == null || name.trim().isEmpty()) {
		   memoError.setNameErr("이름을 입력해주세요!");
		   memoError.setResult(true);
	   }
	      
	   String age = memoForm.getAge();
	      
	   if(age == null || age.trim().isEmpty()) {
		   memoError.setAgeErr("나이를 입력해주세요!");
		   memoError.setResult(true);
	   } else {
		   try {
			   Integer.parseInt(age);
		   } catch (NumberFormatException nfe) {
			   memoError.setAgeErr("숫자를 넣으세요!");
			   memoError.setResult(true);
	       }
	    }
	   
	   return memoError;
   }
}