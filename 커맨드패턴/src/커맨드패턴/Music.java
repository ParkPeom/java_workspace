package Ŀ�ǵ�����;

interface Command {
	String execute();
}


/* 1. Ŀ�ǵ� ��ü : �ൿ�� �����ϴ� ��ü
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

// 2. Music�� ��� �ൿ�� ��� �ִ� ������ Ŭ����
// �����ϰ� ������ Ű�� ���� ������ �����ҽ��ϴ�
// ������ ����ϴ� ��ü�� ������.
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

// 3. Ŀ�ǵ� ��ü ����
// ������ Ű�� MusicOnCommand ��ü �� ������ ���� MusicOnCommand ��ü
// �������� ������ �����ϰ� �ش� ����� ������ ���Դϴ�.
class RemoteController {
	private Command command;
	
	//  �������� ������ ����
	public void setCommand(final Command command) {
		this.command = command;
	}
	// �ش� ����� ����
	public String pressButton() {
		return command.execute();
	}
}

// 4. �ߵ��� ��ü ����
// Ŀ�ǵ忡 ���� ������ �����ϰ� ��ư�� ������ �������� ����
// �������� ���忡���� ���� ��ư�� ������ ����� ����ǰ� ���δ�.

class RemoteControllerTest {
	private RemoteController controller;
	
	void setUp() {
		controller = new RemoteController();
	}
	
	void ����������_������_��������_�׽�Ʈ() {
		 /* Given */
		MusicOffCommand musicOffCommand = new MusicOffCommand(new Music());
		/* When */
		controller.setCommand(musicOffCommand);
		 /* Then */
		assertThat(controller.pressButton()).isEqualsTo("play off Music!!");
	}
	
	void ����������_������_��������_�׽�Ʈ() {
		/* Given */
		 MusicOnCommand musicOnCommand = new MusicOnCommand(new Music());
		/* When */
		 controller.setCommand(musicOnCommand);
		/* Then */
		 assertThat(controller.pressButton()).isEqualsTo("play off Music!!");
	}
	//5. ���ǻ� Client ��ü�� Test Code�� �ϰڽ��ϴ�.
}




