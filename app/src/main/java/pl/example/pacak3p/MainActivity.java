package pl.example.pacak3p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int widoczny;
    private int licznik=0;
    private int czas=20;
    private int[] obrazkiId = {R.id.imageView,
            R.id.imageView2,
            R.id.imageView3,
            R.id.imageView4,
            R.id.imageView5,
            R.id.imageView6,
            R.id.imageView7,
            R.id.imageView8,
            R.id.imageView9 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wylosuj();


    }
    void pokazTen(int i){
        for(int id:obrazkiId){
            ImageView tenObrazek = (ImageView) findViewById(id);
            tenObrazek.setVisibility(View.INVISIBLE);
        }
        ImageView tenObrazek = (ImageView) findViewById(obrazkiId[i]);
        tenObrazek.setVisibility(View.VISIBLE);
        tenObrazek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                licznik++;
                TextView tekst2= (TextView)findViewById(R.id.textView2);
                tekst2.setText(Integer.toString(licznik));
                tenObrazek.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void wylosuj(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                widoczny = (int)(Math.random()*9);
                pokazTen(widoczny);
                czas--;
                TextView tekst1=(TextView)findViewById(R.id.textView1);
                tekst1.setText(Integer.toString(czas/2));
                if(czas>=0) {
                    handler.postDelayed(this, 500);
                }
            }
        });
    }
}