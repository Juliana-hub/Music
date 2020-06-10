package cn.edu.scujcc.music;

private static final String TAG=" ";
private static final int SEARCH_MUSIC_SUCCESS=0;
private ProgressDialog progressDialog=null;
private ListView musicListView;
private SimpleAdapter listAdapter;
private List<HashMap<String,String>> list=new ArrayList<>();


private TextView currtimeView;
private TextView totaltimeView;
private SeekBar seekBar;
private AlwaysMarqueeTextView nameView;
private ImageButton stop;

private String nameChecked;
private Uri uriChecked;

private int currPosition;//当前选中的list


private static final int IDLE=0;   //空闲：没有播放音乐
private static final int PAUSE=1;  //暂停：播放音乐时暂停
private static final int START=2;  //正在播放音乐

private static final int CURR_TIME_VALUE=1;

private int currState=IDLE;//当前播放器的状态
private boolean flag=false;//控制进度条的索引


//跳转页面
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Music_ing);

        Imgbutton button1 = (Button)findViewById(R.id.list);

        button1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        startActivity(new Intent(MainActivity2.this,MainActivity.class));
        }
        });


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicListView=(ListView)findViewById(android.R.id.list);
        currtimeView=(TextView)findViewById(R.id.currTime);
        totaltimeView=(TextView)findViewById(R.id.totalTime);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(currState==START){
        if(fromUser){
        currtimeView.setText(toTime(progress));
        }
        }
        }

@Override
public void onStartTrackingTouch(SeekBar seekBar) {
        mediaPlayer.pause();
        }

@Override
public void onStopTrackingTouch(SeekBar seekBar) {
        if(currState==START){
        mediaPlayer.seekTo(seekBar.getProgress());
        mediaPlayer.start();
        }
        }
        });

        nameView=(AlwaysMarqueeTextView)findViewById(R.id.nameDisplay);
        playBtn=(ImageButton)findViewById(R.id.play);

        mediaPlayer=new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
@Override
public void onCompletion(MediaPlayer mp) {
        if (musicListView.getCount() > 0) {
        next();
        } else {
        Toast.makeText(MainActivity.this, "播放列表为空", Toast.LENGTH_LONG).show();
        }
        }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
@Override
public boolean onError(MediaPlayer mp, int what, int extra) {
        mediaPlayer.reset();
        return false;
        }
        });
//         搜索MediaStore中的音频文件，填充list列表
        progressDialog=ProgressDialog.show(this,"","正在播放",true);
        searchMusicFile();

        }




        public void onPreviousClick(View v){
        last();
        }//上一曲

        private void last(){
        if(musicListView.getCount()>0){
        if(currPosition>0){
        switch (currState){
        case IDLE:
        musicListView.smoothScrollToPosition(currPosition - 1);
        musicListView.performItemClick(
        musicListView.getAdapter().getView(currPosition-1,null,null),
        currPosition-1,
        musicListView.getItemIdAtPosition(currPosition-1));
        break;
        case START:
        case PAUSE:
        stop();
        musicListView.smoothScrollToPosition(currPosition - 1);
        musicListView.performItemClick(
        musicListView.getAdapter().getView(currPosition - 1, null, null),
        currPosition - 1,
        musicListView.getItemIdAtPosition(currPosition-1));
        break;
        }
        }else{
        switch (currState) {
        case IDLE:
        musicListView.smoothScrollToPosition(musicListView.getCount() - 1);
        musicListView.performItemClick(
        musicListView.getAdapter().getView(musicListView.getCount()-1, null, null),
        musicListView.getCount()-1,
        musicListView.getItemIdAtPosition(musicListView.getCount()-1));
        break;
        case START:
        case PAUSE:
        stop();
        musicListView.smoothScrollToPosition(musicListView.getCount() - 1);
        musicListView.performItemClick(
        musicListView.getAdapter().getView(musicListView.getCount()-1, null, null),
        musicListView.getCount()-1,
        musicListView.getItemIdAtPosition(musicListView.getCount()-1));
        start();
        break;
        }
        }
        }
        }

public void onPreviousClick(View v){
        last();
        }//上一曲

private void next(){
        if(musicListView.getCount()>0){
        if(currPosition>0){
        switch (currState){
        case IDLE:
        musicListView.smoothScrollToPosition(currPosition + 1);
        musicListView.performItemClick(
        musicListView.getAdapter().getView(currPosition+1,null,null),
        currPosition+1,
        musicListView.getItemIdAtPosition(currPosition+1));
        break;
        case START:
        case PAUSE:
        stop();
        musicListView.smoothScrollToPosition(currPosition + 1);
        musicListView.performItemClick(
        musicListView.getAdapter().getView(currPosition + 1, null, null),
        currPosition +1,
        musicListView.getItemIdAtPosition(currPosition+1));
        break;
        }
        }else{
        switch (currState) {
        case IDLE:
        musicListView.smoothScrollToPosition(musicListView.getCount() + 1);
        musicListView.performItemClick(
        musicListView.getAdapter().getView(musicListView.getCount()+1, null, null),
        musicListView.getCount()+1,
        musicListView.getItemIdAtPosition(musicListView.getCount()+1));
        break;
        case START:
        case PAUSE:
        stop();
        musicListView.smoothScrollToPosition(musicListView.getCount() + 1);
        musicListView.performItemClick(
        musicListView.getAdapter().getView(musicListView.getCount()+1, null, null),
        musicListView.getCount()+1,
        musicListView.getItemIdAtPosition(musicListView.getCount()+1));
        start();
        break;
        }
        }
        }
        }