package cn.yan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Song {
	private String url;
	private String title;
	private Long commentCount;
}
