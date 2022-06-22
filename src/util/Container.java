package util;

import board.service.NoticeService;

public class Container {
	public static NoticeService noticeService;
	static {
		noticeService = new NoticeService();
	}

}
