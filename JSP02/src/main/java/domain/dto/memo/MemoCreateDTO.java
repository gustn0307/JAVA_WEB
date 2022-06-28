package domain.dto.memo;

public class MemoCreateDTO {

	private String writer;
	private String content;
	
	public String getWriter() {
		return writer;
	}
	public String getContent() {
		return content;
	}
	
	public MemoCreateDTO() {
		// TODO Auto-generated constructor stub
	}
	//생성자를 통한 초기화
	public MemoCreateDTO(String writer, String content) {
		this.writer = writer;
		this.content = content;
	}
	
}