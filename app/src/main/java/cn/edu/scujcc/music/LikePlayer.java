package cn.edu.scujcc.music;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class LikePlayer extends AppCompatActivity {
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case SingerLab.SINGER_FIND_SUCCESS:
                    putInSuccess(msg.obj);
                    break;
                case SingerLab.SINGER_FIND_FAIL:
                    putInFail();
                    break;
            }
        }
    };

    private void putInFail() {
        Toast.makeText(LikePlayer.this, "查询失败！", Toast.LENGTH_LONG).show();
    }

    private void putInSuccess(Object obj) {
        Toast.makeText(LikePlayer.this, "查询成功！", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_player);

    }
}
