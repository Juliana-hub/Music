package cn.edu.scujcc.music;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerList extends AppCompatActivity {
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case songLab.PUT_IN_SUCCESS:
                    putInSuccess(msg.obj);
                    break;
                case songLab.PUT_IN_FAIL:
                    putInFail();
                    break;
            }
        }
    };

    private void putInFail() {
        Toast.makeText(PlayerList.this, "查询失败！", Toast.LENGTH_LONG).show();
    }

    private void putInSuccess(Object obj) {
        Toast.makeText(PlayerList.this, "查询成功！", Toast.LENGTH_LONG).show();
    }
    private static String NICE="yes";
    private ImageView heart;
    private TextView songName1;
    private song niceSong=song.getInstance();
    private songLab lab2=songLab.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        heart=findViewById(R.id.imageView20);
        songName1=findViewById(R.id.textView4);
        heart.setOnClickListener(v -> {
            niceSong.setSongId("001");
            niceSong.setSongName((String) songName1.getText());
            niceSong.setStatus(PlayerList.NICE);
            lab2.putIn(niceSong,handler);
        });
    }
}
