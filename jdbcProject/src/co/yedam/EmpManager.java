package co.yedam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmpManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		EmpDAO e = new EmpDAO();
		while(run) {
			
		System.out.print("1사원목록 2 사원등록 3 정보수정 4 사원삭제 5 종료");
		
		System.out.print("선택> ");
        int menu = Integer.parseInt(scn.nextLine());
		
        
        switch(menu) {
        
        case 1:        	
        	e.empList();        	        	
        	break;
        case 2:
        	System.out.println("사원명>>");
        	String name = scn.nextLine();
        	System.out.println("연락처>>");
        	String phone= scn.nextLine();
        	System.out.println("이메일>>");
        	String email = scn.nextLine();
        	System.out.println("급여>>");
        	String salary = scn.nextLine();
        	System.out.println("입사일자>>");
        	String hdate = scn.nextLine();
        	
        	
        	
        	Employee emp = new Employee();
        	emp.setEmpName(name);
        	emp.setPhone(phone);
        	emp.setEmail(email);
        	emp.setSalary(Integer.parseInt(salary));
        	
        	try {
        		DateFormat sdf0= new SimpleDateFormat("yyMMdd");
        		
				Date formatDate = sdf0.parse(hdate);
				
				emp.setHireDate(formatDate);	
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
        	
        	if(e.insertEmp(emp)) {
        		System.out.println("정상");
        	}
        	else{
        		System.out.println("오류");
        	}
        	
        	break;
        case 3:
        	
        	System.out.println("사원번호>>");
        	String eno = scn.nextLine();
        	System.out.println("이메일>>");
        	email = scn.nextLine();
        	System.out.println("급여>>");
        	salary = scn.nextLine();
        	
        	emp = new Employee();
        	emp.setEmpNo(Integer.parseInt(eno));
        	emp.setEmail(email);
        	emp.setSalary(Integer.parseInt(salary));;
        	
        	if(e.updateEmp(emp)) {
        		
        	}else {
        		
        	}
        	
        	break;
        case 4:
        	System.out.println("사원번호>>");
        	
        	eno = scn.nextLine();
        	int eeno = Integer.parseInt(eno);
        	
            if(e.deleteEmp(eeno)) {
        		
        	}else {
        		
        	}
        	break;
        case 5:
        	System.out.println("종료....");
        	run = false;
        }
		}
		
	}

}
