package com.login.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ClientToServer {
	public static final int HTTP_TIMEOUT = 30 * 1000;
	private static HttpClient httpClient;

	private static HttpClient getHttpClient() {
		if (httpClient == null) {
			httpClient = new DefaultHttpClient();
			final HttpParams parameterHttp = httpClient.getParams();
			HttpConnectionParams.setConnectionTimeout(parameterHttp,
					HTTP_TIMEOUT);
			ConnManagerParams.setTimeout(parameterHttp, HTTP_TIMEOUT);

		}
		return httpClient;

	}

	public static String eksekusiHttpPost(String url,
			ArrayList<NameValuePair> postParameters) throws Exception {
		BufferedReader in = null;
		try {
			HttpClient client = getHttpClient();
			HttpPost req = new HttpPost(url);
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
					postParameters);
			req.setEntity(formEntity);
			HttpResponse respon = client.execute(req);
			in = new BufferedReader(new InputStreamReader(respon.getEntity()
					.getContent()));

			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			String hasil = sb.toString();
			return hasil;
		} finally {
			if (in != null) {
				in.close();
			}

		}

	}
	public static String eksekusiHttpGet(String url)throws Exception{
		BufferedReader in=null;
		try{
			HttpClient client=getHttpClient();
			HttpGet req=new HttpGet();
			req.setURI(new URI(url));
			HttpResponse respon=client.execute(req);
			in=new BufferedReader(new InputStreamReader(respon.getEntity().getContent()));
			
			StringBuffer sb=new StringBuffer("");
			String line="";
			String NL=System.getProperty("line.separator");
			while((line=in.readLine())!=null){
				sb.append(line+NL);
			}
			in.close();
			String hasil=sb.toString();
			return hasil;
			
		}finally{
			if(in!=null){
				in.close();
			}
		}
		
		
	}

}
