package com.cnLive.service;

import java.io.IOException;

public interface DownloadFromURLService {
	void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException;
}
