package oopEx1;
/*
 * 테란을 위한 SteamPack 기능을 선언합니다.
 */
public interface TerranSteamPack {
	
	//인터페이스 내부에는 목적에 따라 클래스를 저으이 할 수 있습니다.
	//이러한 클래스를 중첩(Nested) 클래스라고 하는데,
	//나중에 따로 다시 공부 할 겁니다.(무지하게 지겹습니다.)....
	//여튼 지금은 inner Class 를 정의해서, 외부에서 해당 클래스를
	//객체화 하여 구현 할 수 있도록 할 예정입니다.
	
	//마린과 파이어벳은 스팀팩을 사용가능합니다.
	
	class SteamPack{
		Terran terran;
		public SteamPack(Terran theUnit) {
			if((theUnit instanceof Marine) || (theUnit instanceof FireBet))
				this.terran = theUnit;
		}
		public void steamPack() {
			System.out.println("스팀팩을 이용해서 공격합니다. 체력-10%, 공격력+10%");
		}
	}
}
