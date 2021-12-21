package 커맨드패턴;

interface Command {
	String execute();
}


/* 1. 커맨드 객체 : 행동을 수행하는 객체
 * 
 */
public class Music {
	String on() {
		return "play Music!!";
	}
	String off() {
		return "play off Music!!";
	}
}

// 2. Music의 모든 행동이 담겨 있는 수신자 클래스
// 간단하게 음악을 키고 끄는 행위를 만들어보았습니다
// 행위를 담당하는 객체를 만들어본다.
class MusicOnCommand implements Command {
	private final Music music;

	MusicOnCommand(final Music music) {
		this.music = music;
	}
	@Override
	public String execute() {
		return music.on();
	}
}
class MusicOffCommand implements Command {
	private final Music music;
	
	public MusicOffCommand(final Music music) {
		this.music = music;
	}
	@Override
	public String execute() {
		return music.off();
	}
}

// 3. 커맨드 객체 생성
// 음악을 키는 MusicOnCommand 객체 와 음악을 끄는 MusicOnCommand 객체
// 수신자의 정보를 저장하고 해당 기능을 수행할 것입니다.
class RemoteController {
	private Command command;
	
	//  수신자의 정보를 저장
	public void setCommand(final Command command) {
		this.command = command;
	}
	// 해당 기능을 수행
	public String pressButton() {
		return command.execute();
	}
}

// 4. 발동자 객체 생성
// 커맨드에 대한 정보를 저장하고 버튼을 누르는 리모컨을 제작
// 리모컨의 입장에서는 그저 버튼을 누르면 기능이 수행되게 보인다.

class RemoteControllerTest {
	private RemoteController controller;
	
	void setUp() {
		controller = new RemoteController();
	}
	
	void 리모컨에서_음악이_꺼지는지_테스트() {
		 /* Given */
		MusicOffCommand musicOffCommand = new MusicOffCommand(new Music());
		/* When */
		controller.setCommand(musicOffCommand);
		 /* Then */
		assertThat(controller.pressButton()).isEqualsTo("play off Music!!");
	}
	
	void 리모컨에서_음악이_켜지는지_테스트() {
		/* Given */
		 MusicOnCommand musicOnCommand = new MusicOnCommand(new Music());
		/* When */
		 controller.setCommand(musicOnCommand);
		/* Then */
		 assertThat(controller.pressButton()).isEqualsTo("play off Music!!");
	}
	//5. 편의상 Client 객체를 Test Code로 하겠습니다.
}




