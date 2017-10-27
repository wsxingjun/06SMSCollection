package smscollection.com.example.a06smscollection;

import android.content.Intent;
import android.net.PskKeyManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lv_sms;
    private TextView tv;

    String[] objects = {
            "我的祝福最霸道，收到你就没烦恼，白天黑夜乐淘淘；我的短信最美好，看后愁闷都得跑，轻松愉快才逍遥；我的信息最牢靠，幸福吉祥来笼罩，美梦成真在今朝；我的祝愿最着调，生日当天有爆料，欢歌笑语总围绕！",
            "你在我的心中扎根，我们的友谊露重更深；你在我的牵挂中缤纷，我们的情感喜大普奔；你在我的坦诚中光临，我们的心有灵犀更近；你在我的问候中欢欣，我们的关爱情不自禁；你在我的祝福中兴奋，祝你生日快乐开心！",
            "好友如梦似幻，日夜兼程思念，亲朋血脉相连，话语滋润心田，知音一生有缘，牵手幸福永远，挚爱看雨听蝉，开心快乐无边，知己晓得冷暖，经常相互惦念，我心与你相牵，送你灿烂心愿，祝你生日圆满，谱写壮丽诗篇！"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.先找到listview控件
        lv_sms = (ListView) findViewById(R.id.lv_sms);

        //2.设置listView的点击事件
//        lv_sms.setOnClickListener((View.OnClickListener) this);

        //2.将数据内容显示到listView中
//        public ArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<T> objects)
//        resource:负责展示数据的layout文件
        tv = (TextView) findViewById(R.id.tv);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.activity_item, objects);
        lv_sms.setAdapter(stringArrayAdapter);
        //3.设置点击事件
        lv_sms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //3.1 获取短信的内容
                String content = objects[position];

                //3.2 点击该项目之后跳转到SMS界面
//        <intent-filter>
//               <action android:name="android.intent.action.SEND" />
//               <category android:name="android.intent.category.DEFAULT" />
//               <data android:mimeType="text/plain" />
//           </intent-filter>

                //跳转到短信输入框
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setType("text/plain");
                //跳转到输入联系人
//                Uri smsToUri = Uri.parse("smsto:");
//                Intent intent = new Intent(Intent.ACTION_SENDTO, smsToUri);

                intent.putExtra("sms_body", content);
                //4.开启意图
                startActivity(intent);

            }
        });

    }

}
