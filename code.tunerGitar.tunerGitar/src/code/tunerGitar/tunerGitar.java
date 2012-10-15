package code.tunerGitar;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class tunerGitar extends Activity {

	private static final String isPlaying = "Kamu mendengarkan ";
	private MediaPlayer player;
	private Button EButton;
	private Button BButton;
	private Button GButton;
	private Button DButton;
	private Button AButton;
	private Button E2Button;
	private Button keluar;
	TextView keterangan;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		EButton = (Button) this.findViewById(R.id.stringE);
		EButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				playSound(1);
			}
		});
		BButton = (Button) this.findViewById(R.id.stringB);
		BButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				playSound(2);
			}
		});
		GButton = (Button) this.findViewById(R.id.stringG);
		GButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				playSound(3);
			}
		});
		DButton = (Button) this.findViewById(R.id.stringD);
		DButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				playSound(4);
			}
		});
		AButton = (Button) this.findViewById(R.id.stringA);
		AButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				playSound(5);
			}
		});
		E2Button = (Button) this.findViewById(R.id.stringE1);
		E2Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				playSound(6);
			}
		});
		keluar = (Button) this.findViewById(R.id.keluar);
		keluar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				tunerGitar.this.finish();
			}
		});
		keterangan = (TextView) this.findViewById(R.id.keterangan);
	}

	@Override
	public void onPause() {
		try {
			super.onPause();
			player.pause();
		} catch (Exception e) {
		}
	}

	public void onStop() {
		super.onStop();
		player.stop();
	}

	private void playSound(int arg) {
		try {
			if (player.isPlaying()) {
				player.stop();
				player.release();
			}
		} catch (Exception e) {
			Toast.makeText(this, e.toString(), 
					Toast.LENGTH_SHORT).show();
		}
		if (arg == 1) {
			Toast.makeText(this, isPlaying + "String E", 
					Toast.LENGTH_SHORT).show();
			player = MediaPlayer.create(this, R.raw.e3);
			keterangan.setText(isPlaying + "String E");
		} else if (arg == 2) {
			Toast.makeText(this, isPlaying + "String B", 
					Toast.LENGTH_SHORT).show();
			player = MediaPlayer.create(this, R.raw.b2);
			keterangan.setText(isPlaying + "String B");
		} else if (arg == 3) {
			Toast.makeText(this, isPlaying + "String G", 
					Toast.LENGTH_SHORT).show();
			player = MediaPlayer.create(this, R.raw.g2);
			keterangan.setText(isPlaying + "String G");
		} else if (arg == 4) {
			Toast.makeText(this, isPlaying + "String D",
					Toast.LENGTH_SHORT).show();
			player = MediaPlayer.create(this, R.raw.d2);
			keterangan.setText(isPlaying + "String D");
		} else if (arg == 5) {
			Toast.makeText(this, isPlaying + "String A",
					Toast.LENGTH_SHORT).show();
			player = MediaPlayer.create(this, R.raw.a1);
			keterangan.setText(isPlaying + "String A");
		} else if (arg == 6) {
			Toast.makeText(this, isPlaying + "String E", 
					Toast.LENGTH_SHORT).show();
			player = MediaPlayer.create(this, R.raw.e1);
			keterangan.setText(isPlaying + "String E");
		}
		player.setLooping(true);
		player.start();
	}
}
