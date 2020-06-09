package cn.edu.scujcc.music;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SingerPlayer extends AppCompatActivity {
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case SingerLab.SINGER_FIND_SUCCESS:
                    findSuccess(msg.obj);
                    break;
                case SingerLab.SINGER_FIND_FAIL:
                    findFail();
                    break;
            }
        }
    };

    private void findFail() {
        Toast.makeText(SingerPlayer.this, "查询失败！", Toast.LENGTH_LONG).show();
    }

    private void findSuccess(Object obj) {
        Toast.makeText(SingerPlayer.this, "查询成功！", Toast.LENGTH_LONG).show();
        singers= (List<Singer>) obj;
    }

    private Button button_nd;
    private Button button_gt;
    private Button button_om;
    private Button button_fz;
    private TextView singer1name;
    private TextView singer2name;
    private TextView singer1fans;
    private TextView singer2fans;
    private String area1;
    private Singer singer1;
    private Singer singer2;
    private List<Singer> singers;
    private SingerLab lab=SingerLab.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer_player);
        button_nd=findViewById(R.id.btn15);
        singer1name=findViewById(R.id.text6);
        singer2name=findViewById(R.id.text8);
        singer1fans=findViewById(R.id.text10);
        singer2fans=findViewById(R.id.text11);
        button_nd.setOnClickListener(v -> {
            area1 = button_nd.getText().toString();
            lab.findNdMusic(area1,handler);
            singer1=singers.get(0);
            singer1name.setText(singer1.getName());
            singer1fans.setText(singer1.getFans());
            singer2name.setText(singer2.getName());
            singer2fans.setText(singer2.getFans());
        });
    }
}
