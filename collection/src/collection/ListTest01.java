package collection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
	public static void main(String[] args) {
//		(Collection)List 순서를 유지하고 저장, 중복 저장 가능 ex) ArrayList, Vector, LinkedList
//		(Collection)Set 순서를 유지하지하지 않고 저장, 중복 저장 안됨 ex) HashSet, TreeSet
//		Map 키와 값을 쌍으로 저장, 키는 중복 저장 안됨 ex) HashSet, TreeMap, Hashtable, Properties
		 
		List<Member> list=new ArrayList<>();
		// 무한 저장가능
		// 데이터 타입을 구분하지 않는다(관리가 힘듦)
		// 제네릭 표현을 사용하지 않으면 데이터를 읽을때 캐스팅 -> 결국 무한 저장 가능한 배열인 느낌
		// 일괄 처리가 힘듦
		
		// 데이터 입력
		Member mem=new Member();
		mem.setNo(1);
		mem.setEmail("이메일");
		mem.setPass("1234");
		mem.setNick_name("별명");
		mem.setCreated_date(new Timestamp(System.currentTimeMillis()));
		
		mem.setNo(2);
		mem.setEmail("이메일2");
		mem.setPass("2222");
		mem.setNick_name("별명2");
		mem.setCreated_date(new Timestamp(System.currentTimeMillis()));
		
		// 데이터 삽입
		list.add(new Member());
		
		// (구성요소를 저장 가능한 변수 선언 : 콜렉션 or 배열)
		for(Member m : list) {
			System.out.print(m.getNo()+" : ");
			System.out.print(m.getEmail()+" : ");
			System.out.print(m.getPass()+" : ");
			System.out.print(m.getNick_name()+" : ");
			System.out.println(m.getCreated_date()+" : ");
		}
		
		System.out.println("----------------------------");
		Member m1 = list.get(0);
		
		System.out.print(m1.getNo()+" : ");
		System.out.print(m1.getEmail()+" : ");
		System.out.print(m1.getPass()+" : ");
		System.out.print(m1.getNick_name()+" : ");
		System.out.print(m1.getCreated_date()+" : ");
		
		list.remove(0);
	}
}
