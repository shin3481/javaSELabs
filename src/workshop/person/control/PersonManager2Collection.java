package workshop.person.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workshop.person.entity.PersonEntity;

public class PersonManager2Collection {

	public static void main(String[] args) {
		System.out.println("==> 성별 정보를 입력하세요!");
		//Scaner 객체생성
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.next();
		char gender = inputValue.charAt(0); //String => char
		
		System.out.println("==> 이름을 입력하세요!");
		String name = scanner.next();
		
		System.out.println(String.format("==> 입력하신 성별은 %s, 이름은%s", gender, name) + "\n");
		
		scanner.close();
		
		PersonManager2Collection personMgr = new PersonManager2Collection();
		
		//배열선언 및 초기화
		//PersonEntity[] persons = new PersonEntity[10];
		List<PersonEntity> personList = new ArrayList<>();
		
		//persons변수는 PersonEntity[]타입이고, persons[0]은 PersonEntity타입이다.
		personMgr.fillPersons(personList);
		
		
		personMgr.printTitle("인물정보 조회시스템");
		personMgr.showPerson(personList);
		
		String message = String.format("성별 : %s (은)는  %d 명 입니다.", gender,personMgr.findByGender(personList, gender));
		System.out.println(message);
		
		personMgr.showPerson(personList, name);
		
	}
	public void showPerson(List<PersonEntity> persons,String name) {
		for(PersonEntity person:persons) {
			if(person.getName().equals(name)){
				System.out.println("[이름] " + person.getName());
				System.out.println("[성별] " + person.getGender());
				System.out.println("[전화번호] " + person.getPhone());
				System.out.println("[주소] " + person.getAddress());
				break;
			}
		}
	}
	
	public int findByGender(List<PersonEntity> persons, char gender) {
		int genderCnt = 0;
		for(PersonEntity preson: persons) {
			if(preson.getGender() == gender) {
				genderCnt++;
			}
		}
		return genderCnt;
		
	}
	
	public void showPerson(List<PersonEntity> persons) {
		//for loop를 순회하면서
		for(PersonEntity person:persons) {
			System.out.println("[이름] "+person.getName()+"\t [성별] " + person.getGender()+ "\t [전화번호] "+person.getPhone());
		}
	}
	
	public void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932"));
		persons.add(new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932"));
		persons.add(new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542"));
		persons.add(new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223"));
		persons.add(new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333"));
		persons.add(new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934"));
		persons.add(new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932"));
		persons.add(new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939"));
		persons.add(new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202"));
		persons.add(new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832"));
	}                                                                                       
	
	public void printTitle(String title) {
		System.out.println("@@@@ " + title + " @@@@");
		System.out.println();

	}

}
