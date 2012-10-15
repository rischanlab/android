package com.login.db;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TampilJadwal extends Activity {
	JSONObject jObject;
	TextView txtResult;
	//private String xResult = "";
	private String url = "http://10.0.2.2/android/jadwalKuliah.php";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tampil_jadwal);

		txtResult = (TextView) findViewById(R.id.Txt_tampilJadwal);
		String hasil=null;
		try {
			hasil = ClientToServer.eksekusiHttpGet(url);
			String r=hasil.toString();
			r=r.trim();
			String dt="";
			String[] a=r.split("#");
			for(int i=0;i<a.length;i++){
				dt += a[i];
			}
			
			txtResult.setText(dt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*xResult = getRequest(url);
		try {
			parse(txtResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}

	/*private void parse(TextView txtResult) throws Exception {
		jObject = new JSONObject(xResult);
		
		JSONArray menuitemArray = jObject.getJSONArray("jadwal");// dari php
		String sret = "";
		sret = menuitemArray.getJSONObject(1).getString().toString();
		for (int i = 0; i < menuitemArray.length(); i++) {
			// mata_kuliah dari output php
			sret += menuitemArray.getJSONObject(i).getString("mata_kuliah")
					.toString()
					+ "\n";
			sret += "Hari : "
					+ menuitemArray.getJSONObject(i).getString("hari")
							.toString() + "\n";
			sret += "Jam : "
					+ menuitemArray.getJSONObject(i).getString("jam")
							.toString() + "\n";
			sret += "Ruang : "
					+ menuitemArray.getJSONObject(i).getString("ruang")
							.toString() + "\n";
		}
		Toast.makeText(this, sret, Toast.LENGTH_SHORT).show();
		txtResult.setText(sret);
	}

	public String getRequest(String Url) {

		String sret = "";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(Url);
		try {
			HttpResponse response = client.execute(request);
			sret = request(response);
			Toast.makeText(this, "Berhasil " + sret, Toast.LENGTH_SHORT).show();
			txtResult.setText(sret);

		} catch (Exception ex) {
			Toast.makeText(this, "Gagal " + sret, Toast.LENGTH_SHORT).show();

		}
		return url;

	}

	public static String request(HttpResponse respon) {
		String result = "";
		try {
			InputStream in = respon.getEntity().getContent();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			StringBuilder str = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				str.append(line + "\n");
			}
			in.close();
			result = str.toString();
		} catch (Exception ex) {
			result = "Error";
		}
		return result;

	}*/

}
